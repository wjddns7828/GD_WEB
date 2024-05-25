<%@page import="com.min.edu.dto.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글작성</title>
</head>
<script type="text/javascript" src="./js/wirterForm.js"></script>
<%
	UserVo loginInfo = (UserVo)session.getAttribute("loginInfo");
%>
<%@ include file="./header.jsp" %>
<body>
	<div id=container>
		<div>
			<a href="javascript:history.back(-1)">뒤로가기</a>
		</div>
		<form action="./boardInsert.do" method="post">
			<table class="table table-bordered form-group">
				<thead>
					<tr>
					<th>아이디</th>
					<td>
						<input type="text" value="<%=loginInfo.getId()%>" readonly="readonly">
					</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>제목</th>
						<td>
							<input class="form-control" type="text" id="title" name="title">
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<textarea class="form-control" rows="5" id="content" name="content"></textarea>
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<div id="convertview"></div>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<th colspan="2" style="text-align: center;">
							<input class="btn btn-primary active" type="button" value="새글 작성" onclick="validationForm()">
							<input class="btn btn-primary " type="reset" value="초기화">
						</th>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
<%@ include file="./footer.jsp" %>
</html>