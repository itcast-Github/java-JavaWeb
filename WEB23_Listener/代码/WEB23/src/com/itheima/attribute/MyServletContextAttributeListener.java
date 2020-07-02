package com.itheima.attribute;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttributeListener implements ServletContextAttributeListener{

	@Override
	public void attributeAdded(ServletContextAttributeEvent scab) {
		//放到域中的属性
		System.out.println(scab.getName());//放到域中的name
		System.out.println(scab.getValue());//放到域中的value
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		System.out.println(scab.getName());//删除的域中的name
		System.out.println(scab.getValue());//删除的域中的value
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		System.out.println(scab.getName());//获得修改前的name
		System.out.println(scab.getValue());//获得修改前的value
	}

}
