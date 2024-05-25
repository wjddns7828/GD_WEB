function jsSubmit(){
	//form을 찾는 방법	
	
	
	//1)Dom 탐색
		var form01 = document.getElementById("was");
	//2)tag
		var form02=document.forms[0];
		
	//3)name
		var form04=document.frm;
		
	//유효값 검사
		var queryText = document.getElementsByName("query")[0].value;
		if(queryText !=""){
			form03.submit();			
		}else{
			alert("필수값을 입력하세요");
		}
}


function textareaChk(){
	
	/*
		markup으로 되어있는 tag는 모두 화면에 출력되어 text로 되어있음
		String인 글만 가지고 옴
		
		하위에 있는 HTML을 가져오기 위해서는 innerHTML을 사용한다
		
		textArea는 문자로 작성되어지는 공간
		따라서 HTML 및 javascript동작이 되지않음
		
		textarea의 줄바꿈은 (\n\r로 되어있음) => DB =>HTML출력 줄바꿈 tab등과 같은 표현이 되지않ㅇ므
			\n\r을 HTML tag인 <br>로 변경해줘야함
		textarea에 의도적으로 javascript를 작성하면 =>DB => HTML로 출력을 하게되면 기능을 동작시킴
			javascript 혹은 tag를 제거해야함
			var newtxt = original.replace(/(<(^)+>)/igm,""); 
									ㄴ정규화 표현식을 작성해서 잡아내고 그 부분을 " "로 바꿔줌
		
		
	*/
	
	var txt = document.getElementById("txt");
	console.log("value : "+txt.value);
	console.log("textContent : "+txt.textContent);
	console.log("innerHTML : "+txt.innerHTML);
//	txt.value = "반값습니다";
//	txt.innerHTML="<b>HTML작성</b>";
	txt.textContent="글작성";
}


onload = function(){
	var today = document.getElementById("date");
	var date = new Date;
	console.log(date);
	
	var y = date.getFullYear();
	var month = date.getMonth()+1;
	var d = date.getDate();
	
	month = format(month);
	d = format(d);
	console.log(y,month,d);
	
	var result = (y+"-"+month+"-"+d);
	today.value=result;
}

function format(x){
	var m = x+"";
	
	if(m.length<2){
		m= "0"+m;
	}
	return m;
}