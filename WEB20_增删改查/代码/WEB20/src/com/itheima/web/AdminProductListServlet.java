package com.itheima.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Product;
import com.itheima.service.AdminProductService;

public class AdminProductListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//传递请求到service层
		AdminProductService service = new AdminProductService();
		List<Product> productList = null;
		try {
			productList = service.findAllProduct();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//将productList放到request域
		request.setAttribute("productList", productList);
		
		request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
