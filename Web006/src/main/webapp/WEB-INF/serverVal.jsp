<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- TODO 008 request요청 두개 parameter, Attribute
		HttpServletRequest는 pass by reference로 값을 담고 또다른 JSP로 전달 = > HTML
		
--%>
<%
	String name = request.getParameter("name");
	String nickname = request.getParameter("nickname");
	String val = (String) request.getAttribute("val");
%>
<body>
	<h1>parameter : <%=name%></h1>
	<h1>parameter <%=nickname%></h1>
	<h1>Attribute <%=val%></h1>
</body>
</html>