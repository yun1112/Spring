<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String username=(String)request.getAttribute("username");
/* request.setAttribute("username","Scott");  */
%>

<jsp:forward page="forward.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>setAttribute.jsp</h1>
<h2>전달된 user name: <%=request.getParameter("username") %></h2>
name:<%=request.getParameter("username") %>
</body>
</html>