package com.itheima.ajax02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		System.out.println(name+"  "+age);
		
		
		//java代码只能返回一个json格式的字符串
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("{\"name\":\"汤姆\",\"age\":21}");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}