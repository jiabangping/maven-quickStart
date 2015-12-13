package com.jbp.user;

import org.junit.Before;

import com.jbp.user.dao.IUserDao;

public class UserDaoTest {
//对数据库的测试，应该做 隔离数据库做访问，让数据的信息不要影响到 我们原来的信息
//如何隔离 使用dbunit
	private IUserDao userDao;
	
	@Before
	public void setUp() {
		
	}
}
