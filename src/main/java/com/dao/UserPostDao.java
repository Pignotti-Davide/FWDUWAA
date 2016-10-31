package com.dao;

import java.util.List;

import com.model.UserPostBean;
import com.model.entity.UserPost;

public interface UserPostDao {

	public UserPost getUserPost(Long id);
	public List<UserPost> getUserPosts();
	
	public void createUserPost (UserPostBean bean);
	
	public int deleteUserPost (Long id);
	
	public int updateUserPost (Long id,UserPost UserPost);
}
