<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정관리 게시판 첫페이지</title>
<style type="text/css">
	form{
		width:800px;
		margin: 100px auto;
	}
	table {
	border: 1px solid black;
	border-collapse: collapse;
	margin: auto;
}
	th, td{
		border: 1px solid gray;
		width : 50%;
	}
	th{
		background: yellow;
	}
	th:nth-child:last-child {
		background: white;
	}
</style>
</head>
<body>
	<form action="./CalController.do" method="post">
		<input type="hidden" name="command" value="calendar">
		<table>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="id" value="RABIT">
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name" value="기묘">
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" title="일정보기">			
				</th>
			</tr>
		</table>
	</form>
</body>
</html>