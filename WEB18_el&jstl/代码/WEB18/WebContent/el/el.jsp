<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.itheima.domain.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 模拟域中的数据 -->
	<%
		pageContext.setAttribute("company", "传智播客");
	
		//存储字符串
		request.setAttribute("company", "黑马程序员");
	
		//存储一个对象
		User user = new User();
		user.setId(1);
		user.setName("zhangsan");
		user.setPassword("123");
		session.setAttribute("user", user);
		
		//存储一个集合
		List<User> list = new ArrayList<User>();
		User user1 = new User();
		user1.setId(2);
		user1.setName("lisi");
		user1.setPassword("123");
		list.add(user1);
		User user2 = new User();
		user2.setId(3);
		user2.setName("wangwu");
		user2.setPassword("123");
		list.add(user2);
		application.setAttribute("list", list);
		
	%>
	
	
	<!-- 脚本法是取出域中的值 -->
	<%=request.getAttribute("company") %>
	<%
		User sessionUser = (User)session.getAttribute("user");
		out.write(sessionUser.getName());
	%>
	<hr/>
	<!-- 使用EL表达式获得域中的值 -->
	${requestScope.company }
	${sessionScope.user.name }
	${applicationScope.list[1].name}
	
	<!-- 使用el表达式 全域查找 -->
	${company }
	${user.name }
	${list[1].name}
	
	<!-- el可以执行表达式运算 -->
	${1+1 }
	${1==1?true:false }
	<!-- empty 判定某个对象是否是null  是null返回true -->
	${empty list}
	
	
</body>
</html>