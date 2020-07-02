package com.itheima.annotation;

import java.util.ArrayList;
import java.util.List;
//压制警告
public class AnnoDemo {


	public static void main(String[] args) {


		@SuppressWarnings({ "unused", "rawtypes" })
		List list = new ArrayList();

		show();

	}


	//定义方法过时
	@Deprecated
	public static void show(){

	}

	public static void show(String xx){

	}


	//帮助开发人间检查是否覆盖父类的方法发正确
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
