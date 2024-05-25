/**
 * 
 */
 
 //사용자에게 정보를 제공/확인 내용을 디버깅 할 때 사용
 function alterTest(){	
	alert("동작");
}
// 확인/취소버튼, 선택하여 true(1)/false(0)으로 변환하여 반환함
 function confirmTest(){
	var bool=confirm("배경색을 변경할까요?");
	console.log(typeof bool);
	console.log(bool);
	
	var color = document.getElementById("choiceColor").value;
	console.log(color);
	if(bool ==true){//객체 값 판단
		document.body.style.backgroundColor=color;
	}else{
		document.body.style.backgroundColor="white";
	}
}
 function promptTest(){
	var msg = prompt("감기 인가요? \n 1번 : 맞다, 2번 : 아니다, 3번 : 예정이다", "상태를 선택해 주세요" );
	console.log(typeof msg, msg);//취소 누르면 null반환
	switch(msg){
		case "1": alert("병원ㄱㄱ"); break;
		case "2": alert("공부 ㄱ");break;
		case "3": alert("같이 ㄱㄱ");break;
		default : ;
	}
	function swalTest(){
		swal("1234");
	}
}