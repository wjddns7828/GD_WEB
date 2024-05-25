/*
	tag는 Element의 구성으로 되어있음
		Element의 구성은 innerHTML을 통해서 값으로 읽어 올 수 있다.
	
	만약 상위 tag를 선택하여 하위 태그의 node를 검색한다면
		줄바꿈,element,주석 등 기타 외의것들이 포함되면 모두 node로 인식함
	
	만약 한줄로 되어있는 HTML이라면 하나의 node로 인식하면됨	
 */
function searchParent(){
	var child = document.getElementsByTagName("p")[1];
	console.log(child.innerHTML);
	
	//parentNode, childNodes
	
	var div = child.parentNode;
	console.log(div.innerHTML.trim());
	
	div.style.backgroundColor="Lime";
}

function searchChild(){
	var div = document.getElementsByTagName("div")[0];
	console.log(div.length);	
	
	var divChild = div.childNodes;
	//console.log(divChild.length);
	for(let i = 0; i<divChild.length; i++){
		console.log(divChild[i].tagName);
	}
	
	var divchild2 = div.children;
	console.log("element갯수 : "+divchild2.length);
}


function examDom(){
	var child = document.getElementsByTagName("p")[4];
	var div = child.parentNode;
	
	div.style.backgroundColor="Lime";
	
	var div1 = document.getElementsByTagName("div")[3];
	child1 = div1.childNodes[3];
	child1.style.fontSize="30px";
}

window.onload = function(){
	var ps = document.getElementsByTagName("p");
	for(let i = 0; i <ps.length; i++){
		ps[i].onclick = function(){
			var parent = this.parentNode;
			parent.innerHTML="";
		}
	}
}