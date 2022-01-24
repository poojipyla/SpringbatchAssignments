package com.mysqltocsv.config;

import com.mysqltocsv.model.User;
import com.mysqltocsv.processor.UserItemProcessor;
import com.mysqltocsv.reader.DbReader;
import com.mysqltocsv.writer.CsvWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private DataSource dataSource;

    @Bean
    public DbReader reader() {
        return new DbReader(dataSource);
    }

    @Bean
    public UserItemProcessor processor(){

        return new UserItemProcessor();
    }

    @Bean
    public CsvWriter writer() {

        return new CsvWriter();
    }

    @Bean
    public Step step1(){
        return stepBuilderFactory.get("step1").<User,User> chunk(100)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }
    @Bean
    public Job exportUserJob(){
        return jobBuilderFactory.get("exportUserJob").incrementer(new RunIdIncrementer())
                .flow(step1())
                .end()
                .build();
    }
}
