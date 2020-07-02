package cn.itheima.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;

import cn.itheima.jdbc.DataSource.MyDataSource;
import cn.itheima.jdbc.DataSource.MyDataSource1;
import cn.itheima.jdbc.utils.JDBCUtils_V3;

public class TestMyDataSource {

	/**
	 * 添加用户
	 * 使用未改造过的connection
	 */
	@Test
	public void testAddUser() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 1.创建自定义连接池对象
		MyDataSource dataSource = new MyDataSource();
		try {
			// 2.从池子中获取连接
			conn = dataSource.getConnection();
			String sql = "insert into tbl_user values(null,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "吕布");
			pstmt.setString(2, "貂蝉");
			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				System.out.println("添加成功!");
			} else {
				System.out.println("添加失败!");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			dataSource.backConnection(conn);
		}
	}
	
	
	/**
	 * 添加用户
	 * 使用改造过的connection
	 */
	@Test
	public void testAddUser1() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 1.创建自定义连接池对象
		DataSource dataSource = new MyDataSource1();
		try {
			// 2.从池子中获取连接
			conn = dataSource.getConnection();
			String sql = "insert into tbl_user values(null,?,?)";
			//3.必须在自定义的connection类中重写prepareStatement(sql)方法
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "吕布1");
			pstmt.setString(2, "貂蝉1");
			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				System.out.println("添加成功!");
			} else {
				System.out.println("添加失败!");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils_V3.release(conn, pstmt, null);
		}
	}
}
