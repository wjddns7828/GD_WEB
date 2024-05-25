/*
	속성을 확인 hasAttribute("속성");
*/

window.onload = function(){
	//a태그 검색
	var anchor = document.querySelectorAll("a");
	var count =1;
	var img= document.querySelector("img");
	
	console.log("anchor : "+anchor+" / count :" + count+" / img : " +img);
	
	//html에서 생성을 했다면 true, 없으면 false
	//초기에 작성된 속성의 여부를 판단
	console.log("alt 속성이 있는지?", img.hasAttribute("alt"));
	console.log("title 속성이 있는지?", img.hasAttribute("title"));
	
	anchor[0].onclick=function(event){
		console.log("왼쪽");
		var imgAlt=img.getAttribute("alt");//img태그의 속성중 alt의 값을 가져옴
		console.log(imgAlt);
		if(imgAlt=="image1"){
			alert("첫번째 이미지 입니다");
		}else{
			img.setAttribute("alt","image"+(--count));
			img.setAttribute("src","./img/image"+count+".png")
		}
		event.preventDefault();
	}
	
	anchor[1].onclick=function(event){
		console.log("오른쪽");
		var imgAlt=img.getAttribute("alt");//img태그의 속성중 alt의 값을 가져옴
		console.log(imgAlt);
		if(imgAlt=="image5"){
			alert("마지막 이미지 입니다");
		}else{
			img.setAttribute("alt","image"+(++count));
			img.setAttribute("src","./img/image"+count+".png")
		}
		event.preventDefault();
	}
}