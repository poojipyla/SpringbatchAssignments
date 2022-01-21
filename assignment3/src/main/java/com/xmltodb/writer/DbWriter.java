package com.xmltodb.writer;

import javax.sql.DataSource;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import com.xmltodb.model.User;

public class DbWriter extends JdbcBatchItemWriter<User> {

    public DbWriter (DataSource dataSource) {
        this.setDataSource(dataSource);
        this.setSql("INSERT INTO User(userId,first_Name,last_Name,email,age) values(:userId,:first_Name,:last_Name,:email,:age)");
        this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<User>());
        this.afterPropertiesSet();
    }
}