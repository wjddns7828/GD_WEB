<%@page import="java.util.List"%>
<%@page import="com.min.edu.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	<%
	BoardDTO dto = (BoardDTO) request.getAttribute("oneBoard");
	%>
	function delBoard(){
		location.href="./ModifyForm.Servlet?command=del&seq=<%=dto.getSeq()%>";
	}
	function modify() {
		location.href="./ModifyForm.Servlet?command=modify&seq=<%=dto.getSeq()%>";
	}
</script>
<body>
	<table>
		<thead>
			<tr>
				<th>번호 : <%=dto.getSeq()%></th>
				<th>제목 : <%=dto.getTitle()%></th>
				<th>작성일 : <%=dto.getRegdate()%></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="3">
					글내용 : <%=dto.getContent()%>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td><input type="button" value="수정" onclick="modify()"></td>
				<td><input type="button" value="삭제" onclick="delBoard()">
				</td>
			</tr>
		</tfoot>
	</table>
</body>
	
</html>