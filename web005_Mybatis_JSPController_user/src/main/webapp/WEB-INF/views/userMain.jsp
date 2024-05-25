<%@page import="com.min.edu.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	UserDTO sessiondto = (UserDTO) session.getAttribute("loginDTO");
%>
<body>
	<h1>사용자 페이지</h1>
	<span>
		<%=sessiondto.getName()%>님 반값습니다
		[등급 :  <%=sessiondto.getAuth().equalsIgnoreCase("user")?"사용자":"관리자" %>]
	</span>
	<a href="./userServlet.do?command=logout">로그아웃</a>
	<a href="./userServelet.do?command=userInfo">마이페이지</a>
</body>
</html>