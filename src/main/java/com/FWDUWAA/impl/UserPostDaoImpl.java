package com.FWDUWAA.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.FWDUWAA.SessionUtil;
import com.FWDUWAA.UserPostBean;
import com.FWDUWAA.dao.UserPostDao;
import com.FWDUWAA.model.entity.UserPost;

public class UserPostDaoImpl implements UserPostDao{

	@Override
	public UserPost getUserPost(Long id) {
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from UserPost where id= :id");
		query.setLong("id", id);
		UserPost userPost =(UserPost) query.uniqueResult();
		return userPost;
	}

	@Override
	public List<UserPost> getUserPosts() {
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from UserPost");
		@SuppressWarnings("unchecked")
		List<UserPost> UserPosts =query.list();
		return UserPosts;
	}

	@Override
	public void createUserPost(UserPostBean bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		createUserPost(session,bean);
		tx.commit();
		session.close();
		
	}
	private void createUserPost(Session session, UserPostBean bean) {
		UserPost userPost = new UserPost();
		userPost.setContent(bean.getContent());
		userPost.setTitle(bean.getTitle());
		userPost.setComments(null);
		session.save(userPost);
	}
	
	@Override
	public int deleteUserPost(Long id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from UserPost where id = :id";
		Query query = session.createQuery(hql);
		query.setLong("id",id);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
		
	}

	@Override
	public int updateUserPost(Long id, UserPost userPost) {
		if(id <=0)
			return 0;
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update UserPost set content = :content where UserPostId = :id";
		Query query = session.createQuery(hql);
		query.setLong("id",id);
		query.setString("content",userPost.getContent());
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}
