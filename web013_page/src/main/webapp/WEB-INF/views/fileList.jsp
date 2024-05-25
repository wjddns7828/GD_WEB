<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 게시글 목록</title>
</head>
<%@ include file="../../header.jsp" %>
<body>
		<div class="container">
		<div class="container">
      	<table class="table table-hover fileTable">
      		<thead>
      			<tr class="info">
      				<th>연번</th>
      				<th>작성자</th>
      				<th>제목</th>
      				<th>작성일</th>
      			</tr>
      		</thead>
      		<tbody>
      			<c:if test="${fn:length(bList) == 0}">
      				<tr>
   						<td colspan="5" style="color:red; text-align:center;">-- 작성된 글이 존재하지 않습니다 --</td>
   					</tr>
      			</c:if>
      			<c:if test="${fn:length(bList) ne 0}">
      				<c:forEach var="dto" items="${bList}" varStatus="vs">
      					<tr>
      						<td>${fn:length(bList)-vs.index}</td>
      						<td>${dto.BWriter}</td>
     							<c:choose>
     								<c:when test="${fn:trim(dto.BDelflag) eq 'Y'}">
     									<td style="color:red; font-size:0.8em;">관리자에 의해 삭제되었습니다.</td>
     								</c:when>
     								<c:otherwise>
	   									<td>
	      									<a href="./fileDetail.do?seq=${dto.BSeq}">${dto.title}</a>
	      								</td>
     								</c:otherwise>
     							</c:choose>	      						
      						<td>${dto.BRegdate}</td>
      					</tr>
      				</c:forEach>
      			</c:if>
      		</tbody>
      		<tfoot>
      			<c:if test="${loginInfo ne null}">
	      			<tr>
	      				<th colspan="4"><input type="button" value="새글쓰기"  onclick=" location.href='./fileWrite.do'"></th>
	      			</tr>
      			</c:if>
      		</tfoot>
      	</table>
      	<div style="text-align: center">
      		<fmt:parseNumber var="end" value="${page.totalPage/page.countPage}" integerOnly="true"/>
			<ul class="pagination pagination-lg">
				<c:if test="${page.startPage > 1}">
      				<li><a href="./boardPage.do?page=1">◁</a></li>
      				<li><a href="./boardPage.do?page=${page.endPage-page.countPage}">◀</a></li>
      			</c:if>
				<c:forEach begin="${page.startPage}" end="${page.endPage}" var="p">
					<c:choose>
						<c:when test="${p eq page.page}">
							<li class="active"><a href="'./boardPage.do?page='+${p}">${p}</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="./boardPage.do?page=${p}">${p}</a></li>
						</c:otherwise>
					</c:choose>	  
				</c:forEach>
   				<c:if test="${page.endPage < page.totalPage}">
    				<li><a href="./boardPage.do?page=${page.startPage + page.countPage}">▶</a></li>
   					<li><a href="./boardPage.do?page=${end*page.countPage+1}">▷</a></li>
   				</c:if>
			</ul>
		</div>
	</div>
	</div>
</body>
<%@ include file="../../footer.jsp" %>
</html>