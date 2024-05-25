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
	UserDTO dto = (UserDTO)request.getAttribute("dto");
%>
<body>
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
			<tr>
				<td><%=dto.getSeq() %></td>
				<td><%=dto.getId()%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getAddress()%></td>
				<td><%=dto.getPhone()%></td>
				<td><%=dto.getEmail() %></td>
				<td><%=dto.getEnable() %></td>
				<td><%=dto.getAuth().equals("USER")?"사용자":"관리자"%></td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="8">
					<input type="button" value="수정" onclick="updateForm()">
					<input type="button" value="삭제" onclick="delUser()">
				</td>
			</tr>
		</tfoot>
	</table>	
</body>
<!-- 명시적 함수, addEventListner click이벤트, onload를 통해서 click이벤트 -->
<script type="text/javascript">
	function updateForm() {
		location.href="./updateUser.Servlet";
	}
	function delUser() {
		console.log("delUser");
		location.href="./delUser.Servlet";
	}
</script>


</html>