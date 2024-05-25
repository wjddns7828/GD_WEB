function tableInput(){
	/*
		<form>를 사용하는 이유는 값을 전달하기 위한 영역을 잡아줌
		영역에서는 action이라는 특성과 method라고 하는 특성 그리고 require라는 특성이 있음
		require를 통해서 기본적 submit처리시 유효값을 처리해줌
		값을 유효값을 처리해주는 로직을 필요로함
		화면에는 input4개를 작성, DOM탐색 4번 해야함 input[type="text"]도 가능
		
		<form>tag는 탐색하는 방법은 3가지 있음
		1) var doc = document.forms[0]
		2) var doc = document.frm;
		3) var doc = document.getElementByXXX사용;
		
		<form>내에서만 동작되는 form요소 : submit, reset =>반드시 form태그 안에 존재해야함
		
		<input type="submit">을 클릭하면 form에 있는 속성의 속성인 action의 주소로 값(HTML)을 전달함
		
		javascript를 통해서 submit button이 아닌 javascript를 통해서 form의 submit을 동작시킬 수 있음
			doc.submit();
	*/
	var doc = document.frm;
	var vals = [doc.id.value, doc.pw.value, doc.addr.value,doc.phone.value];
	console.log(vals);
	
	//유효값 검색
	for(let i=0; i<vals.length; i++){
		if(vals[i]==''){
			alert("모든값을 입력해주세요")
			return
		}
	}
	console.log("유효값 이후 로직")
	var tbody = document.getElementById("addr");
	var trlength = tbody.children.length;
	
	(trlength)<10? tbody.appendChild(createRow(vals)):alert("10개까지만 추가 가능합니다.");
	
	
}
function createRow(vals){
	var tr = document.createElement("tr");
	for(let i in vals){
		var td = document.createElement("td");//$(tr)
		td.textContent=vals[i];
		tr.appendChild(td);
	}
	//삭제 버튼 만들기
	var delBtn= document.createElement("td");
	delBtn.innerHTML="<input type='button' value='삭제' onclick='delRow(this)'>";
	tr.appendChild(delBtn);
	
	return tr
}
function delRow(ele){
	ele.parentNode.parentNode.remove();
	
	var delTr=ele.parentNode.parentNode;
	var tbody=document.getElementById("addr");
	tbody.removechild(delTr);
}

function deleteTable(){
	var tbody=document.getElementById("addr");
	tbody.innerHTML="";	
}
