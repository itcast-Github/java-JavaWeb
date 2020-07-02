package com.itheima.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.utils.DataSourceUtils;

public class UserDao {

	public Long checkUsername(String username) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from user where username=?";
		Long query = (Long) runner.query(sql, new ScalarHandler(), username);
		return query;
	}

}
