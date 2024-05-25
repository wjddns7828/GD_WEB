<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
<link rel="stylesheet" href="http://192.168.8.170:8080/WebProject_임정운/css/loginForm.css">
</head>
<body>
	<form class="login-form" action="./boardLogin.do" method="post">
		<div class="field">
			<input id="id" name="id" placeholder="Phone number, username, or email" />
		</div>
		<div class="field">
			<input id="password"  name="password" type="password" placeholder="password" />
		</div>
			<input type="submit" value="로그인">
	</form>
</body>
</html>