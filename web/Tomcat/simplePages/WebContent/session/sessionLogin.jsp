<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Cookie[] cookies=request.getCookies();
if(cookies!=null){
	for(Cookie c:cookies){
		if(c.getName().equals("id")){
			response.sendRedirect("sessionMain.jsp");
		}
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인</h1>
<form action="sessionLoginPro.jsp" method="post">
아이디:<input type="text" name="id"><br>
비밀번호:<input type="password" name="pw"><br>
<input type="checkbox" name="loginChk" value="true">로그인 상태 유지<br>
<input type="submit" value="로그인">
</form>
</body>
</html>