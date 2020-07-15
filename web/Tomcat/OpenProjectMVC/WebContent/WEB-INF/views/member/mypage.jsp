<%@page import="member.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
	<%
	/* request.setAttribute("member", member);
	request.setAttribute("result", resultCnt); */
	Member member=(Member) request.getAttribute("member");
	%>
<!-- 	<script>alert(${member});</script>
 --><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/default.css" rel="stylesheet">

</head>
<body>


	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<div class="container">
		<h1>마이페이지</h1>
	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>