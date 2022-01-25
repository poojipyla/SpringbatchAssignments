package com.demo.mapper;

import com.demo.model.User;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;

public class LineMapper extends DefaultLineMapper<User>{
    public LineMapper(){
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames(new String[]{"gender","race","parental_level_of_education","test_preparation_course","math_score"});
        lineTokenizer.setIncludedFields(new int[]{0,1,2,4,5});
        BeanWrapperFieldSetMapper<User> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(User.class);
        this.setLineTokenizer(lineTokenizer);
        this.setFieldSetMapper(fieldSetMapper);
    }
}
