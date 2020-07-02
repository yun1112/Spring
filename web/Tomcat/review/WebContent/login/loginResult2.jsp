<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8");
    	String id=(String)session.getAttribute("id");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>successfully log in2</h1>
<hr>
<h2>id: <%=id %></h2>
<a href="loginResult2.jsp">next</a>
</body>
</html>