package com.FWDUWAA.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.FWDUWAA.SessionUtil;
import com.FWDUWAA.UserBean;
import com.FWDUWAA.dao.UserDao;
import com.FWDUWAA.model.entity.User;

public class UserDaoImpl implements UserDao{

	@Override
	public User getUser(Long id) {
		Session session = SessionUtil.getSession();
		Query query= session.createQuery("from User where id= :id");
		query.setLong("id", id);
		User user=(User) query.uniqueResult();
		return user;
	}

	@Override
	public List<User> getUsers() {
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from User");
		@SuppressWarnings("unchecked")
		List<User> Users =query.list();
		return Users;
	}

	@Override
	public void createUser(UserBean bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		createUser(session,bean);
		tx.commit();
		session.close();
	}

	private void createUser(Session session, UserBean bean) {
		User user = new User();
		user.setName(bean.getName());
		user.setSurname(bean.getSurname());
		user.setUserName(bean.getUserName());
		user.setPosts(null);
		session.save(user);
	}

	@Override
	public int deleteUser(Long id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from User where id = :id";
		Query query = session.createQuery(hql);
		query.setLong("id",id);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;

	}

	@Override
	public int updateUser(Long id, User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
