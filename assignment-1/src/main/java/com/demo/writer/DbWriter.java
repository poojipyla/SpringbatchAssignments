package com.demo.writer;

import com.demo.model.User;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import javax.sql.DataSource;

public class DbWriter extends JdbcBatchItemWriter<User>{
    public DbWriter(DataSource dataSource) {
        this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<User>());
        this.setSql("insert into user(gender,race,parental_level_of_education,test_preparation_course,math_score) values (:gender,:race,:parental_level_of_education,:test_preparation_course,:math_score)");
        this.setDataSource(dataSource);
    }
}
