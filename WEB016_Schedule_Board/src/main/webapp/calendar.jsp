<%@page import="com.min.edu.dto.CalendarDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.min.edu.util.CalendarUtil"%>
<%@page import="com.min.edu.model.CalBoardDaoImpl"%>
<%@page import="com.min.edu.model.ICalBoardDao"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정관리 화면</title>
</head>
<%
	//MVC1 패턴으로 작성
	
	//1번 Session 정보를 가져온다
	String id = (String)session.getAttribute("id");
	String name = (String)session.getAttribute("name");
	
	//2번 달력 객체 생성(현재 달력)
	Calendar cal = new GregorianCalendar();
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH)+1;
	
	//3번 요청받은 달력 년원을 Parameter 확인
	String paramYear = request.getParameter("year");
	String paramMonth = request.getParameter("month");
	
	//4번 처음 화면을 요청 했을 때는 요청값이 없기 떄문에 현재 날짜를 기준으로 year와 month를 입력해줘야함
	
	if(paramYear!=null){
		year = Integer.parseInt(paramYear);
	}
	if(paramMonth!=null){
		month=Integer.parseInt(paramMonth);
	}
	
	//5번 연산과 상관없음 화면의 표현값
	if(month>12){
		month=1;
		year++;
	}
	if(month<1){
		month=12;
		year--;
	}
	
	//6번 요청되고 변경된 날짜의 값을 Calendar객체를 Setting
	cal.set(year,month-1,1);
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	
	//7번 이전 달력
	cal.set(year,month-1-1,1);
	int beforeDayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	
	//8번 화면의 타이틀 값 가져오기
	ICalBoardDao dao = new CalBoardDaoImpl();
	String yyyymm= year+CalendarUtil.iTwoWord(month);
	Map<String,Object> map = new HashMap<>();
	map.put("id", id);
	map.put("yyyymm", yyyymm);
	List<CalendarDto> clists = dao.getCalViewList(map);
	System.out.println(clists);
%>
<%@ include file="header.jsp"%>
<body>
	<div id="container">
		<table id="calendar">
			<caption style="text-align: center; font-size: 17px;">
				<a href="./calendar.jsp?year=<%=year-1%>&month=<%=month%>">◀</a>
				<a href="./calendar.jsp?year=<%=year %>&month=<%=month-1%>">◁</a>
				<span class="y"><%=year%></span>년도
				<span class="m"><%=month>9?month:"0"+month%></span>월
				<a href="./calendar.jsp?year=<%=year%>&month=<%=month+1%>">▷</a>
				<a href="./calendar.jsp?year=<%=year+1%>&month=<%=month%>">▶</a>
			</caption>
			<thead>
				<tr>
					<th>일</th><th>월</th><th>화</th><th>수</th>
					<th>목</th><th>금</th><th>토</th>
				</tr>
			</thead>
			<tbody>
				<tr>
				<%
					for(int i=beforeDayOfMonth-dayOfWeek+1+1; i <= beforeDayOfMonth; i++){
						%>
							<td style="color:#ccc;"><%=i%></td>
						<%
					}
				%>
				<%
					for(int i = 1; i<=lastDay; i++){
						%>
							<td>
								<!-- 달력의 일 출력 -->
								<a style="color: <%=CalendarUtil.fontColor(i, dayOfWeek)%>"
								href="./CalController.do?command=callist&year=<%=year%>&month=<%=month%>&date=<%=i%>"
								class="countView"><%=i %></a>
								
								<!-- 글쓰기 버튼 -->
									<a href="./CalController.do?command=insertForm&year=<%=year%>&month=<%=month%>&date=<%=i%>">
										<img alt="pen" src="./img/pen.png">
									</a>
								<!-- 각일의 게시글 -->
								<div class="clist">
									<%=CalendarUtil.getCalView(i, clists)%>
								</div>
							</td>
						<%
						if((dayOfWeek-1+i)%7==0) {
							 out.print("</tr><tr>");
						}
					}
				%>
				<%
					for(int i = 0; i<(7-(dayOfWeek-1+lastDay)%7)%7;i++){
						/* out.print("<td>"+(i+1)+"</td>"); */
						%>
							<td style="color:#ccc;"><%=i+1%></td>
						<%
					}
				%>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="warp_loding" style="display : none">
		<div>
			<img alt="loding" src="./img/loading.gif">
		</div>
	</div>
</body>
</html>