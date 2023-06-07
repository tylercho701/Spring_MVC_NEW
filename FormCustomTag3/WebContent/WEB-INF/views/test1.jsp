<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		beanData 객체의 멤버변수 data1에 설정된 값과
		같은 값은 value로 하는 항목이 선택된 상태로
	 -->
	<h2>test1.jsp</h2>
	<form:form action="result" modelAttribute="beanData">
		<form:select path="data1">
			<form:option value="itacademy1">itacademy1</form:option>
			<form:option value="itacademy2">itacademy2</form:option>
			<form:option value="itacademy3">itacademy3</form:option>
			<form:option value="thejoeunacademy">the joeun academy</form:option>
		</form:select>
	</form:form>
</body>
</html>