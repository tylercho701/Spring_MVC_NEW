<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>read.jsp</h2>
	<c:forEach items="${testList }" var="obj">
		<h3>${obj.data1 }</h3>
		<h3>${obj.data2 }</h3>
		<h3>${obj.data3 }</h3>
	</c:forEach>
</body>
</html>