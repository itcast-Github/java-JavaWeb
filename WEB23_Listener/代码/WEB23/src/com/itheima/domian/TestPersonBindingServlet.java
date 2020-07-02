package com.itheima.domian;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestPersonBindingServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		//将person对象绑到session中
		Person p = new Person();
		p.setId("100");
		p.setName("zhangsanfeng");
				
		session.setAttribute("person", p);
		
		
		//将person对象从session中解绑
		session.removeAttribute("person");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}