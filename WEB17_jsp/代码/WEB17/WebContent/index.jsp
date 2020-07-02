<%@page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" session="true" isErrorPage="true" %>
<!-- 引入jstl核心库 -->
<%-- <%@ taglib uri="http://" prefix="c"%> --%>
<%-- <%@ taglib uri="http://" prefix="fmt"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 使用c库的标签 -->
	<!-- <c:if></c:if>
	<fmt:xxxx></fmt:xxxx> -->

	<%@ include file="/demo.jsp" %>
	xxxxxxxxx
	<!-- html的注释 -->
	<%
	
		//exception.getMessage()
		
		
	
		request.setAttribute("age", 30);
	
		session.setAttribute("name", "zhangsan");
	
		//这是单行注释
		int i=0;
		/*
			多行注释
		*/
		System.out.print(i);
		
		List list = new ArrayList();
		
		//int y = 1/0;

		
	%>
	<%-- jsp注释 --%>
	<%=i %>
	
	<%=1+1 %>
	
	<%!
		String str = "nihao china!";
		public void fn(){
			
		}
	%>
	
	<%=str %>
	
	<h1>akdhakh</h1>
</body>
</html>