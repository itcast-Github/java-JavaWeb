package com.itheima.create;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session创建"+se.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session销毁");
	}

}
