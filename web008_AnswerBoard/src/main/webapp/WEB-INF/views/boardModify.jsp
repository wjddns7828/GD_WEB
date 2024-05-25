<%@page import="com.min.edu.dto.AnswerBoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정화면</title>
</head>
<%
	AnswerBoardDTO dto = (AnswerBoardDTO)request.getAttribute("dto");
	
%>
<%@ include file="./header.jsp" %>
<body>
<div id="container">
<form action="./boardModify.do" method="post">
	<input type="hidden" name="seq" value="<%=dto.getSeq()%>">
		<table class="table table-condensed">
					<tbody>
					<tr>
						<th class="warning">아이디</th>
						<td><%=dto.getId()%></td>
				</tr>
				<tr>
					<th class="warning">제목</th>
					<td><%=dto.getTitle()%></td>
				</tr>
				<tr>
					<th colspan="2" class="warning">내용</th>
				</tr>
				<tr>
					<td colspan="2">
							<textarea name="content" class="form-control" rows="5" id="comment"><%=dto.getContent()%></textarea>
					</td>
				</tr>
				<tr>
					<th class="warning">등록일</th>
					<td><%=dto.getRegdate()%></td>
				</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2" style="text-align: center;">
							<input type="submit" value="수정완료">
							<input type="button" value="수정취소" onclick="history.back(-1)">
						</td>
					</tr>
				</tfoot>
			</table>
</form>
</div>
</body>
<%@ include file="./footer.jsp" %>
</html>