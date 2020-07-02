package com.itheima.attribute;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestMyServletContextAttributeListener extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServletContext context = this.getServletContext();
		
		//向context域中存数据
		context.setAttribute("name", "tom");
		
		//改context数据
		context.setAttribute("name", "lucy");
		
		//删除context数据
		context.removeAttribute("name");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}