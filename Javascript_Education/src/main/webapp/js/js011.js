/**
 * 
 */ 
 //intival의 값을 유효값 처리하고 antStage()에 값을 입력하여 실행
 function antPrint(){
	var inputVal = document.getElementById("initval");
	
	if(isNaN(inputVal.value)){
		alert("숫자만 입력해주세요");
		inputVal.value="";
		inputVal.focus();
	}else if(inputVal.value >= 10 || inputVal.value < 2){
		alert("범위에 맞는 층수를 입력해 주세요");
		inputVal.value="";
		inputVal.focus();
	}else{
		//1) innerHTML: 결과를 HTML로 만들어 해당 위치의 값으로 넣어줌 (단점: HTML만드는게 힘듬)
		/*var resultAnt = "";
		for(let i = 0; i<inputVal.value; i++){
			resultAnt+="<span>"+antStage(i)+"</span><br>";
		}
		document.getElementById("printArea").innerHTML=resultAnt;*/
		
		//2) createElement방식 append
		var div = document.createElement("div");
		for(let i =0; i <inputVal;i++){
			var childDiv= document.createElement("div");
			childDiv.innerHTML=antStage(i);
			
			div.appendChild(childDiv);
		}
	 	var print = document.getElementById("printArea");
	 	print.innerHTML="";
	 	print.style.backgroundColor="skyblue";
	 	print.appendChild(div);
	}
}

//makeAnt에 '11'을 입력하고 stage가 있다면 다음 값을 초기값을 만들어주고
 function antStage(st){
	let initVal='11';
	for(let i = 0; i<st;i++){
		console.log(initVal);
		initVal = makeAnt(initVal);
	}
	console.log(initVal);
	return initVal;
}

//다읍값을 반환 11->12
 function makeAnt(ss){
	var result = "";
	var c = ss.charAt(0);
	var cnt=1;
	for(let i = 1; i<ss.length; i++){
		if(c==ss.charAt(i)){
			cnt++;
		}else{
			result= result+c+cnt;
			c=ss.charAt(i);
			cnt=1;
		}
	}
	return  result= result+c+cnt;
}