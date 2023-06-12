<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>result3</h2>
	<h3>Application Scope 에서 data를 가져옴</h3>
	<h3>name : ${applicationScope.name }</h3>
	<h3>bean1.data1 : ${applicationScope.bean1.data1 }</h3>
	<h3>bean1.data2 : ${applicationScope.bean1.data2 }</h3>
</body>
</html>