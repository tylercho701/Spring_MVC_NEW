<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- get 방식으로 이동하면서 data 전달하기 -->
	<a href="test1?number1=100&number2=200&numbers=300&numbers=400">test1_get</a>
	<br>
	<hr>
	<br>
	<form action="test2" method="post">
		number1 : <input type="text" name="number1" /><br>
		number2 : <input type="text" name="number2" /><br>
		numbers : <input type="checkbox" name="numbers" value="100" />100<br>
		numbers : <input type="checkbox" name="numbers" value="200" />200<br>
		numbers : <input type="checkbox" name="numbers" value="300" />300<br>
		<button type="submit" >test2 post</button>
	</form>
	<br>
	<hr>
	<br>
	<a href="test3?number1=100&number2=200&numbers=300&numbers=400">test3</a>
	<br>
	<hr>
	<br>
	<a href="test4/111/222/333/444">test4</a>
	<br>
	<hr>
	<br>
	<a href="test5/111/222/333/444">test5</a>
	<br>
	<hr>
	<br>
	<a href="test6?num1=100&num2=200&nums=300&nums=400">test6</a>
	<br>
	<hr>
	<br>
	<a href="test7?num1=100&num2=200&nums=300&nums=400">test7</a>
	<br>
	<hr>
	<br>
	<a href="test8?num1=100&num2=200&nums=300&nums=400">test8</a>
	<br>
	<hr>
	<br>
	<a href="test9?num1=100&num2=200&nums=300&nums=400">test9</a>
	<br>
	<hr>
	<br>
	<a href="test10?num1=100&num2=200&nums=300&nums=400">test10</a>
	<br>
	<hr>
	<br>
	<a href="test11?num1=100&num2=200&nums=300&nums=400">test11</a>
</body>
</html>