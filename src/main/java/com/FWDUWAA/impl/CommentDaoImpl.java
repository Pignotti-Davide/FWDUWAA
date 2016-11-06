package com.FWDUWAA.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.FWDUWAA.CommentBean;
import com.FWDUWAA.SessionUtil;
import com.FWDUWAA.dao.CommentDao;
import com.FWDUWAA.model.entity.Comment;

public class CommentDaoImpl implements CommentDao{

	@Override
	public Comment getComment(Long id) {
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from Comment where id= :id");
		query.setLong("id", id);
		Comment comment =(Comment) query.uniqueResult();
		return comment;
	}

	@Override
	public List<Comment> getComments() {
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from Comment");
		@SuppressWarnings("unchecked")
		List<Comment> comments =query.list();
		return comments;
	}

	@Override
	public void createComment(CommentBean comment) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		createComment(session,comment);
		tx.commit();
		session.close();
		
	}

	private void createComment(Session session, CommentBean bean) {
		Comment comment = new Comment();
		comment.setUserId(bean.getUserId());
		comment.setContent(bean.getContent());
		comment.setReplies(null);
		session.save(comment);
		
	}

	@Override
	public int deleteComment(Long id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from Comment where id = :id";
		Query query = session.createQuery(hql);
		query.setLong("id",id);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
		
	}

	@Override
	public int updateComment(Long id, Comment com) {
		if(id <=0)
			return 0;
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update Comment set content = :content where commentId = :id";
		Query query = session.createQuery(hql);
		query.setLong("id",id);
		query.setString("content",com.getContent());
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
		
	}



}
