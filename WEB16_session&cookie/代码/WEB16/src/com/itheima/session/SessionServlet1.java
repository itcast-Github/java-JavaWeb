package com.itheima.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//创建属于该客户端(会话)的私有的session区域
		/* request.getSession()方法内部会判断 该客户端是否在服务器端已经存在session
		 * 如果该客户端在此服务器不存在session 那么就会创建一个新的session对象
		 * 如果该客户端在此服务器已经存在session 获得已经存在的该session返回
		 */
		HttpSession session = request.getSession();
		
		session.setAttribute("name", "jerry");
		
		String id = session.getId();//该session对象的编号id
		
		//手动创建一个存储JSESSIONID的Cookie 为该cookie设置持久化时间
		Cookie cookie = new Cookie("JSESSIONID",id);
		cookie.setPath("/WEB16/");
		cookie.setMaxAge(60*10);
		
		response.addCookie(cookie);
		
		
		response.getWriter().write("JSESSIONID:"+id);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}