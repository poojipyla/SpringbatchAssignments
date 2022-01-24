package com.batch.writer;

import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import com.batch.model.Person;

@Slf4j
public class DatabaseWriter extends JdbcBatchItemWriter<Person> {
    public DatabaseWriter (DataSource dataSource) {
        log.info("DatabaseWriter()-started");
        this.setDataSource(dataSource);
        this.setSql("INSERT INTO person(id,name) values(:id,:name)");
        this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Person>());
        this.afterPropertiesSet();
        log.info("DatabaseWriter()-completed");
    }
}