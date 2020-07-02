package com.itheima.header;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//没有响应 告知客户端去重定向到servlet2
		//1、设置状态码302
		//response.setStatus(302);
		//2、设置响应头Location
		//response.setHeader("Location", "/WEB14/servlet2");
		
		//封装成一个重定向的方法sendRedirect(url)
		response.sendRedirect("/WEB14/servlet2");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}