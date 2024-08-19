<%@page import="com.example.demo.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
	.option_2:hover{
		color:blue;
		cursor: pointer;
	}
	.option_2:active{
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
	function requestList(id){
		location.href="/main/requestList?tableId=" + id;
	}
	function mypage(id){
		alert("id = " + id);
		location.href="/main/myInfo?tableId=" + id;
	}
</script>
<body>
<header>
	<jsp:include page="header.jsp"></jsp:include>
</header>
<section>
	<div class="container">
		<div class="option option_1" onclick="request()"><span class="option_1_style">의뢰하기</span></div>
		<div class="option option_2" onclick="requestList(${user.tableId})"><span class="option_2_style">의뢰 목록</span></div>
	</div>
	${user.tableId}
	${user.userId}
	${user.userName}
	<div class="mypage" onclick="mypage(${user.tableId})">마이페이지</div>
	
</section>
<footer>
</footer>
</body>
<script>
	$(document).ready(function() {
		alert("main ${user.tableId}");
	});
</script>
</html>