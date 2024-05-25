<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward 처리</title>
</head>
<!-- 
	TODO 005 값을 처리하고 HTML로 구성되는 JSP 파일
	어떠한 객체(타입)인지 알 수가 없음 (여러개,객체,단일값)
	Object로 전성되고 필요한 객체를 downcasting을 통해서 사용 할 수 있는 객체로 만들어줌
	
 -->
 <%
 	Object obj = request.getAttribute("returnvar");
 	String msg = (String)obj;
 %>
<body>
	<h3>서버에서 전송 받은 값</h3>
	<p><%=msg %></p>
</body>
</html>