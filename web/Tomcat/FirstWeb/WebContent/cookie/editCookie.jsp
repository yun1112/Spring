<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="util.CookieBox" %>
    <%
/*     Cookie [] cookies=request.getCookies(); */
    CookieBox cookieBox=new CookieBox(request);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 확인</title>
</head>
<body>
<h1>쿠키 정보 수정</h1>
<%
/* 	Cookie cookie=new Cookie("uid","hot");
cookie.setPath("/web/"); */
/*  request.getContextPath()*/
response.addCookie(CookieBox.createCookie("uid","HOT"));
%>



<a href="viewCookie.jsp">쿠키값 확인하기</a>
</body>
</html>