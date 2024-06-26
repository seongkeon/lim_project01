<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
</head>
<style>
	.option{
		background:pink;
		width: 200px;
		height: 200px;
		margin: 50px;
		display: flex;
		justify-content: center;
		align-content: center;
		align-items:center;
	}
	.option_1:hover{
		color:blue;
		cursor: pointer;
	}
	.option_1:active{
		background: gray;
		color:black;
	}
	.container{
		justify-content: center;
	 	display: flex;
	} 
</style>
<script>
	function request(){
		location.href="/main/requestForm";
		
	}
</script>
<body>
<div class="container">
	<div class="option option_1"  onclick="request()"><span class="option_1_style">의뢰하기</span></div>
	<div class="option option_2">의뢰 목록</div>
</div>
${user.userId}
${user.userName}
</body>
</html>