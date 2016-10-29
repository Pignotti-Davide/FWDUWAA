package dao;

import java.util.List;

import model.CommentBean;
import model.entity.Comment;

public interface CommentDao {

	public Comment getComment(Long id);
	public List<Comment> getComments();
	
	public void createComment (CommentBean bean);
	
	public int deleteComment (Long id);
	
	public int updateComment (Long id,Comment com);
}
