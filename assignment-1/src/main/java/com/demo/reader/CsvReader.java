package com.demo.reader;

import com.demo.model.User;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.core.io.ClassPathResource;

public class CsvReader extends FlatFileItemReader<User>{
    public CsvReader() {
        this.setResource(new ClassPathResource("exams.csv"));
        this.setLineMapper(getLineMapper());
        this.setLinesToSkip(1);
    }

    private LineMapper<User> getLineMapper() {
        return new LineMapper<User>() {
            @Override
            public User mapLine(String line, int lineNumber) throws Exception {
                return null;
            }
        };
    }
}
