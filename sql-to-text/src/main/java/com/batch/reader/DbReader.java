package com.batch.reader;

import com.batch.mapper.PersonRowMapper;
import com.batch.model.Person;
import org.springframework.batch.item.database.JdbcCursorItemReader;

import javax.sql.DataSource;

public class DbReader extends JdbcCursorItemReader<Person>{

    public DbReader(DataSource dataSource){
        this.setDataSource(dataSource);
        this.setSql("SELECT id,name FROM person;");
        this.setRowMapper(new PersonRowMapper());
    }
}