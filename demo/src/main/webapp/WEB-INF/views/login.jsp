<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
.header{
	text-align:center;
	margin: 5px;
}
.content {
	border: 2px solid;
	border-color: black;
	margin: 0 auto;
	width:250px;
	height:250px;
	text-align:center;
}
.content_inner{
	margin: 0 auto;
	display: flex;
	justify-content: center;
	/* background:skyblue; */
}
input{
	/* background-color: blue; */
}
</style>
</head>
<body>
	<header class="header">
		<div class="header_inner">Login</div>
	</header>
	<div class="content">
		<div class="content_inner">
			<form action="/login/login_try" method="post">
				<input type="text" name="userId" class="userId" placeholder="아이디" title="아이디" size=17 required><br> 
				<input type="password" name="userPw" class="userPw" placeholder="비밀번호" title="비밀번호" size=17 required>
				<button id="login" type="submit">로그인</button>
			</form>			
		</div>
		<button id="signup" type="submit">회원가입</button>
	</div>
</body>
<script>
	$("#signup").click(function(){
		location.href="/signup"
	})
	/* $("#login").click(function(){
		location.href="/login/login_try"
	}) */
</script>
</html>