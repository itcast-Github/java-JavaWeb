package com.itheima.classloader;

public class Demo {

	public static void main(String[] args) {
		
		//获得Demo字节码文件的类加载器
		Class clazz = Demo.class;//获得Demo的字节码对象
		ClassLoader classLoader = clazz.getClassLoader();//获得类加载器
		//getResource的参数路径相对classes（src）
		//获得classes(src)下的任何的资源
		String path = classLoader.getResource("com/itheima/classloader/jdbc.properties").getPath();
		//classLoader.getResourceAsStream("");
		System.out.println(path);
		
	}
	
}
