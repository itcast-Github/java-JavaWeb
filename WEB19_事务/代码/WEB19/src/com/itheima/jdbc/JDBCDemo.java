package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {
		
		//通过jdbc去控制事务
		Connection conn = null;
		//1、注册驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//2、获得connection
			conn = DriverManager.getConnection("jdbc:mysql:///web19", "root", "root");
			
			//手动开启事务
			conn.setAutoCommit(false);
			
			//3、获得执行平台
			Statement stmt = conn.createStatement();
			
			//4、操作sql
			stmt.executeUpdate("update account set money=5000 where name='tom'");
			
			
			//提交事务
			conn.commit();
			
			stmt.close();
			conn.close();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
		
		
	}
	
}
