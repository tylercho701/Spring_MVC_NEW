<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<style>
	.error { color:red; font-size:30%; }
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>input_data.jsp</h2>
	<form:form action="input_procedure" modelAttribute="testBean1" method="post">
		data1 : <form:input type="text" path="data1" /><br>
				<form:errors path="data1" class="error" /><br>
		data2 : <form:input type="text" path="data2" /><br>
				<form:errors path="data2" class="error" /><br>
		data3 : <form:input type="text" path="data3" /><br>
				<form:errors path="data3" class="error" /><br>
		data4 : <form:input type="text" path="data4" /><br>
				<form:errors path="data4" class="error" /><br>
		data5 : <form:input type="text" path="data5" /><br>
				<form:errors path="data5" class="error" /><br>
		data6 : <form:input type="text" path="data6" /><br>
				<form:errors path="data6" class="error" /><br>
		data7 : <form:input type="text" path="data7" /><br>
				<form:errors path="data7" class="error" /><br>
		<form:button type="submit">전	송</form:button>
	</form:form>
</body>
</html>