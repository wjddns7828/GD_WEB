document.onkeydown= function(event){
//	console.log(event);
//	if(event.ctrlKey==true && (event.keyCode==78 || event.keyCode==82 || event.keyCode==116)){
//		event.keyCode=0;
//		event.cancelBubble=true;
//		event.returnValue=false;
//		return false;
//	}
};
var isshow = true;
window.onbeforeunload=function(){
	if(isshow){
		return "화면을 벗어납니다";
	}
}

function validationForm(){
	var frm =document.forms[0];
	var title=document.getElementById("title");
	var content=document.getElementById("content");
	
	if(title.value=="" || content.value==""){
		alert("필수값을 입력해주세요")
	}else{
		/*var str = content.value;
		str = str.replace(/\r\n|\r|\n|\n\r/gim,"<br>");
		str = str.replace(/>/gim,"&gt;");
		str = str.replace(/</gim,"&lt;");
		str = str.replace(/\"/gim,"&quot;");
		str = str.replace(/\'/gim,"&#38");
		document.getElementById("convertview").innerHTML=str;*/
		isshow=false;
		frm.submit();
	}
}





























