package com.itheima.header;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Date date = new Date();
		
		//设置响应头
		response.addHeader("name", "zhangsan");
		//response.addIntHeader("age", 28);
		//response.addDateHeader("birthday", date.getTime());
		
		response.addHeader("name", "lisi");
		
		response.setHeader("age", "28");
		response.setHeader("age", "50");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}