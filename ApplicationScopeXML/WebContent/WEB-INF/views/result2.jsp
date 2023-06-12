<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>result2</h2>
	<h3>applicationScope에서 data 가져옴</h3>
	<h3>applicationBean3.data5 : ${applicationScope.applicationBean3.data5 }</h3>
	<h3>applicationBean3.data6 : ${applicationScope.applicationBean3.data6 }</h3>
	<h3>applicationBean4.data7 : ${applicationScope.applicationBean4.data7 }</h3>
	<h3>applicationBean4.data8 : ${applicationScope.applicationBean4.data8 }</h3>
	<!-- JAVA 설정 환경에서는 자동으로 application 영역에 저장되지 않기 떄문에 출력되지 않음 -->
	<h3>requestScope에서 data 가져옴</h3>
	<h3>requestScope.data5 : ${requestScope.applicationBean3.data5 }</h3>
	<h3>requestScope.data6 : ${requestScope.applicationBean3.data6 }</h3>
	<h3>requestScope.data7 : ${requestScope.applicationBean4.data7 }</h3>
	<h3>requestScope.data8 : ${requestScope.applicationBean4.data8 }</h3>
</body>
</html>