<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<%
	CookieBox cookieBox = new CookieBox(request);

%>
 	
 	<c:set var="cookieBox" value="${cookie.cookieBox}"/>
 	<c:set var="cookiePw" value="${cookie.cookieBox.pw}"/>
 	<c:set var="cookieUname" value="${cookie.cookieBox.uname}"/>
 	<c:set var="cookieEmail" value="${cookie.cookieBox.email}"/>
 	<c:set var="cookieImg" value="${cookie.cookieBox.img}"/>
 	
 	<c:set var="uidValue=" value=""/>
 	<c:set var="pwValue=" value=""/>
 	<c:set var="unameValue=" value=""/>
 	<c:set var="emailValue=" value=""/>
 	<c:set var="imgValue=" value=""/>
 	
 	<c:if test="${!empty cookieUid} && ${!empty cookiePw} && ${!empty cookieUname} && ${!empty cookieEmail} && ${!empty cookieImg}">
 		<c:set var="uidValue" value="${cookieUid }"/>
 		<c:set var="pwValue" value="${cookiePw }"/>
 		<c:set var="unameValue" value="${cookieUname }"/>
 		<c:set var="emailValue" value="${cookieEmail }"/>
 		<c:set var="imgValue" value="${cookieImg }"/>
 	</c:if>
 	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link href="${pageContext.request.contextPath}/css/default.css" rel="stylesheet">

</head>
<body>



	<div class="container">
	<%@ include file="/include/header.jsp" %>

	<h1>이미 회원입니다</h1>
		
		
	</div>
<%@ include file="/include/footer.jsp" %>


</body>
</html>