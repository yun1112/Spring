<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
		/* String username=response. */
		/* request.setAttribute("username",username); */
	%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Main</title>

<!-- <link href="css/membermgr.css" rel="stylesheet">
<script src="js/membermgr.js"></script> -->
</head>

<body>
	<header>
		<h1>Main</h1>
	</header>
	<div id="content">
	<form action="forward.jsp">
	
	<%-- 	<%@ include file="div/loginForm.jsp"%> --%>
	이름<input type="text" name="username">
	<input type="submit" value="click">
	</form>
	</div>
</body>

</html>

