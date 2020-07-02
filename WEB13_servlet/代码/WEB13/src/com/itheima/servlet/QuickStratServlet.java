package com.itheima.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class QuickStratServlet implements Servlet{
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		//1、获得servlet的name----<servlet-name>abc</servlet-name>
		String servletName = config.getServletName();
		System.out.println(servletName);//abc
		//2、获得该servlet的初始化的参数
		String initParameter = config.getInitParameter("url");
		System.out.println(initParameter);
		//3、获得Servletcontext对象
		ServletContext servletContext = config.getServletContext();
		
		System.out.println("init running....");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("QuickStratServlet running....");
		res.getWriter().write("QuickStratServlet running....");
	}
	
	
	@Override
	public void destroy() {
		System.out.println("destroy running....");
	}
	
	
	
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}


}
