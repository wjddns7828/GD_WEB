/*
	thead에 있는 ckeckbox를 클릭 했을 경우 다른(name='ch') checkbox를 true/false로 변경
	
*/
function checkAll(bool){
	console.log("checkAll 상태",bool)
	var chs= document.getElementsByName("ch");
	for(let i = 0; i<chs.length; i++){
		chs[i].checked = bool;
	}
}

/**
	ch의 checked의 갯수를 확인하는 함수
 */
 function chsConfirm(){
	var chs = document.getElementsByName("ch");
	var cnt = 0;
	for(let i=0; i<chs.length; i++){
		if(chs[i].checked){
			cnt++;
		}
	}
	return cnt;
}

/**
	ch가 모두 체크된다면 allCheck가 체크됨
	ch가 한개라도 체크가 없다면 allCheck가 꺼짐
 */


window.onload = function(){
	var chs = document.getElementsByName("ch");
	var all = document.getElementById("allCheck");
	
	for(let i = 0; i<chs.length; i++){
		chs[i].onclick = function(){
			if(chs.length==chsConfirm()){
				all.checked= true;
			}else{
				all.checked= false;
			}
		}
	}
}

/**
	submit 제어
	실행 이벤트를 button의 onclick으로 작업하는 방법
	실행 이벤트를 submit으로 작성해서 submit제어
 */

//일반적인 방법의 submit제어
//function chkSubmit(){
//	var chsCnt = chsConfirm();
//	if(!chsCnt > 0){
//		alert("한개 이상의 글을 반드시 체크하세요")
//		return false;
//	}
//}

//sweetAlert 1.1.3버전 -> callback함수
//sweetAlert 2x버전 -> Promise : then ~~



function chkSubmit(){
	
	if(chsConfirm() > 0){
		swal({
	title: "다중 삭제?",
	text: "삭제를 진행 하시겠습니까?",
	type: "warning",
	showCancelButton: true,
//	confirmButtonColor: '#DD6B55',
	confirmButtonClass: 'btn-danger',
	confirmButtonText: '예',
	cancelButtonText: "아니요",
	closeOnConfirm: true,
	closeOnCancel: false
	},
	function(resp) {
		console.log(resp)
		if (resp) {
			swal("삭제!!","삭제를 실행하겠습니다","success");
			submitForm();
		} else {
			swal("취소!!","삭제를 취소 하겠습니다","error");
		}
	});
	}else{
		swal("한 개 이상의 글을 선택해 주세요");
	}
		return false;
}

function submitForm(){
	document.forms[0].submit();
}

function del(val){
	console.log("삭제",val);
	var con = confirm("선택된 DB에서 삭제됩니다.")
	if(con){
		location.href="./boardDelete.do?seq="+val;
	}else{
		alert("삭제가 취소 되었습니다.");
	}
}

function modify(val){
	console.log("수정",val);
	location.href="./boardModify.do?seq="+val;
}

function reply(val){
	console.log("답글",val);
	location.href="./boardReply.do?seq="+val;
}

function contentChk(){
		var obj1= document.getElementById("hiddenContent").value;
		var obj2= document.getElementById("txtArea").value;
		console.log("obj1 ::: ",obj1);
		console.log("obj2 ::: ",obj2);
		var obj3 = obj2.replace("원본글>","");
		console.log("obj3 ::: ",obj3);
		if(obj1==obj3){
			document.getElementById("txtArea").value="";
			document.getElementById("contxt").innerHTML="내용<br>(작성중)";
			document.getElementById("chkContent").value="N";
		}
}

function resetValue(event){
//	event.preventDefault();
	document.getElementById("contxt").innerHTML="내용<br>(원본)";
	document.getElementById("chkContent").value="Y";
}
function checkContxt(){
	var check=document.getElementById("chkContent").value;
	if(check=='Y'){
		alert("답글을 입력해주세요");
		return false;
	}
}



































/**
	Jquery 방식을 통한 전체 체크
 */
/* $(document).ready(function(){
	console.log("jquery 체크 동작");
	$("#allCheck").click(function(){
		$(".ch").attr("checked",this.checked)
	});
});*/