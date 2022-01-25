package com.mysqltocsv.reader;

import com.mysqltocsv.mapper.UserRowMapper;

import com.mysqltocsv.model.User;
import org.springframework.batch.item.database.JdbcCursorItemReader;

import javax.sql.DataSource;

public class DbReader extends JdbcCursorItemReader<User>{

    public DbReader(DataSource dataSource){
        this.setDataSource(dataSource);
        this.setSql("SELECT gender,race,parental_level_of_education,test_preparation_course,math_score FROM user WHERE gender='female';");
        this.setRowMapper(new UserRowMapper());
    }
}
