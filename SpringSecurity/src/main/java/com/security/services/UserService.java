package com.security.services;

import com.security.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

  private List<User> users=new ArrayList<>();


  public UserService()
  {
      users.add(new User("abc","abc","abc@gmail.com"));
      users.add(new User("abcd","abcd","abcd@gmail.com"));
      users.add(new User("abcde","abcde","abcde@gmail.com"));
      users.add(new User("abcdef","abcdef","abcdef@gmail.com"));
  }

  public List<User> getAllUsers()
  {

      return this.users;
  }

  public User getUser(String userName)
  {

      User user = this.users.stream().filter(e -> e.getUserName().equals(userName)).findAny().orElse(null);
      return user;
  }

  public User addUser(User user)
  {
      this.users.add(user);
      return user;
  }

}
