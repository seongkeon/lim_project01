<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그림 요청</title>
</head>
<body>
	<form action="/main/requestWrite" method="post" enctype="multipart/form-data">
		<input type="hidden" class="reqId" name="reqId"><br>
		<input type="hidden" class="reqAssigned" name="reqAssigned" value="false"><br>	
		<input type="hidden" class="reqTime" name="reqTime"><br>
		<input type="text" class="reqClient" name="reqClient" placeholder="reqClient"><br>
		<input type="text" class="reqTitle" name="reqTitle" placeholder="reqTitle" required><br>
		<input type="radio" class="reqOrder" id="before_pay" name="reqOrder" value="선불"><label for='before_pay'>선불</label>
		<input type="radio" class="reqOrder" id="after_pay" name="reqOrder" value="후불"><label for='after_pay'>후불</label>
		<br>
		<input type="text" class="reqPay" name="reqPay" placeholder="reqPay"><br>
		<input type="file" class="files" name="files" multiple><br>
		<textarea class="reqContent" name="reqContent" placeholder="reqContent"></textarea><br>		
		<button type="submit">확인</button>
	</form>
</body>
</html>