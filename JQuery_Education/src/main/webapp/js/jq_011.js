$(function(){
//	$("p:eq(0)").add("span").css("color","red");
//	$("p:eq(0), span").css("color","blue");

//	var doc = document.getElementsByTagName("div")[0];
//	var chd = doc.children;
//	for(let i in chd){
//		chd[i].onclick=function(){
//			if(this.tagName=="SPAN"){
//				console.log(this.textContent);
//			}
//		}
//	};
//is("span").css("color","orange");
// 문제 ) div태그의 자식들 중에서 span은 color:orange / p는 background:yellow
// 단 사용하는 문법은 is
	$("div").children().click(function(){
		if($(this).prop("tagName"=="span")){
			$(this).css("color","orange");	
		}
		if($(this).is("P")){
			$(this).css("background","blue");
		}
	})
});