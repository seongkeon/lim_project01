<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
	.logo{
		width: 100px;
	}
</style>
<div class="top-bar">
	<div class="content">
		<img alt="로고" src="images/jirungi_logo.png" class="logo"
			onclick="gomain()">
			
		<nav class="top-right">
			<ul class="top-right-list">
				<li>userId</li>
				<li>userName</li>
			</ul>
		</nav>
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