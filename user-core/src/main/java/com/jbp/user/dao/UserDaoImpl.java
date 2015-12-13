package com.jbp.user.dao;

import org.hibernate.Session;

import com.jbp.user.model.User;
import com.jbp.user.util.HibernateUtil;

public class UserDaoImpl implements IUserDao {

	public static void main(String[] args) {
		new UserDaoImpl().add(new User("admin","123","管理员"));
	}
	
	public void add(User user) {
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

	public User loadByUserName(String userName) {
		Session session = null;
		User user = null;
		try {
			session = HibernateUtil.openSession();
			user = (User) session.createQuery("from User where userName=?")
					.setParameter(0, userName).uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
		return user;
	}

}
