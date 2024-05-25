<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 게시글 상세 보기</title>
</head>
<%@ include file="../../header.jsp" %>
<script type="text/javascript" src="./js/reply.js"></script>
<body>
	<div class="container">
		<input type="hidden" id="seq" value="${bDto.BSeq}">
		<input type="hidden" id="writer" value="${loginInfo.id}">
		<table class="table table-hover">
			<tbody>
				<tr>
					<th>제목</th>
					<td>${bDto.title}</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${bDto.BWriter}</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td>${bDto.BRegdate}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${bDto.BContent}</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
 						<c:forEach items="${bDto.fileDto}"  var="fDto">
							<a href="#">${fDto.originFname}</a><br>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th colspan="2">
						<input type="button" value="뒤로가기" 	onclick="history.back(-1)">
						<c:if test="${loginInfo ne null}">
							<input type="button" value="댓글달기" id="reply">
		      			</c:if>
					</th>
				</tr>
				<c:if test="${loginInfo ne null}">
				<tr>
					<th>${loginInfo.id}</th>
					<td><textarea rows="5" cols="80" id="replyTxt"></textarea></td>
				</tr>
				</c:if>
			</tbody>
			<tfoot>
				<c:forEach items="${bDto.replyDto}"  var="rDto">
					<tr>
						<th>
							${rDto.RWriter}<br>
							${rDto.RRegdate}
						</th>
						<c:choose>
							<c:when test="${fn:trim(rDto.RDelflag) eq 'Y'}">
								<td style="color:red; font-size:0.8em;">관리자에 의해 삭제되었습니다.</td>
							</c:when>
							<c:otherwise>							
								<td>${rDto.RContent}</td>
							</c:otherwise>
						</c:choose>	 
					</tr>
				</c:forEach>
			</tfoot>
		</table>
	</div>
</body>
<%@ include file="../../footer.jsp" %>
</html>