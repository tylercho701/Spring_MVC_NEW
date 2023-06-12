<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>result1</h2>
	<h3>applicationScope에서 data 가져옴</h3>
	<h3>applicationBean1.data1 : ${applicationScope.applicationBean1.data1 }</h3>
	<h3>applicationBean1.data2 : ${applicationScope.applicationBean1.data2 }</h3>
	<h3>applicationBean2.data3 : ${applicationScope.applicationBean2.data3 }</h3>
	<h3>applicationBean2.data4 : ${applicationScope.applicationBean2.data4 }</h3>
	<!-- 자동으로 application 영역에 저장되지 않기 떄문에 출력되지 않음 -->
	<h3>requestScope에서 data 가져옴</h3>
	<h3>requestScope.data1 : ${requestScope.applicationBean1.data1 }</h3>
	<h3>requestScope.data2 : ${requestScope.applicationBean1.data2 }</h3>
	<h3>requestScope.data3 : ${requestScope.applicationBean2.data3 }</h3>
	<h3>requestScope.data4 : ${requestScope.applicationBean2.data4 }</h3>
</body>
</html>