<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
   /* 	Cookie cookie=new Cookie("uname","");
    cookie.setMaxAge(0);
    response.addCookie(cookie); */
    response.addCookie(CookieBox.createCookie("uname",""));
    %>
    <%@page import="util.CookieBox" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 확인</title>
</head>
<body>
<h1>쿠키를 삭제합니다</h1>


<a href="viewCookie.jsp">쿠키 삭제하기</a>
</body>
</html>