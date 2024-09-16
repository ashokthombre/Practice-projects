package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.UserDao;
import com.springmvc.model.User;

@Service
public class UserService {
	
	@Autowired
	public UserDao userDao;
	
	
	public int insert(User user)
	{
		
		int save=(int)this.userDao.saveUser(user);
		return save;
	}

}
