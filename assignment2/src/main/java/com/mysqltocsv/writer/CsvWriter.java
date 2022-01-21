package com.mysqltocsv.writer;

import com.mysqltocsv.model.User;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.ClassPathResource;

public class CsvWriter extends FlatFileItemWriter<User>{

    public CsvWriter() {

        this.setResource(new ClassPathResource("data.csv"));
        DelimitedLineAggregator<User> lineAggregator=new DelimitedLineAggregator<User>();
        lineAggregator.setDelimiter(",");
        BeanWrapperFieldExtractor<User> fieldExtractor=new BeanWrapperFieldExtractor<User>();
        fieldExtractor.setNames(new String[]{"gender","race","parental_level_of_education","test_preparation_course","math_score"});
        lineAggregator.setFieldExtractor(fieldExtractor);
        this.setLineAggregator(lineAggregator);
    }
}
