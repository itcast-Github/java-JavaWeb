package cn.itheima.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * 测试查询所有用户的类
 * @author Administrator
 *
 */
public class QueryAll {
	
	@Test
	public void testQueryAll(){
		Connection conn= null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取连接
			String url ="jdbc:mysql://127.0.0.1:3306/web08?useUnicode=true&characterEncoding=utf8";
			String username="root";
			String password="root";
			conn = DriverManager.getConnection(url,username,password);
			//3.获取执行sql语句对象
			stmt = conn.createStatement();
			//4.编写sql语句
			String sql = "select * from tbl_user";
			//5.执行sql语句
			rs = stmt.executeQuery(sql);
			//6.处理结果集
			while(rs.next()){
				System.out.println("用户名："+rs.getString(2)+" 密码："+rs.getString("upassword"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
