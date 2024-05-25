/**
 * 
 */
 
 function function01(){
	console.log("명수적 함수")
}
 
 //익명적 함수 : 함수인데 이름을 가지고 있지않음
 var function02 = function (){
	console.log("익멍적 함수")
}
 
 //함수 리터럴 : 함수가 변수의 갑싱 되어 사용됨
 			// arguments/prameter도 변수 => 함수가 다른 함수를 arguments로 받을 수 있다
 function function03(){
	literalFn(function(msg){alert(msg);});
}

 function literalFn(literal){
	literal("안녕하세요 함수입니다.");
}

function valuesArguments(a,b,c,d){
	console.log(arguments[0]);
	console.log(arguments[1]);
	console.log(arguments[2]);
	console.log(arguments[3]);
	console.log(arguments[5]);
	
	try{
	console.log(a,b,c,d,e);
	}catch(err){
		alert(err);
	}
	console.log("Arguments");
	
}
	//index for 문
	//enhanced for 문 두 개(in/of 연산자)의 연산자를 가지고 있음
	// in array의 index번호를 출력
	// of array의 객체를 반환
	
//HTML을 DOM탐색하면 결과는 작성된 방식, ㅠㅗ함된 node에 따라서 결과가 다름
function pPrint(){
	var p = document.getElementsByTagName("p");
	console.log(p);
	
		//index방식으로 in을 한다면 web에서의 DOM탐색 결과는 다를 수 있음
	for(let i in p){
		console.log(p[i].tagName,p[i].textContent);
	}
	// 기존 방식
	for(i=0; i<p.length; i++){
		console.log(p[i].tagName,p[i].textContent);
		
	}

	
	
	
	for(let i of p){
		console.log(i,i.textContent);
	}
}

function closureTest(){
	closureFn("JS")("KOR");
}

function closureFn(val){
	function addVal(msg){
		alert(val+":"+msg);
	}
	return addVal;
}

//var amEdu = function(val){console.log(val);};
var amEdu = closureFn("HTML");
console.log(amEdu);
console.log(typeof amEdu);



//setIntaval (실행 함수, 반복시간)
/*var demo = document.getElementById("demo")
var start = setInterval(function(){demo.innerHTML+='hello'},1000);

function stopIntervar(){
	clearInterval(start);
}*/
