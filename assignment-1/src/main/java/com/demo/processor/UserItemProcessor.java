package com.demo.processor;

import com.demo.model.User;

import org.springframework.batch.item.ItemProcessor;

public class UserItemProcessor implements ItemProcessor<User,User> {

    @Override
    public User process(User user) throws Exception {
        if (user.getGender()=="female") {
            return user;
        }
        return null;
    }
}
