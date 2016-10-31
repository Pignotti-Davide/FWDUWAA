package com.model;

import java.util.HashMap;

import com.model.entity.Comment;

public class UserPostBean {

	private Long userPostId;
	private String title;
	private String content;
	private HashMap<Long,Comment> comments;
	
	public Long getUserPostId() {
		return userPostId;
	}
	public void setUserPostId(Long userPostId) {
		this.userPostId = userPostId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public HashMap<Long, Comment> getComments() {
		return comments;
	}
	public void setComments(HashMap<Long, Comment> comments) {
		this.comments = comments;
	}
	
}
