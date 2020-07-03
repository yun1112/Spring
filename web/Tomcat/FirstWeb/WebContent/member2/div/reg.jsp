<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="util.CookieBox" %>
    <%request.setCharacterEncoding("utf-8");%>
<%-- <%@ page import="java.sql.*" %> --%>
<%-- 
    <%
    /* Cookie c=new Cookie("uid","COOL");
    c.setMaxAge(60);
    response.addCookie(c);
    Cookie c2=new Cookie("uname","yu");
    response.addCookie(c2); */
    
    
    /* response.addCookie(CookieBox.createCookie("uid","Cool","/",60));
    response.addCookie(CookieBox.createCookie("uid","Cool","/",60)); */
  /*   response.addCookie(CookieBox.createCookie("uid","Cool"));
    response.addCookie(CookieBox.createCookie("uname","cookie")); */
    %> --%>
    
    	<%
	String uid=request.getParameter("uid");
	String pw=request.getParameter("pw");
	String uname=request.getParameter("uname");
	
/* 	 response.addCookie(CookieBox.createCookie("uid","YUN1112"));
	    response.addCookie(CookieBox.createCookie("pw","1111"));
	    response.addCookie(CookieBox.createCookie("uname","YUN")); */
    response.addCookie(CookieBox.createCookie("uid",uid));
    response.addCookie(CookieBox.createCookie("pw",pw));
    response.addCookie(CookieBox.createCookie("uname",uname));
	%>
	<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>

<link href="../css/membermgr2.css" rel="stylesheet">
<!-- <script src="js/membermgr.js"></script> -->
</head>

<body>
<%@ include file="div/header.jsp"%>
<div id="reg">

	<h2 class="title">회원가입</h2>
	<!-- <form action="../requestResult.jsp" method="post" id="regForm"> -->
	<form action="../../cookie/makeCookie.jsp" method="post">
		<table>
			<tr>
				<td><label>아이디</label> <input type="text" name="uid"
					placeholder="아이디" id="uid" required></td></tr><tr>
				<td><label>비밀번호</label> <input type="password" id="pw" name="pw"
					placeholder="비밀번호" required></td></tr><tr>
				<td><label>이름</label> <input type="text" id="uname" name="uname"
					placeholder="이름" required></td></tr>
					<tr>
				<td style="float:left;"><input type="submit" value="저장"></td>
			</tr>
		</table>

	</form>
</div>

</body>
</html>
