<%@page import="com.min.edu.dto.UserInfo_DTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MainPage</title>
<link rel='stylesheet' type='text/css' media='screen'
	href='./css/mainPage.css'>
<%
	UserInfo_DTO login = (UserInfo_DTO)session.getAttribute("info");
%>
<script type="text/javascript" src="./js/main.js">

</script>
</head>
<body>
	<div class="container">
		<div class="nav">
			<div class="logo"></div>
			<div class="menu">
				<div id="home" onclick= "clickMenu(this.id,'<%=login.getAuth()%>')">
					<img alt="home"  src="./img/home.png"> 홈
				</div>
				<div id="search" onclick="clickMenu(this.id,'<%=login.getAuth()%>')">
					<img alt="search" src="./img/search.png"> 조회
				</div>
				<div id="insert" onclick="clickMenu(this.id,'<%=login.getAuth()%>')">
					<img alt="plus" src="./img/plus.png"> 입력
				</div>
				<div id="update" onclick="clickMenu(this.id,'<%=login.getAuth()%>')">
					<img alt="update" src="./img/update.png"> 수정
				</div>
				<div id="delete" onclick="clickMenu(this.id,'<%=login.getAuth()%>')">
					<img alt="delete" src="./img/delete.png"> 삭제
				</div>
			</div>

			<div id="submenu">
				<div class="popup" id="popup">
					<div id="sel">
						<img alt="setting" src="./img/settingacc.png" onclick="accountInfo()">계정 설정
					</div>
					<div id="sel">
						<img alt="changetheme" src="./img/theme.png">모드 전환
					</div>
					<div id="sel">
						<img alt="problem" src="./img/problem.png">문제 신고
					</div>
					<div id="line"></div>
					
					<div id="logout" style="padding-top: 15px" onclick="logout()">로그아웃</div>
					<script type="text/javascript">
						function logout() {
							<% 
								session.invalidate();
							%>
							window.location.href="./loginForm.jsp"
						}
					</script>
				</div>
				
				<div id="popupOpen" onclick="openModal()">
					<img alt="menu" src="./img/menu.png"> 더보기
				</div>
			</div>
		</div>

		<div class="content">
			<div class="accInfo" >
				<div>
					<h2>설정</h2>
				</div>
				<div class="box">
					<div class="leftbox">
						<div class="accountMenu">
							<div class="settingacc" id="settingacc" onclick="setting(this)" >
								<img alt="accountSet" src="./img/user.png">계정 설정
							</div>
							<div class="changePw"id="changePw" onclick="setting(this)" >
								<img alt="passwordSet" src="./img/safe.png">비밀번호 변경
							</div>
						</div>
						<hr>
						<div>
							<p>프로필 편집</p>
							<p>앱 및 웹사이트</p>
							<p>이메일 알림</p>
							<p>푸시 알림</p>
							<p>내가 볼 수 있는 내용</p>
							<p>내 콘텐츠를 볼 수 있는 사람</p>
							<p>다른 사람이 나와 소통 할 수 있는 방법</p>
							<p>관리 감독</p>
							<p>도움말</p>
							<p>프로페셔널 계정으로 전환</p>
						</div>
					</div>
					<div class="rightbox" id="settingacc" style="display: none;">
						<div class="profileset">
							<h2>프로필 편집</h2>
						</div>
						<div>
							<form class="profileForm" action="">
								<div class="website">
									<aside><label>전화번호</label></aside>
									<div id="websitein">
										<input type="text" placeholder="현재 전화번호 : <%=login.getPhone()%>">
									</div>
								</div>
								<div class="website">
									<aside><label> 별 명&nbsp;&nbsp;&nbsp;&nbsp;</label></aside>
									<div id="websitein">
										<input type="text" placeholder="현재 별명 : <%=login.getName()%>">
									</div>
								</div>
														
								<div class="info">
									<aside style="padding-right: 55px;"><label>소개</label></aside>
									<div class="textarea">
										<textarea></textarea>
										<span>0/150</span>
									</div>
								</div>
								<div class="gender">
									<aside><label>성별</label></aside>
									<div class="selGender">
										<div class="radio">
											<input type="radio" name="sel" value="남자">남자
											<input type="radio" name="sel"value="여자">여자
											<input type="radio" name="sel"value="비밀">비밀
										</div>
										<span>이 정보는 공개 프로필에 포함되지않습니다.</span>
									</div>
								</div>
								<div class="view">
									<aside><label>추천표시</label></aside>
									<div class="inview">
										<input type="checkbox">
										<span class="longspan">사람들이 회원님의 프로필에서 비슷한 계정 추천을 볼 수 있는지와 회원님의 계정이 다른 프로필에 추천될 수 있는지를 선택하세요</span>										
									</div>
								</div>
								<div class="submitForm">
									<button class="submitbtn">제출</button>
								</div>
							</form>
						</div>
					</div>
					
					<div class="rightbox" id="changePw" style="display: block;">
						<div class="profileset">
							<h2>비밀번호 변경</h2>
						</div>
						<div>
							<form class="profileForm">
								<div class="changepw">
									<aside><label>현재 비밀번호 확인</label></aside>
									<div id="inputpw">
										<input type="password" name="nowPw"placeholder="현재 비밀번호">
									</div>
								</div>
								<div class="changepw">
									<aside><label>새 비밀번호</label></aside>
									<div id="inputpw">
										<input type="password" name="newPw" placeholder="새 비밀번호"style="margin-left: 40px;">
									</div>
								</div>
								<div class="changepw">
									<aside><label>새 비밀번호 확인</label></aside>
									<div id="inputpw">
										<input type="password" name="newPwConfirm" placeholder="새 비밀번호 확인">
									</div>
								</div>
							</form>
								<div class="submitForm">
									<button class="submitbtn"onclick="pwChk()">제출</button>
								</div>
						</div>
					</div>
					
				</div>
			</div> <!-- accinfo -->
		</div>
	</div>
</body>
<script type="text/javascript">
function pwChk(){
	var nowPw = document.getElementsByName("nowPw")[0].value;
	var newPw = document.getElementsByName("newPw")[0].value;
	var newPwConfirm = document.getElementsByName("newPwConfirm")[0].value;

	if(nowPw ==""||newPw==""||newPwConfirm==""){
		alert("전부 입력 해 주세요");
	}else if(newPw!=newPwConfirm){
		alert("새 비밀번호와 새 비밀번호 확인이 다릅니다.");
	}else if('<%=login.getPw()%>'==newPw){
		alert("현재 비밀번호와 같은 비밀번호 사용 할 수 없습니다.")
	}else{
		alert("비밀번호 변경이 완료되었습니다.")
	}
}
</script>
</html>