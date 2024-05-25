function numTest(val){
	console.log("전달 깂:", val, typeof val);
	var cal = val+10;
	console.log("전달 깂:", cal, typeof cal);
	
	var cal= Number(val)+20;
	console.log(typeof cal, cal);
	
	var calobject = new Number(val);
	console.log(typeof calobject, calobject.toString()+1);
	console.log(typeof calobject, calobject.valueOf()+1);
}

function intTest(val){
	
	//parseInt
	var vals = parseInt(val)+5;
	console.log(typeof vals, vals);
}

function floatTest(val){
	//parseFloat
	var flo = parseFloat(val)+5;
	console.log(typeof flo, flo);
}

function evalTest(){
	var val = document.getElementsByName("eValue")[0];//nodeList
	console.log(val);
	if(confirm("입력하신 코드가 맞습니까?"+val.value)){
		document.getElementsByTagName("span")[0].innerHTML=
		"<b>"+eval(val.value)+"</b>";
	}else{
		val.value="다시작성하세요 예>10+1";
	}
}


window.onload = function(){
	/*alert("온로드");*/
	var h3 = document.getElementsByTagName("h3");
	var view = document.getElementById("view");
	
	for(let i =0; i<h3.length; i++){
		h3[i].onclick = function(){
			if(this.textContent=="="){
				calView();	
			}else if(this.textContent=="초기화"){
				remove();
			}else if(this.textContent=="지움"){
				erase();
			}else{
				
				view.innerHTML+=this.textContent;
				
				document.getElementById("result").innerHTML =
				"계산결과 : <b>" +view.innerHTML+"</b>";
			}
		};
	}
	
}

function calView(){
	var view = document.getElementById("view");
	var cal = eval(view.textContent);
	console.log(cal);
	document.getElementById("result").innerHTML =
		"계산결과 : <b>" +cal+"</b>";
}
function remove(){
	var view = document.getElementById("view");
	view.textContent="";
	console.log(view.textContent);
	document.getElementById("result").innerHTML = "계산결과 : <b>"+" "+"</b>";
}
function erase(){
	var view = document.getElementById("view");
	view.textContent= view.textContent.substr(0,view.textContent.length-1);
}