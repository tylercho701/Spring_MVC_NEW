<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>result1.jsp</h2>
	<br><hr><br>
	<h3>${requestScope.testBean1.data1 }</h3>
	<h3>${requestScope.testBean1.data2 }</h3>
	<br><hr><br>
	<h3>${requestScope.testBean2.data3 }</h3>
	<h3>${requestScope.testBean2.data4 }</h3>
	<br><hr><br>
	<h3>${requestScope.testBean3.data5 }</h3>
	<h3>${requestScope.testBean3.data6 }</h3>
	<br><hr><br>
	<h3>${requestScope.testBean4.data7 }</h3>
	<h3>${requestScope.testBean4.data8 }</h3>
</body>
</html>