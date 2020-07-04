<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 	<% 
	Cookie[] cookies=request.getCookies();
	if(cookies!=null){
		for(Cookie c:cookies){
			if(c.getName().equals("id")){
				String uName=c.getValue();
			}
		}
	}
	%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INDEX</title>
<link href="<%=request.getContextPath() %>/css/default.css" rel="stylesheet">
</head>
<body>
	<%@include file="/include/header.jsp" %>
		<div id="div1">
		<h1>로그아웃 하셨습니다</h1>
		</div>
	
	<%@include file="/include/footer.jsp" %>
</body>
</html>