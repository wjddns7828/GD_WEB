function submitChk() {
	var inputChk = document.getElementsByTagName("input");

	for (let i = 0; i < inputChk.length; i++) {
		console.log(typeof i, i)
		console.log(typeof inputChk[1].value,inputChk[1].value )
		if(regexChk(i,inputChk[i].value)==false) {
			alertMsg(i);
			return;
		}

	}

	if (inputChk[0].value == "user" || inputChk[0].value == "admin") {
			alert("이미 있는 아이디 입니다.");
			inputChk[0].value = "";
			inputChk[0].focus();
			return;
		}
		for (let i = 0; i <= inputChk.length; i++) {
			if (inputChk[i].value == "") {
				alert("모든 값을 입력해 주세요");
				return;
			} else {
				document.getElementsByTagName("form")[0].submit();
			}
		}
}

function regexChk(i, inputChk) {
	var Parttern = [/^[a-zA-Z0-9]{3,20}$/, //id
		/^(?=.*[a-z])(?=.*\d)(?=.*[!@#$%^&*()_+\-=[\]{};':"\\|,.<>/?]).{3,20}$/,//pw
		/^[가-힣]+(?: [가-힣]+)*$/,//name
		/^01([0|1|6|7|8|9])\d{3,4}\d{4}$/];//phone

	return Parttern[i].test(inputChk);
}
function alertMsg(i) {
	switch (i) {
		case 0:
			alert("[아이디는 영문,숫자 3~20자리까지 가능합니다]");
			break;
		case 1:
			alert("[비밀번호는 영문 대문자 필수, 숫자 필수, 특수문자 필수 ]");
			break;
		case 2:
			alert("[이름의 형식이 잘못되었습니다.]");
			break;
		case 3:
			alert("[핸드폰 번호의 형식이 잘못되었습니다.]");
			break;
	}
}