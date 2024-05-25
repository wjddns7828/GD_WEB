<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post처리 방식 Encoding</title>
</head>
<!-- TODO 010 version3Servlet.do로 요청하는 post프로토콜 작성 화면 -->
<body>
	<pre>
		POST로 처리되는 parameter의 값을 주소로 전달되는 방식이 아니다.
		HTML이 전송되는 방식
		이벤트 submit으로 처리된다
	</pre>
	
	<form action="./Version3Servlet.do" method="post">
		<input type="text" name="name">
		<input type="submit" name="전송">
	</form>
</body>
</html>