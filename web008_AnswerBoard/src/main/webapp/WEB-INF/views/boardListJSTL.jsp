<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Board List 페이지</title>
</head>
<%@include file="./header.jsp"%>
<body>
   <!-- 요청 값 받기 -->
   <c:set var="rows" value="${lists}" scope="page"></c:set>
   <jsp:useBean id="dp" class="com.min.edu.comm.DatePatternBean"
      scope="page" />
   <jsp:useBean id="pp" class="com.min.edu.comm.PhotoBean" scope="page" />
   <div id="container">
      <form action="./boardDelete.do" method="post"
         onsubmit="return chkSubmit()">
         <table class="table table-hover">
            <thead>
               <tr class="info">
                  <th><input type="checkbox" id="allCheck"
                     onclick="checkAll(this.checked)" class="AllChk"></th>
                  <th>연변</th>
                  <th>아이디</th>
                  <th>제목</th>
                  <th>작성일</th>
               </tr>
            </thead>
            <tbody>
               <c:if test="${fn:length(rows) eq 0 }">
                  <tr>
                     <td colspan="5" style="color: red; text-align: center;">
                     
                     </td>
                  </tr>
               </c:if>

               <c:if test="${fn:length(rows) ne 0 }">
                  <c:forEach var="dto" items="${rows}" varStatus="vs">
                     <tr>
                        <td><input type="checkbox" name="ch" class="ch"
                           value="${dto.seq}"></td>
                        <td>${fn:length(rows) - vs.index}</td>
                        <td>${dto.id}</td>
                        <c:choose>
                              <c:when test="${fn:trim(dto.delflag) eq 'Y'}">
                                 <td style="color: red; font-size: 0.8em; text-align: center;">-관리자에
                                    의해 삭제된 게시글 입니다.</td>
                              </c:when>
                              <c:otherwise>
                              <td>
                                 <a href="./boardDetail.do?seq=${dto.seq}"> <jsp:setProperty
                                       property="depth" name="pp" value="${dto.depth}" /> <jsp:getProperty
                                       property="photo" name="pp" /> ${dto.title}
                                 </a>
                                 </td>
                              </c:otherwise>
                           </c:choose>
                           
                        <td>
                           <fmt:parseDate var="patternDate" value="${dto.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
                           <fmt:formatDate value="${patternDate}" pattern="YYYY년 MM월 dd일"/>
                        </td>
                     </tr>
                  </c:forEach>
               </c:if>

            </tbody>
            <tfoot>
               <tr>
                  <td colspan="5" style="text-align: center;">
                     <input class="btn btn-info btn-primary" type="submit" value="다중삭제">
                  </td>
               </tr>
            </tfoot>
         </table>
      </form>
   </div>





</body>
<%@include file="./footer.jsp"%>
</html>