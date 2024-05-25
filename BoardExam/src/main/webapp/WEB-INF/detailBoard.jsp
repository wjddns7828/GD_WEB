<%@page import="com.jeong.edu.vo.pageDto"%>
<%@page import="com.jeong.edu.vo.FileDto"%>
<%@page import="com.jeong.edu.vo.ReplyBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="com.jeong.edu.vo.RootBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.tt{
	text-align: center;
	margin: 300px auto;
}
	table{
		margin-left: auto;
		margin-right: auto;
	}
</style>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<%
	RootBoardDto root = (RootBoardDto)request.getAttribute("dto");
	List<ReplyBoardDto> rlist = (List<ReplyBoardDto>)request.getAttribute("rlist");
	FileDto fdto = (FileDto)request.getAttribute("file");
	pageDto p = (pageDto)request.getAttribute("page");
%>
<body>
	<div class="tt">
		<div class="table">
			<table>
				<tbody>
					<tr>
						<th>작성자 : </th>
						<td><%=root.getId()%></td>
					</tr>
					<tr>
						<th>제목 : </th>
						<td><%=root.getTitle()%></td>
					</tr>
					<tr>
						<th>내용 : </th>
						<td><%=root.getContent()%></td>
					</tr>
					<tr>
						<th>첨부파일 : </th>
						<%if(fdto!=null){
							%>
							<td>
								<a href="./download.do?b_seq=<%=fdto.getB_seq()%>&<%=fdto.getStored_fname()%>"><%=fdto.getOrigin_fname()%></a>
							</td>
							<%
							}else{
								%>
							<td>
								첨부파일 없음
							</td>
								<%
								}
							%>
					</tr>
				</tbody>
			</table>
		</div>
		<hr>
		<div class="reply">
			<table>
				<thead>
					<h2>댓글</h2>
				</thead>
				<tbody>
					<%
						if(rlist.size()==0){
							%>
								<h1>댓글 없음</h1>
							<%
						}else{
							for(int i=0; i<rlist.size(); i++){
						%>
							<tr>
								<th><%=rlist.get(i).getTitle()%></th>
								<th><%=rlist.get(i).getRegdate()%></th>
							</tr>
						<%	
							}
						}
					%>
				</tbody>
			</table>
			<%
				if(rlist.size()>0){
					%>
						<div class="paging">
							<ul class="pagination pagination-sm">
								<li><a href="./detail.do?seq=1&page=1">◀</a></li>
								<li><a href="./detail.do?seq=1&page=<%=p.getTotalPage()+1-p.getEndPage()%>">◁</a></li>
								<%
									for(int i= p.getStartPage(); i <=p.getEndPage(); i++){
								%>
											<li><a href="./detail.do?seq=1&page=<%=i%>"><%=i%></a></li>	
										<%
									}
								%>
								<li><a href="./detail.do?seq=1&page=<%=p.getStartPage()+p.getCountPage()%>">▷</a></li>
								<li><a href="./detail.do?seq=1&page=<%=p.getTotalPage()/p.getCountPage()*p.getCountPage()%>">▶</a></li>
							</ul>
						</div>
					<%
				}else{
					%>
					<%
				}
			%>
		</div>
	</div>
</body>
</html>