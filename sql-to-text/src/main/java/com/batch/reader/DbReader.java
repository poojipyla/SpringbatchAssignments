package com.batch.reader;

import com.batch.mapper.PersonRowMapper;
import com.batch.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.database.JdbcCursorItemReader;

import javax.sql.DataSource;

@Slf4j
public class DbReader extends JdbcCursorItemReader<Person>{

    public DbReader(DataSource dataSource){
        log.info("DbReader()-started");
        this.setDataSource(dataSource);
        this.setSql("SELECT id,name FROM person;");
        this.setRowMapper(new PersonRowMapper());
        log.info("DbReader()-completed");
    }
}