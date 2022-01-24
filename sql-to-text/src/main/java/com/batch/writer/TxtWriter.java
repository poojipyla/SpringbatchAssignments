package com.batch.writer;

import com.batch.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.ClassPathResource;

@Slf4j
public class TxtWriter extends FlatFileItemWriter<Person>{
    public TxtWriter() {
        log.info("TxtWriter()-started");
        this.setResource(new ClassPathResource("person.txt"));
        DelimitedLineAggregator<Person> lineAggregator=new DelimitedLineAggregator<Person>();
        lineAggregator.setDelimiter(",");
        BeanWrapperFieldExtractor<Person> fieldExtractor=new BeanWrapperFieldExtractor<Person>();
        fieldExtractor.setNames(new String[]{"id","name"});
        lineAggregator.setFieldExtractor(fieldExtractor);
        this.setLineAggregator(lineAggregator);
        log.info("TxtWriter()-completed");
    }
}