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
		<h1 class="subtitle">회원가입</h1>
		
		<hr>
		
		<form action="registration.jsp" method="post">
		
<%-- 			<input type="text" name="redirecUri" 
			
			value="<%= request.getHeader("referer")%>" style=" width : 50% ;" >	 --%>		
			
			<!--	public LoginInfo(String uid, String uname, String email, String photo) {  -->
			<table class="table">
				<tr>
					<td>아이디</td>
					<td> <input type="text" name="uid" value="<%= uidValue%>"> </td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td> <input type="password" name="pw" value="<%= pwValue%>"> </td>
				</tr>
								<tr>
					<td>이름</td>
					<td> <input type="text" name="uname" value="<%= unameValue%>"> </td>
				</tr>			
				<tr>
					<td>이메일</td>
					<td> <input type="text" name="email" value="<%= emailValue%>"> </td>
				</tr>
				<tr>
					<td>사진</td>
					<td> <input type="file" name="img" value="<%= imgValue%>"> </td>
				</tr>				
				<tr>
					<td colspan="2"> <input type="submit" value="회원가입"> <input type="reset" value="초기화"></td>
				</tr>
			</table>
		
		</form>
		
		
	</div>
<%@ include file="/include/footer.jsp" %>


</body>
</html>