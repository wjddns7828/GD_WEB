<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
//parameter 객체
int year = Integer.parseInt(request.getParameter("year"));
int month = Integer.parseInt(request.getParameter("month"));
int date = Integer.parseInt(request.getParameter("date"));
//scope 객체
int lastday = (Integer) request.getAttribute("lastDay");
int hour = Integer.parseInt((String) request.getAttribute("hour"));
int min = Integer.parseInt((String) request.getAttribute("min"));
// int min =(Integer) request.getAttribute("min");

String id = (String) session.getAttribute("id");
%>
<%@ include file="header.jsp"%>
<body>
	<%-- <%=lastday %> --%>
	<%-- ${param.year} --%>
	<%-- ${requestScope.lastday} --%>
	<%-- ${sessionScope.id} --%>
	<form action="./CalController.do" method="post">
		<input type="hidden" name="id" value="<%=id%>">
		<input type="hidden" name="command" value="insertForm">
		<table class="table table-hover">
			<tbody>
				<tr>
					<th>이름</th>
					<th><%=id%></th>
				</tr>
				<tr>
					<th>일정</th>
					<td><select id="year" name="year">
							<%
							for (int i = year - 2; i <= year + 3; i++) {
							%>
							<option value="<%=i%>" <%if (i == year) {%> selected <%}%>><%=i%></option>
							<%
							}
							%>
					</select>년 <select id="month" name="month">
							<%
							for (int i = 1; i <= 12; i++) {
							%>
							<option value="<%=i%>" <%if (i == month) {%> selected <%}%>><%=i%></option>
							<%
							}
							%>
					</select>월 <select id="date" name="date">
							<%
							for (int i = 1; i <= lastday; i++) {
							%>
							<option value="<%=i%>" <%if (i == date) {%> selected <%}%>><%=i%></option>
							<%
							}
							%>
					</select>일 <select name="hour">
							<%
							for (int i = 0; i <= 24; i++) {
							%>
							<option value="<%=i%>" <%if (i == hour) {%> selected <%}%>><%=i%></option>
							<%
							}
							%>
					</select>시 <select name="min">
							<%
							for (int i = 0; i <= 59; i++) {
							%>
							<option value="<%=i%>" <%if (i == min) {%> selected <%}%>><%=i%></option>
							<%
							}
							%>
					</select>분</td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input class="form-control" type="text" name="title">
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea class="form-control" rows="10" name="content"></textarea>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="6"><input class="btn btn-success btn-block"
						type="submit" value="제출"></th>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
<script type="text/javascript">
	$(function() {
		$("#month").change(function() {
			$.ajax({
				url : "./CalController.do",
				type : "post",
				async : true,
				dataType : "text",
				data : {
					"command" : "getMaxDay",
					"month" : $("#month").val(),
					"year" : $("#year").val()
				},
				success : function(resp) {
					$("#date").children().remove();
					$("#date").append(resp);
				},
				error : function() {
					// 				alert("잘못된 요청");
				}
			});
		});
	});
</script>


</html>