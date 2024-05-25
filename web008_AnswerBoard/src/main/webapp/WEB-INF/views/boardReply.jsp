<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.min.edu.dto.UserVo"%>
<%@page import="com.min.edu.dto.AnswerBoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답글 작성 화면</title>
</head>
<%
	AnswerBoardDTO dto = (AnswerBoardDTO)request.getAttribute("dto");
	UserVo loginVo = (UserVo)session.getAttribute("loginInfo");
%>
<%!
	public String formatDate(Date d){
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy년도 MM월 dd일");
	return fmt.format(d);
}
%>
<%@include file="./header.jsp" %>
<body>
	<div id="container">
		<form action="./boardReply.do" method="post" onsubmit="return checkContxt()">
			<input type="hidden" name="seq" value="<%=dto.getSeq()%>">
				<table class="table">
					<tbody>	
						<tr>
							<th>아이디</th>
							<td class="form-group">
								<input class="form-control" type="text" value="<%=dto.getId()%>" readonly="readonly">
							</td>
						</tr>
						<tr>
							<th>제목</th>
							<td class="form-group">
								<input class="form-control" type="text" name="title" required="required">
							</td>
						</tr>
						<tr>
							<th id="contxt">내용<br>(원본)</th>
							<td class="form-group">
								<input type="hidden" value="Y" id="chkContent">
								<input type="hidden" value="<%=dto.getContent()%>" id="hiddenContent">
								<textarea class="form-control" rows="5" id="txtArea" name="content" onclick="contentChk()">원본글&gt;<%=dto.getContent()%></textarea>
							</td>
						</tr>
						<tr>
							<th id="contxt">작성일(JAVA)</th>
							<td class="form-group">
								<%= formatDate(new Date())%>
							</td>
						</tr>
						<tr>
							<th id="contxt">작성일(javascript)</th>
							<td class="form-group" id="newDate">
							</td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="2">
								<input class="btn btn-primary btn-sm btn-block" type="submit" value="답글 입력">
								<input class="btn btn-primary btn-sm btn-block" type="reset" onclick="resetValue()" value="입력초기화">
							</td>
						</tr>
					</tfoot>
				</table>
		</form>
	</div>
</body>
<%@include file="./footer.jsp" %>
<script>
	let date = new Date();
	document.getElementById("newDate").textContent=date.toLocaleDateString();
</script>
</html>