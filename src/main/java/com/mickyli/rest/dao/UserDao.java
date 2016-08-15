package com.mickyli.rest.dao;

import java.util.List;

import com.mickyli.rest.bean.User;

public interface UserDao {
	public User getUserById(String id);  
	  
    public boolean deleteUserById(String id);  
  
    public boolean createUser(User user);  
  
    public boolean updateUser(User user);  
  
    public List<User> getAllUsers();
}
