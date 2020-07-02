<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String userName=(String)session.getAttribute("username");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>username:<%=userName %></h1>
<a heref="../index.jsp">another page</a>
<a href="logout.jsp">log out</a>
</body>
</html>