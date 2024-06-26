<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
	<form action="/signup/create" method="post">
		<input type="hidden" class="tableId" name="tableId" placeholder="tableId"><br>
		<input type="text" class="userId" name="userId" placeholder="아이디" required><br>
		<input type="text" class="userPw" name="userPw" placeholder="비밀번호" required><br>
		<input type="text" class="description" name="description" placeholder="설명"><br>
		<input type="text" class="userName" name="userName" placeholder="이름"><br>
		<input type="text" class="userAge" name="userAge" placeholder="나이"><br>
		<input type="text" class="userGender" name="userGender" placeholder="성별"><br>
		<input type="text" class="userMail" name="userMail" placeholder="이메일"><br>	
		<button id="confirm_btn" type="submit">확인</button>
	</form>
</body>
</html>