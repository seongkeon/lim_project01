<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<p>
			<c:if test="${empty fList}">
			첨부된 파일이 없습니다.
			</c:if>
			<c:if test="${!empty fList}">
				<c:forEach var="fitem" items="${fList}">
					<a href="/download?rf_oriname=${fitem.rf_oriname}&rf_sysname=${fitem.rf_sysname}">
						<span class="file-title"> ${fitem.rf_oriname} </span>
					</a>
				</c:forEach>
			</c:if>
		</p>
	</div>
</body>
</html>