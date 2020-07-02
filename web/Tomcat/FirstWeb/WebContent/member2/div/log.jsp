<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="util.CookieBox" %>
        	<%
	String uid=request.getParameter("uid");
	String pw=request.getParameter("pw");
	String uname=request.getParameter("uname");
	
/* 	 response.addCookie(CookieBox.createCookie("uid","YUN1112"));
	    response.addCookie(CookieBox.createCookie("pw","1111"));
	    response.addCookie(CookieBox.createCookie("uname","YUN")); */
    response.addCookie(CookieBox.createCookie("uid",uid));
    response.addCookie(CookieBox.createCookie("pw",pw));
    response.addCookie(CookieBox.createCookie("uname",uname));
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그</h1>

<script src="logincheck.js"></script>
</body>
</html>