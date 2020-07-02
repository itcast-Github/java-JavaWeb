package com.itheima.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import com.itheima.vo.PageBean;

public class ProductListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProductService service = new ProductService();
		
		//模拟当前是第一页
		String currentPageStr = request.getParameter("currentPage");
		if(currentPageStr==null) currentPageStr="1";
		int currentPage = Integer.parseInt(currentPageStr);
		//认为每页显示12条
		int currentCount = 12;
		
		PageBean<Product> pageBean = null;
		try {
			pageBean = service.findPageBean(currentPage,currentCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("pageBean", pageBean);
		
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}