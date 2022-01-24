package com.mysqltocsv.processor;

import com.mysqltocsv.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class UserItemProcessor implements ItemProcessor<User,User> {

    @Override
    public User process(User user) throws Exception {
        log.info("gender:"+user.getGender());
        log.info("race:"+user.getRace());
        log.info("parental_level_of_education:"+user.getParental_level_of_education());
        log.info("test_preparation_course:"+user.getTest_preparation_course());
        log.info("math_score:"+user.getMath_score());
        return user;
    }
}
