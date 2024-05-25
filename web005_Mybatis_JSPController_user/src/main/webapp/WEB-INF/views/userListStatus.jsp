<%@page import="com.min.edu.dto.UserDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 리스트 조회</title>
</head>
	<%
		List<UserDTO> lists=(List<UserDTO>)request.getAttribute("lists");
	%>
<body>
	<h1>회원 상태 정보 조회</h1>
		<table>
		<thead>
			<tr>
				<th>seq번호</th>
				<th>ID</th>
				<th>Name</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Email</th>
				<th>Enable</th>
				<th>Auth</th>
			</tr>
			</thead>
			<tbody>
				<%
					for(UserDTO dto :lists){
						%>
						<tr>
						<td><%=dto.getSeq()%></td>
						<td><%=dto.getId() %></td>
						<td><%=dto.getName() %></td>
						<td><%=dto.getAddress() %></td>
						<td><%=dto.getPhone() %></td>
						<td><%=dto.getEmail() %></td>
						<td><%=dto.getEnable().equals("Y")?"사용중":"탈퇴" %></td>
						<td><%=dto.getAuth() %></td>
						</tr>
						<%
					}
				%>
			</tbody>
			<tfoot>
				<tr>
<!-- 					<th><a href="./adminMain.jsp">메인페이지 이동</a></th> -->
					<th><a href="">메인페이지 이동</a></th>
				</tr>
			</tfoot>
		</table>
</body>
</html>