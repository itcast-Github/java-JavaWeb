package com.itheima.context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获得ServletContext对象
		ServletContext context = getServletContext();
		//1、获得初始化参数
		String initParameter = context.getInitParameter("driver");
		System.out.println(initParameter);
		//2、获得a b c d.txt的绝对路径
		//2.1 获得a.txt
		String realPath_A = context.getRealPath("a.txt");
		System.out.println(realPath_A);
		//2.2 获得b.txt
		String realPath_B = context.getRealPath("WEB-INF/b.txt");
		System.out.println(realPath_B);
		//2.3 获得c.txt
		String realPath_C = context.getRealPath("WEB-INF/classes/c.txt");
		System.out.println(realPath_C);
		//2.4 获得d.txt----获取不到
		
		
		//在读取src(classes) 下的资源是可以同类加载器----专门加载classes 下的文件的
		//getResource() 参数是一个相对地址 相对classes
		String path = ContextServlet.class.getClassLoader().getResource("c.txt").getPath();
		System.out.println(path);
		
		//3、域对象---向servletContext中存数据
		context.setAttribute("name", "zhangsan");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}