package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.domain.Category;
import com.itheima.domain.Product;
import com.itheima.utils.DataSourceUtils;

public class AdminProductDao {

	public List<Product> findAllProduct() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product";
		List<Product> productList = runner.query(sql, new BeanListHandler<Product>(Product.class));
		return productList;
	}

	public List<Category> findAllCategory() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from category";
		List<Category> categoryList = runner.query(sql, new BeanListHandler<Category>(Category.class));
		return categoryList;
	}

	public void addProduct(Product product) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into product values(?,?,?,?,?,?,?,?,?,?)";
		runner.update(sql, product.getPid(),product.getPname(),product.getMarket_price(),
					product.getShop_price(),product.getPimage(),product.getPdate(),product.getIs_hot(),
					product.getPdesc(),product.getPflag(),product.getCid());
		
	}

	public void delProductByPid(String pid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from product where pid=?";
		runner.update(sql, pid);
		
	}

	public Product findProductByPid(String pid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where pid=?";
		Product product = runner.query(sql, new BeanHandler<Product>(Product.class), pid);
		return product;
	}

	public void updateProduct(Product product) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update product set pname=?,market_price=?,shop_price=?,pimage=?,pdate=?,is_hot=?,pdesc=?,pflag=?,cid=? where pid=?";
		runner.update(sql,product.getPname(),product.getMarket_price(),
				product.getShop_price(),product.getPimage(),product.getPdate(),product.getIs_hot(),
				product.getPdesc(),product.getPflag(),product.getCid(),product.getPid());
	}

}
