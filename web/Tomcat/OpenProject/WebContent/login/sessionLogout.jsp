<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log Out</title>
</head>
<body>
<%
session.invalidate();

Cookie[] cookies=request.getCookies();
if(cookies!=null){
	for(Cookie c:cookies){
		if(c.getName().equals("id")){
			c.setMaxAge(0);
			c.setPath("/");
			response.addCookie(c);
		}
	}
}
%>
<script>
alert("you logged out successfully");
location.href='sessionLogin.jsp';</script>
</body>
</html>