<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OneToManyJoin</title>
</head>
<body>
	<fieldset>
		<legend>${dto.id} / ${dto.title}</legend>
		<div>
			${dto.content}
		</div>
		<div>
			<ul>
			<c:forEach var="reply" items="${dto.reply}">
				<li>${reply.seq} / ${reply.title} / ${reply.regdate}</li>
			</c:forEach>
			</ul>
		</div>
	</fieldset>
</body>
</html>