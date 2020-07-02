package com.itheima.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendCookieServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1、创建cookie对象
		Cookie cookie = new Cookie("name","zhangsan");
		
		//1.1 为cookie设置持久化时间 ---- cookie信息在硬盘上保存的时间
		cookie.setMaxAge(10*60);//10分钟 ---- 时间设置为0代表删除该cookie
		//1.2 为cookie设置携带的路径
		//cookie.setPath("/WEB16/sendCookie");//访问sendCookie资源时才携带这个cookie
		cookie.setPath("/WEB16");//访问WEB16下的任何资源时都携带这个cookie
		//cookie.setPath("/");//访问服务器下的所有的资源都携带这个cookie
		
		//2、将cookie中存储的信息发送到客户端---头
		response.addCookie(cookie);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
