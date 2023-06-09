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
		<hr>
		<form:select path="data2">		<!-- path 설정된 변수의 값이 리스트와 동일 할 경우 default로 적용 -->
			<form:options items="${requestScope.dataArray1 }" />
		</form:select>
		<hr>
		<form:select path="data3">		<!-- path 설정된 변수의 값이 리스트와 동일 할 경우 default로 적용 -->
			<form:options items="${requestScope.dataList1 }" />
		</form:select>
		<hr>
		<form:select path="data4">		<!-- Label은 view에서 노출될 값, Value는 backend에서 사용 될 값 -->
			<form:options items="${requestScope.dataList2 }" itemLabel="key" itemValue="value" />
		</form:select>
		<hr>							<!-- data5 배열에 포함된 값이 value와 같으면 checked로 default 처리 -->
		<form:checkbox path="data5" value="C언어과정" />C언어과정
		<form:checkbox path="data5" value="Spring과정" />Spring과정
		<form:checkbox path="data5" value="JSP과정" />JSP과정
		<hr>
		<form:checkboxes items="${requestScope.dataArray2 }" path="data6" />
		<hr>
		<form:checkboxes items="${requestScope.dataList3 }" path="data7" />
		<hr>
		<form:checkboxes items="${requestScope.dataList4 }" path="data8" />
		<hr>
		<form:radiobutton path="data9" value="C언어과정" />C언어과정
		<form:radiobutton path="data9" value="Spring과정" />Spring과정
		<form:radiobutton path="data9" value="JSP과정" />JSP과정
		<hr>
		<form:radiobuttons path="data10" items="${requestScope.dataArray3 }" />
		<hr>
		<form:radiobuttons path="data11" items="${requestScope.dataList5 }" />
		<hr>
		<form:radiobuttons path="data11" items="${requestScope.dataList6 }" itemLabel="key" itemValue="value" />
	</form:form>
</body>
</html>