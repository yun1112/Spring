<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<%
	CookieBox cookieBox = new CookieBox(request);%>
	
	
	
	<!-- String cookieUid = cookieBox.getValue("uid");
	
	String cookiePw = cookieBox.getValue("pw");
	
	String uidValue = "";
	String pwValue = "";
	String checked = "";
	
	if((cookieUid!=null)&&(cookiePw!=null)){
		uidValue = cookieUid;
		pwValue=cookiePw;
		checked = "checked";
	} -->
	
 
<c:set var="cookieBox" value="${cookie.CookieBox }"/>
<c:set var="cookiePw" value=""/>
<c:set var="uidValue" value=""/>
<c:set var="pwValue" value=""/>
<c:set var="checked" value=""/>

<c:if test="${!empty cookieUid} && ${!empty cookie}">
	<c:set var="uidValue" value="cookieUid"/>
	<c:set var="pwValue" value="cookiePw"/>
	<c:set var="checked" value="checked"/>
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/default.css">

<style>
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/include/header.jsp" %>

	<div class="container">
		<h1 class="subtitle">로그인</h1>
		
		<hr>
		
		<form action="memberLogin.do" method="post">
		
			<%-- <input type="text" name="redirecUri" 
			
			value="<%= request.getHeader("referer")%>" style=" width : 50% ;" >			 --%>
			
			
			<table class="table">
				<tr>
					<td>아이디</td>
					<td> <input type="text" name="uid" value="${uidValue}"> </td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td> <input type="password" name="pw" value="${pwValue}"> </td>
				</tr>				
				<tr>
					<td></td>
					<td> <input type="checkbox" name="remember" value="r" ${checked} > 아이디 기억하기  </td>
				</tr>
				<tr>
					<td colspan="2"> <input type="submit" value="로그인"> </td>
				</tr>
			</table>
		
		</form>
		
		
	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>
