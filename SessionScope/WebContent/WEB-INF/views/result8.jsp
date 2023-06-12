<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>result8.jsp</h2>
	<h3>session scope에 SessionBean2(TestBean2) 객체를 가져옴</h3>
	<h3>data1 : ${sessionScope.sessionBean2.data3 }</h3>
	<h3>data2 : ${sessionScope.sessionBean2.data4 }</h3>
</body>
</html>