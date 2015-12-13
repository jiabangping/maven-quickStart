package com.jbp.service;

import com.jbp.user.model.User;

public interface IUserService {

	public void addUser(User user);
	public User loadUserByName(String name);
}
