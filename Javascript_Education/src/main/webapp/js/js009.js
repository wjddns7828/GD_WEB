/**
 * 
 */
 function numberTest(){
	var num1 = new Number(7);
	var num2 = 10;
	
	console.log(num1.toString());
	console.log(num2);
	
	//비교 ==, ===(명확한 비교)
	document.writeln(num1==7);
	document.writeln(num1.toString==7+"<br>");
	document.writeln(num2===10);
	
	console.log(typeof num1.toString());
	console.log(typeof num1.valueOf());
	console.log(num1.valueOf(),num2);
	
	document.write(1=='1');
	document.write("속성 NaN :" + parseInt("a")+"<br>");
	
	//infinity 속성
	//무한의 값을 표현해주는 값
	document.write("속성 : infinity :" + (Number.MAX_VALUE+0.00000001e+308));
	
	//number 객체 함수
	//1) toFixed(): 실수형의 소수점 자리를 지정하면 반올림 하여 문자열 반환
	var double=3.011846
	var d = double.toFixed(4);
	console.log(d);
	
	//2) toString():보이는 그대로 문자열로 변경해줌
	console.log(num2.toString(),typeof num2.toString());
	console.log(num2.toString(8));
}

function isNumber(){
	//is Na를 통해서 판변 할 수 있다
	var prop = prompt("숫자만 입력해 주세요");
	if(isNaN(prop)){
		alert("숫자가 아닙니다.");	
	}else{
		alert("숫자입니다");
	}
}

function isRegEx(){
	//숫자만 판별하고 싶다.
	var regEx = /^[0-9]*$/
	var num = document.getElementById("num").value;
	if(!regEx.test(num)){
		alert("숫자만 입력해주세요")
	}else{
		alert("숫자만 확인하였습니다.")
	}
}

function isphone(){
	//전화번호 확인 정규화
	var regEx = /^\d{2,3}-\d{3,4}-\d{4}$/gim;
	var phone = document.getElementById("phone").value;
	if(!regEx.test(phone)){
		alert("형식에 맞는 번호를 입력해주세요");
	}
}
/**
	정규화 표현식 javascript
	^ <<무조건 있어야 한다
	$ <<종료
	[ - ] <<범위
	* <<반복
	\d << 숫자만
	{} << 반복
	g << 발생되는 모든 패턴 전역 검색
	i << 대소문자를 구분하지않음
	m << 여러줄 검색
 */




















