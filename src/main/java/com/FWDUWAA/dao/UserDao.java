package com.FWDUWAA.dao;

import java.util.List;

import com.FWDUWAA.UserBean;
import com.FWDUWAA.model.entity.User;

public interface UserDao {

	public User getUser(Long id);
	public List<User> getUsers();
	
	public void createUser (UserBean bean);
	
	public int deleteUser (Long id);
	
	public int updateUser (Long id,User user);
}
