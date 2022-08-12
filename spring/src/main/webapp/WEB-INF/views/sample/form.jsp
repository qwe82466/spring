<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>form page</h1>
	<form action="/sample4/login" method="post">
		id: <input type="text" name="id"/><br/>
		pw: <input type="password" name="pw"/><br/>
			<input type="submit" value="login"/>
	
	
	</form>
	
	<h3>${tv.power }</h3>
	<h3>${tv.ch }</h3>
	<h3>${tv.col }</h3>

</body>
</html>