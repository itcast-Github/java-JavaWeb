<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 获得表单的参数 -->
	<%
		request.getParameter("username");
		//....
	
	%>
	
	<!-- 使用el获得参数 -->
	${param.username }
	${header["User-Agent"] }
	${initParam.aaa }
	${cookie.name.value }
	
	<!-- 通过el表达式获得request对象 -->
	${pageContext.request }
	
	
</body>
</html>