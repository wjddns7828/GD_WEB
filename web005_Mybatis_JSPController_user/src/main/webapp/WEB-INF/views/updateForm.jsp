<%@page import="com.min.edu.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정화면</title>
<style type="text/css">
	span{
		color: red;
	}
</style>
</head>
<body>
<%
	UserDTO dto = (UserDTO)request.getAttribute("dto");
%>
	<form action="./userServelet.do?command=updateUser" method="post">
		<table>
			<thead>
				<tr>
					<th>아이디</th>
					<th><span>&#42;주소</span></th>
					<th><span>&#42;전화번호</span></th>
					<th><span>&#42;이메얼</span></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=dto.getId()%></td>
					<td>
						<input type="text" name="address" placeholder="<%=dto.getAddress()%>" required>
					</td>
					<td>
						<input type="text" name="phone"placeholder="<%=dto.getPhone()%>" required>
					</td>
					<td>
						<input type="text" name="email" placeholder="<%=dto.getEmail()%>" required>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="4">
						<input type="submit" value="수정완료">
					</th>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>