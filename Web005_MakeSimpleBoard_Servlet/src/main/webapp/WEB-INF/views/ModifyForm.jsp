<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String seq = (String)request.getAttribute("seq");
%>
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
// 				var seq = document.getElementById("seq").value;
				form.action="./ModifyForm.Servlet";
				form.submit();
			}
		}
	}
</script>
<body>
	<form  method="post">
	<input type="hidden" id="seq" name="seq" value="<%=seq%>">
		<input type="text" placeholder="제목" name="title">
		<br>
		<input type="text" placeholder="내용" name="content">
		<br>
		<input type="button" onclick="nullchk()" value="작성">
	</form>		
</body>
</html>