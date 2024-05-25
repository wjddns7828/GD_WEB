//1번
/*
		javascript의 타입 6개
		HTML에 화면에 출력되어 있는 TextNode를 가지고오면 모두 String => content,value
		
		DOM탐색
		Document.으로 탐색
		Document.getElements==> s가 붙으면 list형태로 || 없으면 Node로 가져옴
		DOM 탐색을 통해서 가져온 결과는	-->pass by reference
		
		//탐색된 위치 값을 처리하는 방식
		//empty Elemet(닫힘 tag가 없는 경우를 말함) : 속성(attribute)로 값을 가지고 있음 ex) <input value="">
		//Markup tag(well-form) <<HTML || well-form에서 valid하다 ==> xml
		//Markup tag 한 tag :	innerHTML ==> 선택된 HTML 하위에 모든 html을 String으로 가져옴
		//						textContent==> textNode만을 선별적으로 가져옴
		
		form요소 : <input>,<textarea>,<fieldset> 서버에 데이터를 전송할 수 있는 영역, HTML전송된다
		form요소에서 : textarea는 조심해야함 => <textarea>콘텐츠</textarea> 콘텐츠를 브라우저가 번역하지않고 보이는 그대로 전송
											마크업의 사이에 공백을 두면안됨
											값을 입력하고 가져올 때 : markup방식이 아닌 value를 통해서 사용해야함
		form요소에만 있는것 : type=submit, form에 javascript 이벤트를 통해서 onsubmit()으로 보냄
							action의 속성으로 서버 전송 / method : Protocol 처리 방식을 정의(GET / POST 등등~)해서 server에 요청을 받음
		form 내에서만 동작되는 submit / reset 									
	*/
	
 function numCheck01(){
	var input = new Array;

	input[0] = Number(document.getElementsByName("num")[0].value);	
	input[1] = Number(document.getElementById("realNum").value);	
	input[2] = Number(document.getElementById("phone").value);
	//숫자가 아니면 NaN뜸
	
	for(let i =0; i<input.length;i++){
		if(input[i].toString()=="NaN"){
			alert(i+1+"번째 입력창은 숫자가 아닙니다")
		}else{
			alert(i+1+"번째 입력창은 숫자 입니다.")
		}
	}
	//썜 --문제의 의도는 정규화 사용
	var num1 = document.getElementsByName("num")[0];
	var num2 = document.getElementById("realNum");
	
	console.log(typeof num1.value);
	console.log(typeof num2.value);
	
	console.log(typeof parseInt(num1.value)); //<<이 방법도 형변환하는것
	console.log(typeof (new Numer(num1.value))); //<<이 방법도 형변환하는것
	console.log(typeof Number(num1.value));//<<이 방법도 형 변환이 되지만 소숫점이...
	
	var regExNum = /[0-9]/g;//정규화
	var numChk = num.search(regExNum);
	
	//숫자판단
	if(numchk==-1){
		alert("숫자가 아닙니다");
	}else{
		alert("숫자입니다.");
	}
	
	//전화번호 판단
	var regExPhone=/^\d{2,3}-\d{3,4}-\d{4}$/;
	
	//한개의 Node를 검색 할 때 name이 없다면 결과는 : null
	var tmp1 = document.getElementById("tmp");
	console.log(tmp1);//null
	//
	var tmp2 = document.getElementsByName("tmp")[0];
	console.log(tmp2); // undefined
	
}	
//2번
function searchStr02(){
	var searchStr = document.getElementById("val").value;

	var x = document.getElementsByTagName("pre")[0].textContent;
		if(x.indexOf(searchStr)==-1){
			alert("검색어 존재하지 않음");
		}else{
			alert("검색어 존재함");
		}
}
//3번			
window.onload = function() {
	var radio = document.getElementsByName("site");
	var prop="width=500px, height=500px";
	for(let i = 0; i<radio.length;i++){
		radio[i].onclick=function(){
			if(radio[i].checked){
				window.open(radio[i].value,"양념",prop);
			}
		}
	}
}
//썜
/*window.onload = function() {
	var radio = document.getElementsByName("site");
	var prop="width=500px, height=500px";
	for(let i = 0; i<radio.length;i++){
		radio[i].onclick=function(this){
				console.log(radio[i].checked,i);
				console.log(this.checked);
				openURL(this.value,prop);
		}
	}
}
function openURL(url,prop){
	console.log(url);
	var urlName= url.substring(url.indexof(".")+1, url.lastIndexOf("."));
	console.log("이동하는 사이트명 : " + urlName);
	open(url, urlName,prop);
}
*/
//4번 전체선택버튼 구현하기
function allchk04(bool){
	var chkbox = document.getElementsByName("subject");
/*	for(let i = 0; i < chkbox.length; i++){
		chkbox[i].checked=bool;
	}*/
	for(let s of chkbox){
		s.checked =bool;
	}
}

