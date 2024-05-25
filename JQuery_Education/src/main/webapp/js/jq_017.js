//jQuery 방식
//$(function(){
//	$("#btn").click(function(){
//		$("img").toggleClass("onoffSize");
//	});
//	$("img").click(function(){
//		if($(this).hasClass("addSize")){
//			$(this).removeClass("addSize").attr("title","이미지축소");
//		}else{
//			$(this).addClass("addSize").attr("title","이미지확대");
//		}
//	});
//});


//javascript 방식

window.onload = function(){
	var btn = document.getElementById("btn");
	var img = document.getElementsByTagName("img");
	
	btn.onclick=function(){
		for(let i=0; i<img.length;i++){
			if(img.className==""){
				img[i].className="onoffSize"	
			}else{
			img[i].className="";	
		}
	}
	}
}
