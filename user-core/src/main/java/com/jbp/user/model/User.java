package com.jbp.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_user")
public class User {

	@Id @GeneratedValue
	private int id;
	private String username;
	private String password;
	private String nickName;
	
	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public User() {
	}


	public User(String username, String password, String nickName) {
		super();
		this.username = username;
		this.password = password;
		this.nickName = nickName;
	}

}
