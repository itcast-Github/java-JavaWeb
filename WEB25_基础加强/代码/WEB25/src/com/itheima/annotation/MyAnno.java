package com.itheima.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {

	//注解的属性
	String name();
	
	int age() default 28;
	
	//String value();
	
	//String[] value();
	
	
}
