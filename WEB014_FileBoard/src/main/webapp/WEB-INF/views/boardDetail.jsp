<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 페이지</title>
</head>
<body>
	<table>
		<col width="200px">
		<col width="200px">
		<col width="400px">
		<col width="200px">
		<tbody>
			<tr>
				<th>시퀀스</th>
				<td>${dto.seq}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${dto.id}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${dto.title}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${dto.content}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${dto.regdate}</td>
			</tr>
			<tr>
				<th>첨부 파일</th>
				<td>
					<c:choose>
						<c:when test="${fn:length(dto.filedto)>0}">
							<c:forEach var="files" items="${dto.filedto}">
								${files.origin_fname}
							<button onclick="location.href='./fileboard.do?command=download&seq=${dto.seq}'">다운로드</button>
						</c:forEach>
						</c:when>
						<c:otherwise>
							첨부파일 없음
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>