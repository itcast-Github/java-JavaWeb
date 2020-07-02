package com.itheima.domian;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class Customer implements HttpSessionActivationListener,Serializable{

	private String id;
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	//钝化
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("customer被钝化了");
	}
	@Override
	//活化
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("customer被活化了");
	}
	
	
}
