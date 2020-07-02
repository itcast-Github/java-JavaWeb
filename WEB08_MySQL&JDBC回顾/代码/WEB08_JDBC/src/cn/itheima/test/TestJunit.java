package cn.itheima.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestJunit {
	public static void main(String[] args) {
		System.out.println("aa");
	}
	
	@Test
	public void testJunit(){
		System.out.println("hello junit!");
	}
	
	@Before
	public void testBefore(){
		System.out.println("before!");
	}
	
	@After
	public void testAfter(){
		System.out.println("after!");
	}
	
}
