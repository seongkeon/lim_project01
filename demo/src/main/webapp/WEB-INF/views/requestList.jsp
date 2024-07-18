<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>의뢰 목록</title>
</head>
<style>
	th, td{ border: 1px solid black }
	table{border-collapse:collapse}
	.reqId:hover {
		background: gray;
		color: pink;
	}
</style>
<script>
	function requestDetail(reqId){
		alert("requestdetail()" + reqId);
		location.href="/main/requestList/requestDetail?reqId=" + reqId;
	}
</script>
<body>
<table>
	<colgroup>
		<col style="">
		<col style="">
		<col style="">
		<col style="">
		<col style="">
		<col style="">
		<col style="">
	</colgroup>
	<thead>
		<tr>
			<th>순번</th>
			<th>선/후불</th>
			<th>제목</th>
			<th>보수</th>
			<th>의뢰인</th>
			<th>배정</th>
			<th>시간</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="item" items="${rList}">	
			<tr>
				<td class="reqId" onclick="requestDetail(${item.reqId})">${item.reqId}</td>
				<td>${item.reqOrder}</td>
				<td>${item.reqTitle}</td>
				<td>${item.reqPay}</td>
				<td>${item.reqClient}</td>
				<td>${item.reqAssigned}</td>
				<td>${item.reqTime}</td>
			</tr>
		</c:forEach>
	</tbody>	
</table>
</body>
</html>