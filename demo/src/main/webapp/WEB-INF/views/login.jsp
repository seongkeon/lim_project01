<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
* {
	box-sizing: border-box;
}
.logo{
	width:200px;
	/* border: 1px solid; */
/* 	margin: 10px; */
}
html {
	height: 100%;
}
body {
	margin: 0;
	height: 100%;
}
section{
	height: 100%;
	/* background:red; */ 
	display: flex;
    justify-content: center;
    align-items:center;
}
.wrap{
	/* background: blue; */
	position:relative; 
	bottom: 80px;
}
.title{
	text-align:center;
	margin: 5px;
}
.content_section {
	/* border: 2px solid; */
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
	
}
input{
	border: 0px;
	background-color: #2C599D;
	width: 200px;
	height: 60px;
	color: white;
	text-align:center;
}
input::placeholder{
	color: white;
	text-align:center;
}
input:hover{
	border: 3px #FB9B50 solid ;
}
.userId, .userPw{
	margin: 10px;
}
#login{
	width: 200px;
	margin: 5px;
	background-color: #FB9B50;
	border: 0px;
	color: white;
}
#signup{
	width: 200px;
	margin: 5px;
	background-color: #FB9B50;
	border: 0px;
	color: white;
}


</style>
</head>
<body>
<section>
	<div class="wrap">
		
		<div class="title"><img alt="로고" src="images/jirungi_logo_new.png" class="logo"></div>

		<div class="content_section">
			<div class="content_inner">
				<form action="/login/login_try" method="post">
					<input type="text" name="userId" class="userId" placeholder="아이디" title="아이디" size=17 required><br> 
					<input type="password" name="userPw" class="userPw" placeholder="비밀번호" title="비밀번호" size=17 required>
					<button id="login" type="submit">로그인</button>
				</form>			
			</div>
			<button id="signup" type="submit">회원가입</button>
		</div>
	</div>
</section>
<footer>
</footer>
</body>
<script>
	$("#signup").click(function(){
		location.href="/signup"
	})
	
</script>
</html>