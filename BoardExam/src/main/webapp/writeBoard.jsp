<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글 쓰기</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script type="text/javascript"src="./js/writeBoard.js"></script>
<style type="text/css">
		table{
		margin: 300px auto;
	}
</style>
</head>
<body>
	<div class=container>
		<form action="./writeBoard.do" method="post" enctype="multipart/form-data">
			<table>
				<tbody>
					<tr>
						<th>아이디</th>
						<td>
							<input type="text" name="id" required="required">
						</td>
					</tr>
					<tr>
						<th>제목</th>
						<td>
							<input type="text" name="title" required="required">
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<textarea rows="10" cols="30" name="content" required="required"></textarea>
						</td>
					</tr>
					<tr>
						<th>
							<label for="fileupload">파일 첨부</label>
							<input type="file" name="file" id="fileupload" multiple="multiple" style="display: none;">
						</th>
						<td id="filename">
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<th colspan="2">
							<input type="submit" value="게시글 작성">
						</th>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>