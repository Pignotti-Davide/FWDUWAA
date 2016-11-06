package com.FWDUWAA.dao;

import java.util.List;

import com.FWDUWAA.CommentBean;
import com.FWDUWAA.model.entity.Comment;

public interface CommentDao {

	public Comment getComment(Long id);
	public List<Comment> getComments();
	
	public void createComment (CommentBean bean);
	
	public int deleteComment (Long id);
	
	public int updateComment (Long id,Comment com);
}
