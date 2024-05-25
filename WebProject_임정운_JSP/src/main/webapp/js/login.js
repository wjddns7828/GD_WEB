function loginChk(){
	var id = document.getElementById("id").value;
	var pw = document.getElementById("password").value;
	var form = document.getElementsByTagName("form")[0];
		
	if(inputChk(id) && inputChk(pw)){
		form.submit();
	}else{
		alert("뭐하냐? 제대로 입력해라");
	}
}

function inputChk(id){
	var idpattern = /^[a-zA-Z0-9]{3,20}$/;
	return idpattern.test(id);
}
