package com.jbp.user.dao;

import com.jbp.user.model.User;

public interface IUserDao {
	public void add(User user);
	public User loadByUserName(String userName);
}
