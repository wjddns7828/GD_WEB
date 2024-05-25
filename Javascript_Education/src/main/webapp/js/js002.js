/**
 * 
 */
 alert("링크 : 실행3");
 
 window.onload = function(){
	alert("링크의 window.onload");
	document.getElementById("div_click").onclick = function(){
		alert("자바스크립트에서 동작 실행")
	}
		
};