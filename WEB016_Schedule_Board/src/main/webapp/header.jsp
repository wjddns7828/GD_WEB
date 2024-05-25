<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<script type="text/javascript" src="./js/calendar.js"></script>
<style type="text/css">
	header{
		background-color: #BDBDBD;
		height: 70px;
		box-sizing: border-box;
		color: #000000;
		text-align: right;
		padding-right: 10px;
	}
	a{
		text-decoration: none;
	}
	#container{
		width: 800px;
		height: 480px;
		margin:  40px auto;
	}
	#calendar{
		border: 1px solid #ccc;
		border-collapse: collapse;
		margin: auto; 
	}
	#calendar th{
		width: 80px;
		border: 1px solid #ccc;
	}
	#calendar td{
		width: 80px;
		height : 80px;
		border: 1px solid #ccc;
		text-align: left;
		vertical-align: top;
		position: relative;
	}
	.cPreview{
		position: absolute;
		background-color: #CEFBC9;
		top : -30px;
		left: 10px;
		width: 40px;
		height: 40px;
		opacity: 70%;
		text-align: center;
		font-weight: bold;
		font-size: 20px;
		color: #BDBDBD;
		line-height: 40px;
		border-radius: 30px 30px 30px 1px;
	}
	.clist{
		margin-top: 10px;
	}
	.clist{
		font-size: 8px;
		margin: 2px;
		background: #FAF4C0;
		border-radius: 3px;
	}
	a>img{
		width: 16px;
		height: auto;
	}
	.warp_loding{
		position: fixed;
		left: 0px;
		right: 0px;
		top:0px;
		bottom:0px;
		background: rgba(0,0,0,0.2);
	}
	.warp_loding div{
		position: fixed;
		top:30%;
		left: 40%;
	}
	.warp_loding img{
		width: 50%;
		height: 50%;
	}
</style>
</head>
<body>
	<header>
		<div>
			<div>아이디 : ${sessionScope.id}</div>
			<div>이름 : ${sessionScope.name}</div>
			<div>
				<a href="CalController.do?command=sessionDel">세션삭제</a>
			</div>
		</div>
	</header>
</body>
</html>