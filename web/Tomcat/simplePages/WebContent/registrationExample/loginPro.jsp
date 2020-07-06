<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="temporary.Info" %>    
<%
Info info=(Info)session.getAttribute("info");
String uid=info.getUid();
String pw=info.getPw();


String inputUid=(String)request.getParameter("uid");
String inputPw=(String)request.getParameter("pw");


if(uid.equals(inputUid)){
	%><script>alert("id일치");</script><%
	if(pw.equals(inputPw)){
		%>
		<script>alert("id&pw일치");</script><h1>정상적으로 로그인되었습니다</h1>
		<%
	}
}else{
	%>
	<h1>로그인 실패</h1>
	<%
}
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="registrationPage.jsp">회원가입페이지</a>
</body>
</html>