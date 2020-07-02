package com.ithiema.service;

import java.sql.SQLException;

import com.ithiema.dao.UserDao;
import com.ithiema.domain.User;

public class UserService {

	public User login(String username, String password) throws SQLException {
		UserDao dao = new UserDao();
		return dao.login(username,password);
	}

}
