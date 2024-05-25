<%@page import="com.min.edu.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>
<body>
	<% //scriptlet 자바의 문법을 작성하는 영역
		Object obj = request.getAttribute("loginDTO");//전달받은 객체가 name이 없으면 null;	
		UserDTO loginDTO =(UserDTO)obj;
		UserDTO sessionloginDTO = (UserDTO)session.getAttribute("loginDTO");

	%>
	전달받은 값 request: <%=loginDTO%>
	전달받은 값 session: <%=sessionloginDTO%>
	
	<h1>관리자 페이지</h1>
	<div>
		<span><%=sessionloginDTO.getName() %>님 환영합니다
			[등급 : <%=sessionloginDTO.getAuth() %>]
		</span>
	</div>
	<div style="font-size: :small">
		<div>
			<a href="./loginlogout.servlet">로그아웃</a>
		</div>
		<div>
			<a href="./getAllUserStatus.servlet?command=getAlluserStatus">회원상태 정보 조회</a>
		</div>
		<div>
			<a href="./getAllUser.servlet">회원 정보 조회</a>
		</div>
	</div>
</body>
</html>