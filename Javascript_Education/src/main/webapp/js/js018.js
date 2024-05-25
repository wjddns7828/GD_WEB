// TODO js_018_001_2 전체 선택 버튼
function allSelect(bool){
	console.log("체크상태 : " + bool);
	var all = document.getElementsByName("allcheck")[0].checked;
	console.log("DOM탐색을 통한 체크상태" + all);
	
	var chks = document.getElementsByName("chk");
	for(let i = 0; i<chks.length;i++){
		chks[i].checked = bool;
	}
}

//3) 선택된 색상을 div 박스에 해당 컬러를 입혀줌

function selColor(){
	var chks = document.getElementsByName("chk");
	console.log("chk의 전체 갯수"+chks.length);
	console.log("chks의 선택갯수"+chkCheck(chks));

	//5)
	if(chkCheck(chks)>0){
		for(let i in chks){
			if(chks[i].checked){
				document.getElementById(chks[i].value).style.backgroundColor=chks[i].value;
			}else{
				document.getElementById(chks[i].value).style.backgroundColor="white";
			}
		}
	}else{
		alert("최소 한개 이상을 선택해주셔야 합니다.");
	}
}
//4)chks의 선택 여부 판단
function chkCheck(chks){
	let cnt=0;
		for(let i of chks){
			if(i.checked){
				cnt++;
			}
		}
	return cnt;
}

//6) chk의 갯수따라서 allchecked를 판단하는 fn
window.onload=function(){
	var chks = document.getElementsByName("chk");
	var allchks= document.getElementsByName("allcheck")[0];
	
	for(let i = 0; i<chks.length; i++){
		chks[i].onclick = function(){
			if(chkCheck(chks)== chks.length){
				allchks.checked = true;
			}else{
				allchks.checked = false;
				
			}
		}
	}
}

