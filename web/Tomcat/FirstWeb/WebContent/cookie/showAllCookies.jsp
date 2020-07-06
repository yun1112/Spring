<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="util.CookieBox" %>
    <%-- <%
    Cookie [] cookies=request.getCookies();
    %> --%>
    <%
    CookieBox cookieBox=new CookieBox(request);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>모든 회원정보 쿠키값</h1>
<%
/* for(int i=0;i<cookieBox.length;i++){
	cookieBox[i].getValue("id");
} */
	 %>
</body>
</html>