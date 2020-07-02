package cn.itheima.jdbc.DataSource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

import cn.itheima.jdbc.utils.JDBCUtils_V3;

public class MyDataSource1 implements DataSource{
	//1.创建1个容器用于存储Connection对象
	private static LinkedList<Connection> pool = new LinkedList<Connection>();
	
	//2.创建5个连接放到容器中去
	static{
		for (int i = 0; i < 5; i++) {
			Connection conn = JDBCUtils_V3.getConnection();
			//放入池子中connection对象已经经过改造了
			MyConnection myconn = new MyConnection(conn, pool);
			pool.add(myconn);
		}
	}
	
	/**
	 * 重写获取连接的方法
	 */
	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		//3.使用前先判断
		if(pool.size()==0){
			//4.池子里面没有，我们再创建一些
			for (int i = 0; i < 5; i++) {
				conn = JDBCUtils_V3.getConnection();
				//放入池子中connection对象已经经过改造了
				MyConnection myconn = new MyConnection(conn, pool);
				pool.add(myconn);
			}
		}
		//5.从池子里面获取一个连接对象Connection
		conn = pool.remove(0);
		return conn;
	}

	/**
	 * 归还连接对象到连接池中去
	 */
	public void backConnection(Connection conn){
		pool.add(conn);
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
