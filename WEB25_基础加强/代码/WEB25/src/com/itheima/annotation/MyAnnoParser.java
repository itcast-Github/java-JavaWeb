package com.itheima.annotation;

import java.lang.reflect.Method;

public class MyAnnoParser {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		
		//解析show方法上面的@MyAnno
		//直接的目的是 获得show方法上的@MyAnno中的参数
		
		//获得show方法的字节码对象
		Class clazz = MyAnnoTest.class;
		Method method = clazz.getMethod("show", String.class);
		//获得show方法上的@MyAnno
		MyAnno annotation = method.getAnnotation(MyAnno.class);
		//获得@MyAnno上的属性值
		System.out.println(annotation.name());//zhangsan
		System.out.println(annotation.age());//28
		
		//根据业务需求写逻辑代码
		
	}
	
}
