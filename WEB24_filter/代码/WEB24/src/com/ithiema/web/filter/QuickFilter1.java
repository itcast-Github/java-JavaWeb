package com.ithiema.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class QuickFilter1 implements Filter{
	
	@Override
	//Filter创建的时候执行init方法
	public void init(FilterConfig filterConfig) throws ServletException {
		//1、获得web.xml中filter 的名称<filter-name>QuickFilter1</filter-name>
		System.out.println(filterConfig.getFilterName());
		//2、获得当前filter的初始化参数
		System.out.println(filterConfig.getInitParameter("aaa"));
		//3、获得servletContext
		filterConfig.getServletContext();
		
		System.out.println("init ....");
	}

	@Override
	//doFilter是Filter的核心过滤的方法
	/*
	 * request: 内部封装是客户端http请求的内容
	 * response: 代表是响应
	 * FilterChain: 过滤器链对象
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("quick1 running....");
		//放行请求
		chain.doFilter(request, response);
	}

	@Override
	//Filter对象销毁的时候执行destory方法
	public void destroy() {
		System.out.println("destroy...");
	}

}
