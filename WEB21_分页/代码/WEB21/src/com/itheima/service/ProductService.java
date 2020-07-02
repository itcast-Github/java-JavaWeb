package com.itheima.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itheima.dao.ProductDao;
import com.itheima.domain.Product;
import com.itheima.vo.PageBean;

public class ProductService {

	public List<Product> findAllProduct() throws SQLException {
		ProductDao dao = new ProductDao();
		return dao.findAllProduct();
	}

	//分页操作
	public PageBean findPageBean(int currentPage,int currentCount) throws SQLException  {
		
		ProductDao dao = new ProductDao();
		
		//目的：就是想办法封装一个PageBean 并返回
		PageBean pageBean = new PageBean();
		//1、当前页private int currentPage;
		pageBean.setCurrentPage(currentPage);
		//2、当前页显示的条数private int currentCount;
		pageBean.setCurrentCount(currentCount);
		//3、总条数private int totalCount;
		int totalCount = dao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		//4、总页数private int totalPage;
		/*
		 * 总条数		当前页显示的条数	总页数
		 * 10		4				3
		 * 11		4				3
		 * 12		4				3
		 * 13		4				4
		 * 
		 * 公式：总页数=Math.ceil(总条数/当前显示的条数)
		 * 
		 */
		int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
		pageBean.setTotalPage(totalPage);
		//5、每页显示的数据private List<T> productList = new ArrayList<T>();
		/*
		 * 页数与limit起始索引的关系
		 * 例如 每页显示4条
		 * 页数		其实索引		每页显示条数
		 * 1		0			4
		 * 2		4			4
		 * 3		8			4
		 * 4		12			4
		 * 
		 * 索引index = (当前页数-1)*每页显示的条数
		 * 
		 */
		int index = (currentPage-1)*currentCount;
		
		List<Product> productList = dao.findProductListForPageBean(index,currentCount);
		pageBean.setProductList(productList);
		
		return pageBean;
	}

}
