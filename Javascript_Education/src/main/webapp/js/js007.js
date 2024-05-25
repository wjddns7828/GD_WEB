/**
 * DOM (Document Object Model) : node tree 구조로 되어있음
 		특징 : 작성 되어 있는 HTML을(랜더링 된 후) javascript를 통해서
 		Element의 위치를 가져오는 것(Object)
 		
 		selector 방식 : css선택자
 */
 function searchQuerySelector(){
	var doc = document.querySelector("p#query");
	alert(doc);
	//console.log(doc.trim());
	//doc.textContent="<span>셀렉터 표현식은 Node(querySelect일 때)이다</span>";
	doc.innerHTML="<span>셀렉터 표현식은 Node(querySelect일 때)이다</span>";
	
	var doc1 = document.querySelectorAll("p#query");
	alert(doc1[0]);
	//셀렉터 표현식은 NodeList(QuerySelectorAll)이다
}

function searchjQuery(){
	var doc= $("#query1");
	doc.html("<b>콘텐츠 변경<b>");
	doc.css ("color","red");
	doc.hide(1000);
}

function searchId(){
	var doc= document.getElementById("testId");//node
	doc.innerHTML = "<b>ID로 탐색하기</b>";
	doc.style.color="yellow";
	doc.style.backgroundColor="pink";
	doc.title="ID로 검색 됨";
}

function checkAll(bool){
	console.log("전달받은 값 : "+bool);
	var chk = document.getElementById("allCheck");
	console.log(chk.value); //check박스는 valu의 갑은 변화 없이 on
	console.log(chk.checked); // checked를 통해서 결과를 받아오게됨
	
	var chk = document.getElementsByName("chk");
	for(let i = 0; i<chk.length; i++){
		chk[i].checked = bool;
	}
}	
function remove(){
	console.log("remove");
	
	var chk=document.getElementsByName("chk");
	for(let i = 0; i<chk.length; i++){
		if(chk[i].checked){
			//chk[i].style.display="none";
			document.querySelectorAll("tbody tr")[i].style.display="none";
		}
	}
}
