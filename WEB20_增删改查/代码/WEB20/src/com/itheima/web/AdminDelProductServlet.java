package com.itheima.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.service.AdminProductService;

public class AdminDelProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获取要删除的pid
		String pid = request.getParameter("pid");
		
		//传递pid到service层
		AdminProductService service = new AdminProductService();
		try {
			service.delProductByPid(pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath()+"/adminProductList");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}