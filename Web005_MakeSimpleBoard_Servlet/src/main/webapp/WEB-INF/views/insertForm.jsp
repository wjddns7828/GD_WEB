<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function nullchk() {
			var inputChk = document.getElementsByTagName("input");
			var form = document.getElementsByTagName("Form")[0];
		for (let i = 0; i < inputChk.length; i++) {
			console.log(inputChk[i].value);
			if(inputChk[i].value==""){
				alert("모두 입력해 주세요");
				return
			}else{
				form.submit();
			}
		}
	}
</script>
<body>
	<form action="./insertForm.Servlet" method="post">
		<input type="text" placeholder="제목" name="title">
		<input type="text" placeholder="작성자" name="writer">
		<br>
		<input type="text" placeholder="내용" name=content>
		<br>
		<input type="button" onclick="nullchk()" value="작성">
	</form>		
</body>
</html>