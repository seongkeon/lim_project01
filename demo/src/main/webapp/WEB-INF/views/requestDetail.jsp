<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>의뢰 상세</title>
</head>
<body>
<div>
	<p>${req.reqId}</p>
	<p>${req.reqClient}</p>
	<p>${req.reqTitle}</p>
	<p>${req.reqPay}</p>
	<p>${req.reqOrder}</p>
	<p>${req.reqContent}</p>
	<p>${req.reqAssigned}</p>
	<p>${req.reqTime}</p>
</div>
</body>
</html>