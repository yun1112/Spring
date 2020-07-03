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
<h1>쿠키 생성</h1>
<br>
<h1>uid: <%=request.getParameter("uid") %></h1>
<h1>pw: <%=request.getParameter("pw") %></h1>
<h1>uname: <%=request.getParameter("uname") %></h1>
<a href="viewCookie.jsp">쿠키 확인</a>
</body>
</html>