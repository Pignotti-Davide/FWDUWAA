package com.FWDUWAA.model.entity;

import java.util.HashMap;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	@Column
	private String userName;
	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private String password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}






}
