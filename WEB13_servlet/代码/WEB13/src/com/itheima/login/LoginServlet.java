package com.itheima.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.domain.User;
import com.itheima.utils.DataSourceUtils;

public class LoginServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		//在Seveltcontext域中存一个数据count
		int count = 0;
		this.getServletContext().setAttribute("count", count);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		//username=zhangsan&password=123
		
		//1、获得用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//2、从数据库中验证该用户名和密码是否正确
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		User user = null;
		try {
			user = runner.query(sql, new BeanHandler<User>(User.class), username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//3、根据返回的结果给用户不同显示信息
		if(user!=null){
			//从servletcontext中取出count进行++运算
			ServletContext context = this.getServletContext();
			Integer count = (Integer) context.getAttribute("count");
			count++;
			//用户登录成功
			response.getWriter().write(user.toString()+"---you are success login person ："+count);
			context.setAttribute("count", count);
		}else{
			//用户登录失败
			response.getWriter().write("sorry your username or password is wrong");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}