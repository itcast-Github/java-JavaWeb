package cn.itheima.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import cn.itheima.jdbc.utils.DBCPUtils;

public class TestDBCP {

	@Test
	public void testUpdateUserById(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBCPUtils.getConnection();
			String sql ="update tbl_user set upassword=? where uid=?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, "柳岩");
			pstmt.setInt(2, 20);
			int rows = pstmt.executeUpdate();
			if(rows>0){
				System.out.println("更新成功!");
			}else{
				System.out.println("更新失败!");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
