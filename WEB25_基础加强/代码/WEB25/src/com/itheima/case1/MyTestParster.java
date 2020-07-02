package com.itheima.case1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTestParster {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		
		//获得TestDemo
		Class clazz = TestDemo.class;
		//获得所有的方法
		Method[] methods = clazz.getMethods();
		if(methods!=null){
			//获得注解使用了@MyTest的方法
			for(Method method:methods){
				//判断该方法是否使用了@MyTest注解
				boolean annotationPresent = method.isAnnotationPresent(MyTest.class);
				if(annotationPresent){
					//该方法使用MyTest注解了
					method.invoke(clazz.newInstance(), null);
				}
			}
		}
		
	}
	
}
