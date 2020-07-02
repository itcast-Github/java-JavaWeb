package com.ithiema.line;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LineServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1、获得请求方式
		String method = request.getMethod();
		System.out.println("method:"+method);
		//2、获得请求的资源相关的内容
		String requestURI = request.getRequestURI();
		StringBuffer requestURL = request.getRequestURL();
		System.out.println("uri:"+requestURI);
		System.out.println("url:"+requestURL);
		//获得web应用的名称
		String contextPath = request.getContextPath();
		System.out.println("web应用："+contextPath);
		//地址后的参数的字符串
		String queryString = request.getQueryString();
		System.out.println(queryString);
		//3、获得客户机的信息---获得访问者IP地址
		String remoteAddr = request.getRemoteAddr();
		System.out.println("IP:"+remoteAddr);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}