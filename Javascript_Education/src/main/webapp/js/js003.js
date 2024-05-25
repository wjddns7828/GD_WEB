/**
 * 화면에 DOm탐색을 한 후 결고 "",null 
 */
 function variable_scope(){
	var empty=document.getElementById("empty");
	console.log(empty); //탐색 결과가 없으면 null
	//console.log(empty.value); //null에 기능(function)동작 오류 발생
	var uninitial;
	console.log(uninitial);//undefined 화면이 아니라 javascript에서 선언만 되어있는 변수를 호출했을 떄
	console.log(typeof uninitial);
	console.log(typeof empty);
	
	var intitial_value=10;
	console.log(typeof intitial_value);
	intitial_value ='rainbow';
	console.log(typeof intitial_value);
	intitial_value =true;
	console.log(typeof intitial_value);
	intitial_value =3.14;
	console.log(typeof intitial_value);

/*
	javascript는 같은 변수에 다른 타입의 값을 대입 할 수 있다.
	같은 이름의 변수를 계속해서 선언 할 수 있다
	scope는 var로 선언된 변수에서 사용가능함(변수 선언종류: var let(지역변수) const(재입력 불가))
*/	
	console.log("a="+a);
	var a =10;
	var date = new Date();
	if(1){//논리연산자의 판단 : 객체가 있거나 true이거나 1이면 실행
		//console.log(a);
		
		var b = 100;
		
		for(var c=0; c<5; c++){
			console.log("c="+c);
		}
		console.log("c="+c);
		
	}//if
	console.log("b="+b);
	//ES6문법 var의 scope가 너무 사용하기 어렵기 때문에 선언을 구분하여 사용
	//지역변수인 let 
	//상수인 const
	
	//console.log(i); //let는 선언된 변수 다음에만 사용 가능
	let i = 1;
	
	for(let j=0; j<3; j++){	
		console.log(j);
		}
}
//		console.log(j);//let은 scope의 범위가 한정적이다

	
	//const PI;//const variables must have an initializer 반드시 선언과 입력이 동시에 작업해야함
//전역변수
//상위에 선언된 변수를 javascript에서 모두 사용 할 수 있다.
var variable =100;

function global_variable(){
	console.log("global_variable"+variable);
	variable = variable+11;
	document.getElementById("v1").textContent=variable;
	document.querySelector("input").value=variable
}

function local_Scope(){
	console.log("local_Scope");
	//64번째 줄에 variable의 변수명으로 전역변수가 선언된다
	//근데 만약에 함수내에서 variable변수를 재정의하면 -> 지역변수 로변경
	alert(variable);//전역변수의 호출
	var variable=variable+99; //지역스코프로 변경됨
	document.getElementById("v2").textContent=variable;
}

function local_Variable(){
	let variable1= variable+99;
	document.getElementById("v2").innerHTML="<b>"+variable1;
}

function variableType(){
	var var02=5;//number
	var var03=3.14;//nubmer
	console.log(typeof var02);
	console.log(typeof var03);
	var var04='문자';//string
	console.log(typeof var04);
	var var05= [3,4,5,'4'];//object
	console.log(typeof var05);
	console.log(var05.length);
	for(let i =0; i<var05.length;i++){
		console.log(i,var05[i],typeof var05[i])
	}
	for(let n of var05){
		console.log(n)
	}
	
	var var06=false;
	console.log(typeof var06);
	console.log(typeof (false+10));
	
	var var07=null; //object
	console.log(var07);
	console.log(typeof var07);
	
	var undef;
	console.log(undef);
	console.log(undef+1);//undefine(정의가 되지않은 값)에 숫자연산을 처리하면 NaN(Not a  Number)
	console.log(undef+"kor");//undefined kor
	
	//변수에 function 대입하기
	//변수에 함수를 값으로 가지고 있다면 함수는 이름을 필요로 하지않음(익명 함수)
	var var08 =function(x,d){
		console.log(x,d);
		return x;
	};
	//javascript의 function parameter/argument가 선언되어 있어도
	//필수값이 아님, 선언만 되어 있는 변수가 되기 때문에 undefinded가 된다
	var08('임정운',123);
	console.log(var08);
	console.log(typeof var08);
	
	
	//Web에서에 객체는 Node,Element
	//HTML은 tag로 되어 있음
	// HTML에서 하위에 있는 Body tag를 탐색하면 element를 가지고옴 ==> 객체
	//HTML 내에 단독으로 존재 할 수 있는 값(속성)을 ID로 탐색하면 하나의 element를 줌
	// 			ㄴ 단독이 아니라 여러개의 속성을 받아오면 elements로 줌 elemtents ==> array
	// ※※※※ DOM탐색 후 ID,Class,Name,Tag 등이 없다면 null이 됨
	
	var var10 = document.getElementById ("v1");
	console.log(typeof var10);
	console.log(var10);
	alert(var10);
	
}











































































































































































































































































