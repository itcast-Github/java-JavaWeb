<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("count", 10);
	
	%>
	<!-- jstl标签经常会和el配合使用 -->
	<!-- test代表的返回boolean的表达式 -->
	<c:if test="${count==9 }">
		xxxx
	</c:if>
	
	
	<!-- forEach模拟
		for(int i=0;i<=5;i++){
			syso(i)
		}
	 -->
	 <c:forEach begin="0" end="5" var="i">
	 	${i }<br/>
	 </c:forEach>
	
	<!-- 模拟增强for    productList---List<Product>
		for(Product product : productList){
			syso(product.getPname());
		}
	 -->
	 <!-- items:一个集合或数组   var:代表集合中的某一个元素-->
	 <c:forEach items="${productList }" var="pro">
	 	${pro.pname }
	 </c:forEach>
	
	
</body>
</html>