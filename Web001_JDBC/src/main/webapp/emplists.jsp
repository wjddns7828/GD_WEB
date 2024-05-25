<%@page import="com.min.edu.dto.Emp_DTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>╰(*°▽°*)╯</title>
</head>
<% 
		Object obj = request.getAttribute("lists");
		List<Emp_DTO> lists = (List<Emp_DTO>)obj;
	%>
<body>
	<h1>emplists 페이지 입니다.</h1>
	<% 
		for(Emp_DTO dto : lists){
				%>
	<%= dto %><br>
	<%
		}
	%>
</body>
</html>