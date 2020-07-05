<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/sessionCheck.jsp" %>
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
		<h1>회원게시판</h1>
	</div>
	<%@include file="/bootstrap/ex/ex02.jsp" %>	
<%@ include file="/afterLogin/include/footer.jsp" %>
</body>
</html>

