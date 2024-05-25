<%@page import="com.min.edu.dto.All_DTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<button onclick="javascript:location.href='./joinCtrl.do'">눌러</button>
	
	<%
		List<All_DTO> lists = (List<All_DTO>)request.getAttribute("SELALL");
		if(lists!=null){
	%>
		<fieldset>
				<legend>All_Dto방식</legend>
			
		<div>
			<div>총 갯수 : <%=lists.size() %></div>
			<div>0번째 사람 : <%= lists.get(0).getEname()%>,<%= lists.get(0).getDeptno()%></div>
		</div>
		
		</fieldset>
	<%
		}
	%>
</body>
</html>