<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="top-bar">
	<div class="content">
		<img alt="로고" src="images/jirungi_logo.jpg" class="logo"
			onclick="gomain()">
	</div>
</div>

<script>
	function gomain(){
		let id = "${user.tableId}";
		alert(id);
		
		if(id == ""){ //로그인 전
			location.href = "/login";
		} else {  //로그인 후
		      location.href = "/main";
		}
	}
</script>