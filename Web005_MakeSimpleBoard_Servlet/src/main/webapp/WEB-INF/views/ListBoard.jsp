<%@page import="com.min.edu.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	.title:hover{
		cursor: pointer;
		color: red;
	}
</style>
<script>
	function detailBoard(seq) {
		console.log(seq.textContent);
		location.href="./detailBoard.Servlet?seq="+seq;
	}
</script>
<%
List<BoardDTO> lists = ((List<BoardDTO>) request.getAttribute("board"));
%>
<body>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (BoardDTO dto : lists) {
			%>
			<tr>
				<td><%=dto.getSeq()%></td>
				<td class="title" onclick="detailBoard(<%=dto.getSeq()%>)"><%=dto.getTitle()%></td>
				<td><%=dto.getTitle()%></td>
				<td><%=dto.getRegdate()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="3">
					<input type="button" onclick="location.href='./insertForm.Servlet';" value="글 작성">
				</td>
			</tr>
		</tfoot>
	</table>
</body>

</html>