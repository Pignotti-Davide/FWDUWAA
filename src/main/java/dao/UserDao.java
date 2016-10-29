package dao;

import java.util.List;

import model.UserBean;
import model.entity.User;

public interface UserDao {

	public User getUser(Long id);
	public List<User> getUsers();
	
	public void createUser (UserBean bean);
	
	public int deleteUser (Long id);
	
	public int updateUser (Long id,User user);
}
