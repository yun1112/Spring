<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<body>
<%
Cookie[] cookies=request.getCookies();
if(cookies!=null){
	for(Cookie c:cookies){
		if(c.getName().equals("id")){
			String ids=c.getValue();
			session.setAttribute("id",ids);
		}
	}
}
%>
<%
String id=(String)session.getAttribute("id");//casting Object to String
%>
<h1>Main Page</h1>
<%=id %> logged in successfully.
<input type="button" onclick="location.href='sessionLogout.jsp'" value="LogOut">
<input type="button" onclick="location.href='../mainPage.jsp'" value="go back to main page">
</body>
</html>