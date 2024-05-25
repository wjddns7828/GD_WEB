<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="./css/10_loginForm.css">
</head>
<script type="text/javascript">
	function checkVal(){
			var user = document.getElementById("user");
			var pw = document.getElementById("password");
			console.log(user,pw);
			if(user.value==""){
				alert("아이디를 입력해 주세요");
				user.value="";
				user.focus();
				return false;
			}else if(pw.value==""){
				alert("비밀번호를 입력해주세요");
				pw.value="";
				pw.focus();
				return false;
			}else{
				return true;
			}
	}
</script>
<body>
<!-- 
	<form > : 서버사이드에 HTML을 전송
			action:속성을 통해서 submit Event를 통해서 serverside에 값을 전송 할 수 있는 영역
			method:전송 프로토콜의 방식을 선택해서 보낼 수 있음(default: GET방식, GET POST PUT DELETE TRACE ...)
			반드시 서버에 전송 할 때는 NAME이 있는 Element만을 전송 할 수 있다.
	<input> : 서버사이드에 전송될 값을 입력할 수 있는 요소 (form요소)
			form요소 default는 text, type 속성을 통해서 정의(text,color,date,number,password)
			submit을 통해서 name="값" 의 형태로 서버사이드에 전송됨
			empty Element(닫힘 태그가 없고 value속성을 가지고 있음)
			<b>값</b> <input value="값>
 -->
 	<button onclick="viewPw()">비밀번호 보기</button>
 	<script type="text/javascript">
 		function viewPw(){
 			var obj = document.getElementById("password").type;
 			if(obj == "password"){
 				document.getElementById("password").type="text";
 			}else{
 				document.getElementById("password").type="password";
 			}
 		}
 	</script>
 	
 	<form class = "box" action="./HTMLLogin.login" method="post" onsubmit="return checkVal();">
 		<input type="text" id="user" name="user" placeholder="username">
 		<input type="password" id="password" name="pw" placeholder="password">
 		<input type="submit" value="login">
 	</form>
</body>
</html>