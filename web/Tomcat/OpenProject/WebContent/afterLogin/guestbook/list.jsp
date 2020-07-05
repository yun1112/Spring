<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/default.css">

<style>
</style>
</head>
<body>

<%@ include file="/afterLogin/include/header.jsp" %>
	<div id="div1">
		<h1>비회원게시판</h1>
	</div>
<%@include file="/bootstrap/ex/ex01.jsp" %>	
<%@ include file="/afterLogin/include/footer.jsp" %>
</body>
</html>

