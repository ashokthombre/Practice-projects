package com.api.redis.controller;

import com.api.redis.dao.UserDao;
import com.api.redis.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDao userDao;

    @PutMapping
    public User createUser(@RequestBody User user)
    {
        User save = this.userDao.save(user);
        return save;
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") String userId)
    {
        User user = this.userDao.get(userId);
        return user;
    }

    @DeleteMapping
    public void deleteUser(@PathVariable("userId") String userId)
    {
        this.userDao.delete(userId);
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers()
    {
        Map<Object, Object> all = this.userDao.findAll();
        Collection<Object> values = all.values();
        List<User> collect = values.stream().map(value -> (User) value).collect(Collectors.toList());
        return collect;
    }
}
