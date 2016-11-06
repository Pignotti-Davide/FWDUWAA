package com.FWDUWAA;

import java.util.HashMap;

import com.FWDUWAA.model.entity.Comment;

public class CommentBean {
	private Long commentId;
	private Long userId;
	private String content;
	private HashMap<Long,Comment> replies;
	
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public HashMap<Long, Comment> getReplies() {
		return replies;
	}
	public void setReplies(HashMap<Long, Comment> replies) {
		this.replies = replies;
	}
}
