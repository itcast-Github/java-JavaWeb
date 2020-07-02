package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.dao.ProductDao;
import com.itheima.domain.Product;

public class ProductService {

	public List<Product> findAllProduct() throws SQLException {
		//没有复杂业务
		//传递请求到dao层
		ProductDao dao = new ProductDao();
		List<Product> productList = dao.findAllProduct();
		return productList;
	}

}
