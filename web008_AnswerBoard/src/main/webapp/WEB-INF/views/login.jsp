<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
	<form action="./boardLogin.do" method="post">
		<!-- 전달된 값(Parameter)는 시작 JSP에서 도착 JSP까지 -->
		<input type="hidden" name="loc" value="<%=request.getParameter("loc")%>">
		<table style="margin: 100px auto; text-align: center;">
			<tbody>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text"name="id" id="id" required="required">
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password"name="password"required="required">
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input type="submit" class="btn" value="로그인">
						<input type="reset" class="btn" value="취소"  onclick="history.back(-1)">
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>