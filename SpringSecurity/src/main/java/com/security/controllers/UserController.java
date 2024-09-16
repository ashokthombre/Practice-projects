package com.security.controllers;


import com.security.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.security.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getAllUsers()
    {

        List<User> allUsers = this.userService.getAllUsers();
        return allUsers;
    }

    @GetMapping("/{userName}")
    public User getUser(@PathVariable("userName") String userName)

    {

        User user = this.userService.getUser(userName);
        return user;
    }

    @PostMapping("/")
    public User addUser(@RequestBody User user)
    {
        System.out.println(user);
        User user1 = this.userService.addUser(user);
        return user1;
    }

}
