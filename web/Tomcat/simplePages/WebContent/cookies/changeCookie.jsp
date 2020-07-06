<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Cookie[] cookies=request.getCookies();
if(cookies!=null){
	for(int i=0;i<cookies.length;i++){
		if(cookies[i].getName().equals("name")){
			Cookie cookie=new Cookie("name","value");
			response.addCookie(cookie);
		}
	}
}
%>
쿠키 목록<br> <%
Cookie[] cc = request.getCookies();
if (cc != null && cc.length > 0) {
for (int i = 0 ; i < cc.length ; i++) {
%>
<%= cc[i].getName() %> =
<%= cc[i].getValue() %><br> <% }
} else { %> 쿠키가 존재하지 않습니다.
<% } %>
</body>
</html>