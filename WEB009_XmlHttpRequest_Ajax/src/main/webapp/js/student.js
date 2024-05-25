/**
 * 쿼리 스트링을 만들어주는 함수
 */
function getParameterVlaue() {
	var kor = "name=" + $("#name").val();
	var name = "kor=" + $("#kor").val();
	var end = "end=" + $("#end").val();
	var math = "math=" + $("#math").val();
	console.log(kor, name, end, math);

	return (name + "&" + kor + "&" + end + "&" + math);
}
//$(document).ready(function)({}));
$(function() {
	//Ajax Get방식으로 실행
	$("#process").click(function() {
		ajaxLoad()
	});
	//Ajax Post방식으로 처리
	$("#process2").click(function() {
		ajaxLoad2()
	});
});

/**
	XMLHttpRequest : 주소로 값을 요청
	javascript객체이며 Object를 통한 http 데이터를 송수신이 가능하도록 만들어주는 객체
	중요 용어
	1) state (작동 진행)
	2) status (작동 후 상태)
	
	onreadystatechange : state의 상태 정보
	-- readystate -- 의 상태는
	0 : uninitialized << 실행(로딩)이 되어 있지않음
	1 loding: 로드진행 
	2 loaded : 로드 완료
	3 interactive : 통신
	4 complete : 완료

	각각의 state에서 callback을 통해 상태를 반환
	--statusCode
	200 : 성공
	400 : 요청페이지가 없음
	403 : 인증되지않ㅇ므
	405 : 요청 프로토콜이 없음
	500 : 서버문제(값이 없음)
	  */

//XMLHttpRequest 객체 선언
var httpRequest = null;

function ajaxLoad() {
	//요청 -> 송수신객체 생성 -> callback함수를 state에 넣어주고 -> 연결 -> 보내줌
	var url = "./ScoreCal.do?" + getParameterVlaue();
	console.log(url);
	httpRequest = new XMLHttpRequest();//서버와 송수신을 위한 통신 객체 생성
	console.log(httpRequest)
	httpRequest.onreadystatechange = callback;//각 state에 처리된 callback 함수 생성
	httpRequest.open("GET", url, true);//"GET방식"으로 해당 "URL"에 "비동기식"으로 연결하겠다
	httpRequest.send();//연결(호출)하겠다
}

function callback() {
	//	alert("httpRequest.readyState : "+ httpRequest.readyState);
	alert("httpRequest.readyState : " + httpRequest.status);

	if (httpRequest.readyState == 4) {
		alert("통신이 완료되었습니다");
		if (httpRequest.status == 200) {
			alert(httpRequest.responseText);
			var obj = JSON.parse(httpRequest.responseText);
			$("#result").html(obj.name + "총점 : " + obj.sum + "평균 : " + obj.avg);
			//		$("#result").html(httpRequest.responseText);
		} else {
			alert("데이터를 수신 할 수 없습니다.");
		}
	}

}

//POST 프로토콜 처리 방식은 화면의 HTML을 보낸다
function ajaxLoad2(){
	//요청 -> 송수신객체 생성 -> callback함수를 state에 넣어주고 -> 연결 -> 보내줌
	var url = "./ScoreCal.do";
	httpRequest = new XMLHttpRequest();//서버와 송수신을 위한 통신 객체 생성
	httpRequest.onreadystatechange = callback2;//각 state에 처리된 callback 함수 생성
	alert(httpRequest.onreadystatechange);
	httpRequest.open("POST", url, true);//"GET방식"으로 해당 "URL"에 "비동기식"으로 연결하겠다
	
	httpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	httpRequest.send(getParameterVlaue());//연결(호출)하겠다
}
function callback2(){
	if (httpRequest.readyState == 4) {
		if (httpRequest.status == 200) {
			var obj = JSON.parse(httpRequest.responseText);
			$("#result").html(obj.name + "총점 : " + obj.sum + "평균 : " + obj.avg);
			//$("#result").html(httpRequest.responseText);
		} else {
			alert("데이터를 수신 할 수 없습니다.");
		}
	}
}
































































