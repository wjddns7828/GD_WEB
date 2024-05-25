/*
	엘리먼트 생성하기 : createElement("태그명")
	속성 객체 생성하기 : createAttribute("속성명")
	콘텐츠 생성하기 : createTextNode("내용")
	
	속성 추가하기 : setAttributeNode("속성명")<<만들어 진 후에 / setAttribute("속성명","속성값")
	
	var t= "<a href='http://www.naver.com'>이동합니다.</a>"
	
	※중요※ append ※중요※ 
	attribute : 있는 속성만 넣을 수 있음 
	prop : 없는속성이라도 강제로 들어감
	
	Ex) div에 value라는 속성이 없어서 들어갈 수없는데 prop는 들어감
*/

function elementCreate(){
	//1.) HTML을 String으로 작성 후 :body에 div를 작성하고, 속성을 입력하고, 글을 입력하고, html에 있는 <p>에 자식노드로 붙혀넣음
	var tmp = "<div style='border: 1px solid black;'>안녕하세요 동적 추가입니다.</div>";
	//document.getElementById("loc").innerHTML=tmp;
	//document.getElementById("loc").append(tmp);//element로 인식한게 아니라 text로 인식
	//document.getElementById("loc").append(tmp);//createElement만으로 생성된 객체만 인식함
	
	//2.) element객체로 작성 후:
	var div = document.createElement("div");//<div></div>만듬
	var attr = document.createAttribute("style")//style=""만듬
	var txt = document.createTextNode("안녕하세요 동적추가입니다!!")//
	
	//2-1)속성 추가(1)
	//attr.nodeValue="border: 1px solid tomato";//style="border: 1px solid tomato"
	//div.setAttributeNode(attr);//<div style="border: 1px solid tomato"></div>
	
	//2-1)속성 추가(2)
	div.setAttribute("style","border: 1px solid tomato");//<div style="border: 1px solid tomato"></div>
	div.appendChild(txt);//<div style="border: 1px solid tomato">안녕하세요 동적추가입니다!!</div>
	document.getElementById("loc").appendChild(div);
}