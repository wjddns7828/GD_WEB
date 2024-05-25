/**
 *propagation은 이벤트의 흐름을 끊어 내는 것
 	html이벤트와 javascript이벤트로 구성되어있음
 	 
 	 이벤트를 멈추는 방법
 	 
 	 1) return을 false처리하면 이벤트가 막힘 Ex on~~~="return 함수명"
 	 		event.stopPropagation(); <== 겹쳐있는 javascript의 다음 이벤트를 중지
 	 		event.preventDefault(); <== javascript 다음에 동작되는 HTML이벤트를 중지
 	 		
 */
 var num = 1;
 function prev_gallary(event){
	//event.stopPropagation(); //같은 공간에 있는 다른 자바스크립트 이벤트를 막음
	//event.preventDefault();
	//return;
	num--;
	if(num<1){
		num=5;
	}
	document.getElementById("gallary").src="./img/image"+num+".png";
		return false;
}

 function next_gallary(event){
	num++;
	if(num>5){
		num=1;
	}
	document.getElementById("gallary").src="./img/image"+num+".png";
		return false;
}