package com.itheima.service;

import java.sql.SQLException;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

public class UserService {
	private UserDao dao = new UserDao();
	public User login(String username, String password) throws SQLException {
		return dao.login(username,password);
	}
	
}
