package com.batch.config;

import com.batch.model.User;
import org.springframework.batch.item.ItemProcessor;

public class UserItemProcessor implements ItemProcessor<User,User> {


    @Override
    public User process(User user) throws Exception {
        return user;
    }
}
