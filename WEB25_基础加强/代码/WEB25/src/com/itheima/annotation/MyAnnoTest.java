package com.itheima.annotation;
@MyAnno(name = "zhangsan")
public class MyAnnoTest {
	
	@SuppressWarnings("all")
	@MyAnno(name = "zhangsan")
	//@MyAnno({ "aaa","bbb","ccc"})
	public void show(String str){
		System.out.println("show running...");
	}
	
}
