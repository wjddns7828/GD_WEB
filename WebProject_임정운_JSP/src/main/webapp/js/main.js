
//SPA구현 자바스크립트
function setting(x){
	console.log(x.id);
	var id =""+x.id;
	console.log(typeof id, id);
	switch(id){
		case "settingacc":
			document.querySelectorAll(".rightbox")[1].style.display="none";	
			document.querySelectorAll(".rightbox")[0].style.display="block";	
		break;
		case "changePw":
			document.querySelectorAll(".rightbox")[0].style.display="none";	
			document.querySelectorAll(".rightbox")[1].style.display="block";
		break;
	}
}
// 모달 열기 버튼을 클릭할 때 모달 창을 표시합니다.
var modalChk=false;

function openModal(){
  document.getElementById("popup").style.display = "block";
  modalChk=true;	
}

// 모달 창 외부를 클릭할 때 모달 창을 닫습니다.
window.addEventListener("click", function(event) {
  if (event.target != document.getElementById("popupOpen") && modalChk==true) {
    document.getElementById("popup").style.display = "none";
    console.log("modal닫기")
    modalChk=false;
  }
});

function clickMenu(id,auth){
	if(auth=="Admin"){
	}else if(id=="search" || id=="home"){
	}else{
		alert("권한이 없습니다");
	}
}
