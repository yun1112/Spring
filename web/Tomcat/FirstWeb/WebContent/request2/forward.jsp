<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String username=(String)request.getAttribute("username");


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>forward.jsp</h1><hr>
<h1>request 속성 공유 name:<%=request.getParameter("username") %></h1>
name:<%=request.getParameter("username") %>
</body>
</html>