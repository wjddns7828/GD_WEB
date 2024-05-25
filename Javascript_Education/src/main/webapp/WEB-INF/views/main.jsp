<%@page import="com.min.edu.dto.UserInfo_DTO"%>
<%@page import="com.min.edu.dto.Board_DTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	UserInfo_DTO login = (UserInfo_DTO)request.getAttribute("login");
	List<Board_DTO> lists = (List<Board_DTO>)request.getAttribute("board");
%>
<body>
<div>
	안녕하세요 <%=login.getName()%>님, 반갑습니다.<br>
	<%= login.getAuth().equals("U")?"(일반회원)":"(관리자)" %>
	<%
		if(login.getAuth().equals("U")){
			%>
			<button>게시판이동</button>
			<%
		}else{
			%>
			<button>관리자페이지</button>
			<%
		}
	%>
</div>


<hr>
	<table>
		<%
			for(Board_DTO dto :lists){
		%>
			<tr>
				<td><%=dto.getWritter()%></td>
				<td><%=dto.getTitle()%></td>
				<td><%=dto.getRegdate()%></td>
			</tr>
		<%
			} 
		%>
	</table>
</body>
</html>