//JQuert
$(function(){
	$("#allj").click(function() {
		if ($("#allj").prop("checked")){
			$("input[type=checkbox]").eq(0).prop("checked", true);
		}else {
			$("input[type=checkbox]").prop("checked", false);
				}
			});
	});


//체크 갯수 판단
function chks(){
	var chkcnt = document.getElementsByName("subject");
	var cnt = 0;
		for(let i =0; i < chkcnt.length; i++){
			if(chkcnt[i].checked){
				cnt++
			}
		}
		return cnt;
}

window.onload = function(){
	var chkcnt = document.getElementsByName("subject");
	var allchk = document.getElementById("all");
		for(let i = 0; i<chkcnt.length; i++){
			chkcnt[i].onclick=function(){
			if(chks(chkcnt)==chkcnt.length){
				allchk.checked=true;
			}else{
				allchk.checked=false;
			}
		}
	}
}
//5번 랜덤숫자생성하기
function randomNum05(){
	var int = Math.ceil(Math.random()*20+1);
	document.getElementById("rdmNum").value=int;
}

//6번 select태그 사용하기
function selPage06(){
	//selected : 자식 (option)중에서 선택된 자식의 상태
	// options : 자식의 tag의 집합
	// 			documet.getElementsByTagName("btn")
	//			DOM(select).options[]랑 같음
	//			selectedIndex
	var sel = document.getElementById("selsite");

	selidx = sel.selectedIndex;
	console.log(sel.options[selidx].value);
	
	location.href=sel.options[selidx].value;
}

//7번 숫자 정렬하기
function sortNum(){
	var result = new Array();
	txt = document.getElementById("numVal").textContent.split(",",8);
	for(let i =0;i<txt.length;i++){
		txt[i]=Number(txt[i]);
	}
	txt.sort(function(a,b){ // 혹은 ((a,b)=>a-b);
		return a-b;
	});
	document.getElementById("numSort").textContent=txt;
}
// 쌤 
function sort_Num(){
	var seq = document.getElementById("numVal").textContent;
	var seqVal = seq.trim();
	//var removespace = seq.replace(/\s/g,'');
	
	var arrSeq = seqVal.split(",");
	//javascript는 값을 가지고 정렬을 함 ==> 무조건 문자임 
	//모든 값은 문자로 처리한다 따라서 객체타입이 문자 혹은 숫자에 관계없이
	//Lexicographic, letters 순서로 되어 있음
	//callback 함수를 만들어 내부에서 각값들의 차이를 반환하도록 하는 함수를 만들어줘야함
	
	//자바스크립트에서는 desc는 없음 따라서 문자열 sort를 사용하여 정렬하고 reverse라는 함수를 사용해야함
	console.log(arrSeq,arrSeq.length);
	
}
//8번 나의 살아온 일수 구하기
function life(){
	var date = new Date();
	var y = date.getFullYear();
	var m = date.getMonth()+1+"";
	var d = date.getDate()+"";

	m=word(m);
	d=word(d);

	document.getElementById("nowDate").value=(y+"-"+m+"-"+d);

	today= new Date(document.getElementById("nowDate").value);
	birthDay = new Date( document.getElementsByName("birthday")[0].value);
	
	var resultDate = (today.getTime()- birthDay.getTime())/(1000*60*60*24);
	
	document.getElementById("dateVal").textContent=resultDate;

}

function word(x){
	if(x.length<2){
		x= "0"+x;
	}
	return x;
}

//9번 입력값 테이블로 출력하기(dom메서드사용)
function domTest(){
	var child = document.getElementById("formInfo");
	var div = document.getElementById("domTable");
	var table = document.createElement("table");
	var tr = document.createElement("tr");
	var td = new Array();
	
	for(let i = 0; i<child.length-1; i++){
		td[i]= document.createElement("td");
		td[i].setAttribute("style","background-color:yellow");
	}

	div.setAttribute("style","width:200px");
	
	for(let i = 0; i<child.length-1; i++){
		td[i].append(child[i].getAttribute("name")+" : "+ child[i].value);
		tr.append(td[i]);
	}
	table.append(tr);
	div.append(table);
}

//10.구구단 출력하기
function guguDanView(){
	var x = Number(document.getElementById("guguVal").value);
	var z = document.getElementById("guguPrint");
	var y = new Array();
	for(let i = 1; i<=9;i++){	
		y[i] = document.createElement("p");
	}
	for(let i = 1;i<=9; i++ ){ //우리은행 1005604126263 도희정 7,500
		y[i].textContent=(x+"x"+i+"="+x*i);
		console.log(y[i]);
		z.append(y[i]);
	}
}


