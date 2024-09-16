package com.api.redis.dao;

import com.api.redis.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserDao {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    private static  final String KEY="USER123";


    public User save(User user)
    {



        redisTemplate.opsForHash().put(KEY,user.getUserId(),user);
        return user;
    }

    public User get(String key)
    {

        User user =(User) redisTemplate.opsForHash().get(KEY, key);
        return user;
    }

    public Map<Object,Object> findAll()
    {

        return redisTemplate.opsForHash().entries(KEY);
    }

    public void delete(String userId)
    {
        redisTemplate.opsForHash().delete(KEY,userId);
    }


}
