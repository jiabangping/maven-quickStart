package com.jbp.service;

import com.jbp.user.dao.IUserDao;
import com.jbp.user.dao.UserDaoImpl;
import com.jbp.user.model.User;

public class UserServiceImpl implements IUserService {
	IUserDao dao = new UserDaoImpl();
	public void addUser(User user) {
		dao.add(user);
	}

	public User loadUserByName(String name) {
		return dao.loadByUserName(name);
	}
}
