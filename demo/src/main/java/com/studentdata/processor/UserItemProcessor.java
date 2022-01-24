package com.studentdata.processor;

import org.apache.tomcat.jni.User;
import org.slf4j.Logger;
import com.studentdata.model.User;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.util.Locale;

public class UserItemProcessor implements ItemProcessor<User,User> {

    private static final Logger log = LoggerFactory.getLogger(UserItemProcessor.class);

    @Override
    public User process(final User user) throws Exception {
        final String gender= user.getGender().toUpperCase();
        final String race= user.getRace().toUpperCase();

        final User transformedUser = new User(gender, race, user.getParental_level_of_education(), user.getTest_preparation_course(), user.getMath_score());

        log.info("Converting (" + user + ") into(" + transformedUser + ")");
        return transformedUser;
    }
}
