/**
 * 
 */
 function StringTest01(){
	//concatenation 
	// x.concat(y)를 통해서 x와 y를 하나의 문자열로 만들어준다
	//+연산자
	
	var str01 = "String";
	var str02 = "javascript";
	var str03 = str01 + (1+0.1)+str02;
	var str04 = str01.concat(str02);
	
	console.log(str01);
	console.log(str02);
	console.log(str03);
	console.log(str04);
	
	//join 문자열 통합
	var joinString = ["99",66,10].join('/');
	console.log(joinString);
}
 
 function StringTest02(){
	//연산자 우선순위
	var d= 1;
	var f=1.1;
	var bool=true;
	
	var result = "";
	
	console.log(result = result+d+f+bool);
	
}
 
 function StringTest03(){
	// ==동등연산자, ===명확한 비교
	
	var strVal = prompt("숫자를 넣어주세요");
	var span = document.getElementById("cmd");
	//정규화 표현식 작성방법 testMatch
	// 정규화 표현식.test("비교값")
	// 비교값.match("정규화표현식")	
	if(strVal.match(/[2-9]/)){
		alert("숫자가 2~9까지 입력해주세요");
	}else if (strVal==1){
		span.textContent = strVal+"님 환영합니다";
	}else{
		span.textContent ="숫자를 다시 입력해주세요";
	}
	
	//완벽한 비교
	var objStr1 = new String("월요일");
	var objStr2 = "월요일";
	
	if(objStr1 === objStr2){
		console.log("같다")
	}else{
		console.log("다르다")
	}
}
 
 function StringTest04(){
	//indexOf();
	var strword = "흥부 놀부 까치 도깨비";
	var find = prompt("검색어를 입력해주세요");
	console.log(strword.indexOf(find));
	console.log(strword.indexOf(find,7));
	console.log(strword.lastIndexOf(find,7));
}
 
 function StringTest05(){
	var strVal="문자열 추출, indexIf        : lastIndexOf              ";
	var comma =  strVal.indexOf(",");
	console.log(strVal.substring(0,comma));
	
	//split
	var val = "oop:ooo:foo";
	var valSplit = val.split(":");
	console.log(valSplit.length);
	console.log(valSplit);
	
	var valSplit_o = val.split("o");
	console.log(valSplit_o.length);
	console.log(valSplit_o);
	
	var charAt = strVal.charAt(4);
	console.log(charAt, typeof charAt);
}
 
 function StringTest06(){
	var val = prompt("쉼표로 구분하여 입력해 주세요","");
	var splitVal = val.split(",");
	for(let i of splitVal){
		console.log(i);
	}
}
 