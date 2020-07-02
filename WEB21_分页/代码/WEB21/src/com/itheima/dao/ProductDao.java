package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.domain.Product;
import com.itheima.utils.DataSourceUtils;

public class ProductDao {

	public List<Product> findAllProduct() throws SQLException {
		return new QueryRunner(DataSourceUtils.getDataSource()).query("select * from product", new BeanListHandler<Product>(Product.class));
	}

	//获得全部的商品条数
	public int getTotalCount() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from product";
		Long query = (Long) runner.query(sql, new ScalarHandler());
		return query.intValue();
	}

	//获得分页的商品数据
	public List<Product> findProductListForPageBean(int index,int currentCount) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product limit ?,?";
		return runner.query(sql, new BeanListHandler<Product>(Product.class), index,currentCount);
	}

}
