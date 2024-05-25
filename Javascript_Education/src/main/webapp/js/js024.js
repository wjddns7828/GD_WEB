function childAppend(){
	//body에 전재하는 element를 탐색
	var fieldset = document.getElementById("addElement");
	//생성하는 Element
	var p = document.createElement("p");//<p></p>
	
	//fieldset의 자식 tag 중 마지막에 붙여 넣음
/*	var txt = document.createTextNode("appendChild는 맨뒤에 붙어요");
	p.appendChild(txt);//<p>appendChild는 맨뒤에 붙어요</p>*/
	
	p.textContent="appendChild는 맨뒤에 붙어요";
	//fieldset.append(p);//문자열 HTML로 전달하면 문자열로 출력되고 객체로 하면 appendchild가 됨
	//fieldset.append("<p>appendChild는 맨뒤에 붙어요</p>");
	//fieldset.appendChild("<p>appendChild는 맨뒤에 붙어요</p>");//문자열 HTML로 전달되지않음
	fieldset.appendChild(p);
}
var cnt=1;
function beforeAppend(){
	var newP = document.createElement("p");
	
	newP.textContent = "Element앞에 붙여준다"+(cnt++);
	
	var fieldset=document.getElementById("addElement");
	
	//붙여 넣을 곳
	var oldDiv = document.querySelector("fieldset>div");
	
	//insertBefore(추가할 Element 위치)
	fieldset.insertBefore(newP,oldDiv);
	
	//자식노드 검색
	//1) childNodes : 모든(textNode, tag element)
	//2) children : element만 검색
	// ※childnodes는 HTML에 작성되는 작성방식에 따라서 달라짐
	/*
	<div>
		<p></p>
		<p></p>
	</div>
	*/
}
function moveAppend(){
	var moveEle = document.querySelector("fieldset");
	console.log(moveEle);
	console.log(moveEle.tagName);
	console.log(moveEle.nodeName);
/*
	Element의 복제가 아닌 객체의 위치 주소를 알려줌
	따라서 객체를 복사하기 위해서는 복사 함수(cloneNode())를 통해서 객체를 복사해야함
	자식노드(textNode,Element)를 모두 복사하기 위해서는 반드시 argument를 true로 입력해줘야함
	
	ex) <div><p>콘텐츠</p></div>
		☞ cloneNode() => <div></div>
		☞ cloneNode(true) => <div><p>콘텐츠</p></div>
*/
	
	//Body의 위치에 붙히기
	var addEle = document.body;
	
	
	/*var copyEle= moveEle.cloneNode(true);//하위태그를 모두 복사함
	addEle.appendChild(copyEle);
	
	var copyEle= moveEle.cloneNode();//선택된 Element만 복사함
	addEle.appendChild(copyEle);*/
	var pasteEle = document.querySelector("fieldset").children[1];
	addEle.appendChild(pasteEle);
}


//1번
function addTest(){
	var div = document.getElementById("test01");
	var newdiv = document.createElement("div");
	newdiv.textContent="DomTest";
	newdiv.setAttribute("id","DomTest");
	div.append(newdiv);
}
//2번
function moveTest(){
	var movediv = document.getElementById("test01");
	var pasetEle = document.getElementById("test02");
	var copydiv = movediv.cloneNode(true);
	
	pasetEle.appendChild(copydiv);
	
	movediv.removeChild(movediv.firstChild);
}





































































































