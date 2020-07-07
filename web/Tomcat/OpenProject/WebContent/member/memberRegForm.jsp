<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<%-- 쿠기 값은  ${cookie.myCookie.value }
세션 값${mySession}
<%=request.getRemoteAddr() %>
ip: ${pageContext.request.remoteAddr}
 --%>

<%-- /* 	<c:if test=“조건식” var=“조건을 검사하고 return되는 bool값을 저장할 변수” scope=“bool변수가 사용될 범위”/> */ --%>


<%
	CookieBox cookieBox = new CookieBox(request);

%>
 	
 	<c:set var="cookieBox" value="${cookie.cookieBox}"/>
 	<c:set var="cookiePw" value="${cookie.cookieBox.pw}"/>
 	<c:set var="cookieUname" value="${cookie.cookieBox.uname}"/>
 	<c:set var="cookieEmail" value="${cookie.cookieBox.email}"/>
 	<c:set var="cookieImg" value="${cookie.cookieBox.img}"/>
 	
 	<c:set var="uidValue=" value=""/>
 	<c:set var="pwValue=" value=""/>
 	<c:set var="unameValue=" value=""/>
 	<c:set var="emailValue=" value=""/>
 	<c:set var="imgValue=" value=""/>
 	
 	<c:if test="${!empty cookieUid} && ${!empty cookiePw} && ${!empty cookieUname} && ${!empty cookieEmail} && ${!empty cookieImg}">
 		<c:set var="uidValue" value="${cookieUid }"/>
 		<c:set var="pwValue" value="${cookiePw }"/>
 		<c:set var="unameValue" value="${cookieUname }"/>
 		<c:set var="emailValue" value="${cookieEmail }"/>
 		<c:set var="imgValue" value="${cookieImg }"/>
 	</c:if>
 	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link href="${pageContext.request.contextPath}/css/default.css" rel="stylesheet">

</head>
<body>


 <c:import url="/include/header.jsp" />
 
	<div class="container">
		<h1 class="subtitle">회원가입</h1>
		
		<hr>
		
		<form action="registration.jsp" method="post">
		
			<table class="table">
				<tr>
					<td>아이디</td>
 					<td> <input type="text" name="uid" value="${cookie.cookieBox.uid }"> </td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td> <input type="password" name="pw" value="${cookie.cookieBox.pw }"> </td>
				</tr>
								<tr>
					<td>이름</td>
					<td> <input type="text" name="uname" value="${cookie.cookieBox.uname }"> </td>
				</tr>			
				<tr>
					<td>이메일</td>
				<td> <input type="text" name="email" value="${cookie.cookieBox.email }"> </td>
				</tr>
				<tr>
					<td>사진</td>
					<td> <input type="file" name="img" value="${cookie.cookieBox.img }"> </td>
				</tr>				
				<tr>
					<td colspan="2"> <input type="submit" value="회원가입"> <input type="reset" value="초기화"></td>
				</tr>
			</table>
		
		</form>
		
		
	</div>
<c:import url="/include/footer.jsp" />


</body>
</html>