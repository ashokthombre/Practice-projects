package com.user.service.services;

import com.user.service.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User createUser(User user);

    public User getUser(String userId);

    public List<User> getAllUsers();

    public void deleteUser(String userId);

    public User updateUser(User user);
}
