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
	UserDTO dto = (UserDTO) request.getAttribute("dto");
%>
<body>
	<table>
	<thead>
		<tr>
			<td>seq번호</td>
			<td>ID</td>
			<td>PW</td>
			<td>Name</td>
			<td>ADDR</td>
			<td>PHONE</td>
			<td>Email</td>
			<td>ENABLE</td>
			<td>Auth</td>
		</tr>
	</thead>
	<tbody>
			<tr>
				<td><%=dto.getSeq() %></td>
				<td><%=dto.getId()%></td>
				<td><%=dto.getPassword()%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getAddress()%></td>
				<td><%=dto.getPhone()%></td>
				<td><%=dto.getEmail()%></td>
				<td><%=dto.getEnable()%></td>
				<td><%=dto.getAuth()%></td>
			</tr>
	</tbody>
</table>
</body>
</html>