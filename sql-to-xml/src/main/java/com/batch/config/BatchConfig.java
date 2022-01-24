package com.batch.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import com.batch.mapper.PersonRowMapper;
import com.batch.processor.PersonItemProcessor;
import com.batch.reader.DbReader;
import com.batch.writer.XmlWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import com.batch.model.Person;

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
	public DbReader reader(){
		return new DbReader(dataSource);
	}
	
	@Bean
	public PersonItemProcessor processor(){

		return new PersonItemProcessor();
	}
	
	@Bean
	public XmlWriter writer(){
		return new XmlWriter();
	}
	
	@Bean
	public Step step1(){
		return stepBuilderFactory
				.get("step1")
				.<Person,Person>chunk(5)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}

	@Bean
	public Job exportPersonJob(){
		return jobBuilderFactory
				.get("exportPeronJob")
				.incrementer(new RunIdIncrementer())
				.flow(step1())
				.end()
				.build();
	}
}