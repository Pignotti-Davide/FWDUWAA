package model.entity;

import java.util.HashMap;

public class User {

	private Long userId;
	private String userName;
	private String name;
	private String surname;
	private HashMap<Long,UserPost> posts;
	
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public HashMap<Long, UserPost> getPosts() {
		return posts;
	}
	public void setPosts(HashMap<Long, UserPost> posts) {
		this.posts = posts;
	}






}
