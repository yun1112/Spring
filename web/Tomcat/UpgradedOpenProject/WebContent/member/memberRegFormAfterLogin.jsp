<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<%
	CookieBox cookieBox = new CookieBox(request);
	
	String cookieUid = cookieBox.getValue("uid");
	String cookiePw = cookieBox.getValue("pw");
	String cookieUname = cookieBox.getValue("uname");

	String cookieEmail = cookieBox.getValue("email");
	String cookieImg = cookieBox.getValue("img");

	String uidValue = "";
	String pwValue = "";
	String unameValue = "";
	String emailValue = "";
	String imgValue = "";
	
	if((cookieUid!=null)&&(cookiePw!=null)&&(cookieUname!=null)&&(cookieEmail!=null)&&(cookieImg!=null)){
		uidValue = cookieUid;
		pwValue=cookiePw;
		unameValue=cookieUname;
		emailValue=cookieEmail;
		imgValue=cookieImg;
	}
	
 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link href="${pageContext.request.contextPath}/css/default.css" rel="stylesheet">

</head>
<body>



	<%@ include file="/include/header.jsp" %>

	<div class="container">
	<h1>이미 회원입니다</h1>
		
		
	</div>
<%@ include file="/include/footer.jsp" %>


</body>
</html>