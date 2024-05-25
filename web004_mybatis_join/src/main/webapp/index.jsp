<%@page import="com.min.edu.dto.Player_DTO5"%>
<%@page import="com.min.edu.dto.Team_DTO5"%>
<%@page import="com.min.edu.dto.Player_DTO4"%>
<%@page import="com.min.edu.dto.Team_DTO"%>
<%@page import="com.min.edu.dto.All_Dto"%>
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
%>
<body>
	<button onclick="javascript:location.href='./joinCtrl.do'">결과확인</button>
	
	<%
		List<All_Dto>lists= (List<All_Dto>)request.getAttribute("listsOne");
		if(lists != null){
	%>
		<fieldset>
				<legend>All_Dto방식</legend>
			
		<div>
			<div>총 갯수 : <%=lists.size() %></div>
			<div>0번째 사람 : <%= lists.get(0).getPlayer_name() %>,<%= lists.get(0).getTeam_name()%></div>
		</div>
		
		</fieldset>
		
		<%
			List<Team_DTO> lists02 = (List<Team_DTO>)request.getAttribute("listsTwo");
		%>
		
		<fieldset>
			<legend>각 DTO 생성후 Team_DTO맴버필드로 사용하여 Join</legend>
			<div>
				<div><%=lists02.size()%></div>
				<%
					for(int i =0; i<2; i++){
				%>
					<div><%= lists02.get(i)%></div>
				<%
					}
				%>
				<div></div>
				<div></div>
			</div>
		</fieldset>

		<%
			List<Team_DTO> lists03 = (List<Team_DTO>)request.getAttribute("listsThree");
		%>
		<fieldset>
			<legend>MyBatis mapper.xml에 &lt; collection &gt; 사용하여 result Map을 사용하여 연결 team->player연결</legend>
			<div>
				<div><%=lists03.size()%></div>
				<div><%=lists03.get(0)%></div>
			</div>
		</fieldset>
		
		<%
			List<Player_DTO4> list04=(List<Player_DTO4>)request.getAttribute("listsFour");
		%>
		<fieldset>
			<legend>MyBatis mapper.xml에 &lt; collection &gt; 사용하여 result Map을 사용하여 연결 player->team연결</legend>
			<div>
				<div><%= list04.size() %></div>
				<div><%= list04.get(1) %></div>
				<div><%= list04.get(2) %></div>
			</div>
		</fieldset>
		
		<%
			List<Team_DTO5> list05 = (List<Team_DTO5>)request.getAttribute("listsFive");
		%>
		<fieldset>
			<legend>Team을 기준으로 소속된 정보들의 정보를 출력한다</legend>
			<div>
				<div><%= list05.size() %></div>
				<div><%=list05.get(1).getTeam_name() %></div>
				<select>
					<%
						for(Player_DTO5 dto : list05.get(0).getPdto()){
					%>
						<option><%=dto.getPlayer_name() %>/ <%= dto.getBack_no() %></option>		
					<%
						}
					%>
				</select>
			</div>
		</fieldset>
	<%
		}
	%>
	
</body>
</html>