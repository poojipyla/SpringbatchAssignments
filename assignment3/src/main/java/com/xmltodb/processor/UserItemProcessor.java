package com.xmltodb.processor;

import com.xmltodb.model.User;
import org.springframework.batch.item.ItemProcessor;
public class UserItemProcessor implements ItemProcessor<User,User> {

    @Override
    public User process(User user) throws Exception {
        return user;
    }
}