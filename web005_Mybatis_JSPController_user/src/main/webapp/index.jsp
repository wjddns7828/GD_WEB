<%@page import="com.min.edu.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<style type="text/css">
	table{
		border: 2px solid lime;
		border-collapse: collapse;
		width: 300px;
		margin: 200px auto;
	}
	td, th{
		border: 1px solid groove;
	}
</style>
</head>
<body>
	<% //scriptlet 자바의 문법을 작성하는 영역
		Object obj = request.getAttribute("loginDTO");//전달받은 객체가 name이 없으면 null;	
		UserDTO loginDTO =(UserDTO)obj;
		
		//UserDTO sessionloginDTO = (UserDTO)session.getAttribute("loginDTO");
		
	%>
	<%-- 전달받은 값 request: <%=loginDTO%> --%>
	<%-- 전달받은 값 session: <%=sessionloginDTO%> --%>
	<form action="./userServelet.do" method="post">
		<input type="hidden" name="command" value="login">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인">
					<input type="button" value="회원가입" onclick="registForm()">
				</td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	function registForm(){
		location.href="./userServelet.do?command=registForm";
	}
</script>
</html>