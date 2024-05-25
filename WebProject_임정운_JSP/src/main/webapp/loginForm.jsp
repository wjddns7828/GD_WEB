<%@page import="com.min.edu.dto.UserInfo_DTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/loginForm.css">
<script src="./js/login.js"></script>
<title>LoginForm</title>
</head>
<body>
	<div class="container">
		<div class="box">
			<div class="heading"></div>
			<form class="login-form" action="./login.do" method="post">
				<div class="field">
					<input id="id" name="id" type="text"
						placeholder="전화번호, 사용자 이름 또는 이메일" />
				</div>
				<div class="field">
					<input id="password" name="password" type="password"
						placeholder="비밀번호" />
				</div>
				<input type="button" class="login-button" onclick="loginChk()"
					value="로그인">
				<div class="separator">
					<div class="line"></div>
					<p>또는</p>
					<div class="line"></div>
				</div>
				<div class="other">
					<button class="fb-login-btn" type="button">
						<i class="fa fa-facebook-official fb-icon"></i> <span class=""><img
							class="FacebookIMG"
							src="https://cdn2.iconfinder.com/data/icons/social-icons-33/128/Facebook-64.png"
							alt="">Facebook으로 로그인하기</span>
					</button>
					<a class="forgot-password" href="findpw.html">비밀번호를 잊으셨나요?</a>
				</div>
			</form>
		</div>
		<div class="box">
			<p>
				계정이 없으신가요? <a class="signup" href="./signUp.html">가입하기</a>
			</p>
		</div>
	</div>
</body>
</html>