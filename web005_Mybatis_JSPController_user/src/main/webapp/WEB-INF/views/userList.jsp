<%@page import="com.min.edu.dto.UserDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 조회-등급변경</title>
</head>
<script type="text/javascript">
	function updateAuth(seq) {
		console.log(seq);
		location.href="./userController.jsp?command=updateAuthForm&seq="+seq;
	}
</script>
	<%
		List<UserDTO> lists=(List<UserDTO>)request.getAttribute("lists");
	%>
<body>
<%@ include file="adminMain.jsp" %>
<hr size="3">
<h1>회원 정보 조회</h1>
<table>
	<thead>
		<tr>
			<td>seq번호</td>
			<td>ID</td>
			<td>Name</td>
			<td>Email</td>
			<td>Auth</td>
			<td>덩겁변경</td>
		</tr>
	</thead>
	<tbody>
		<%for(UserDTO dto : lists){
		%>
			<tr>
				<td><%=dto.getSeq() %></td>
				<td><%=dto.getId()%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getEmail()%></td>
				<td><%=dto.getAuth()%></td>
				<td><button onclick="updateAuth('<%=dto.getSeq()%>')">권한변경</button></td>
			</tr>
			<%
		}
		%>
	</tbody>
</table>
</body>
</html>