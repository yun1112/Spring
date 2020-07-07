<%@page import="model.LoginInfo"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	// 사용자 요청 정보를 받는다.
	String uid = request.getParameter("uid");
	String pw = request.getParameter("pw");
	String uname = request.getParameter("uname");
	String email = request.getParameter("email");
	String img = request.getParameter("img");
	
	String rediectUri = request.getParameter("redirecUri");
	

	LoginInfo loginInfo=new LoginInfo(uid,pw,uname,email,img);
	session.setAttribute("loginInfo", loginInfo);
	%>
	
	<script>location.href="../member/loginForm.jsp";</script>
	
<%-- 	<%@page import="model.LoginInfo"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
	
<%
	// 사용자 요청 정보를 받는다.
	/* String uid = request.getParameter("uid"); */
	String uid = request.getParameter("uid");
	String pw = request.getParameter("pw");
	String uname = request.getParameter("uname");
	String email = request.getParameter("email");
	String img = request.getParameter("img");
	
	

	LoginInfo loginInfo=new LoginInfo(uid,pw,uname,email,img);
	session.setAttribute("loginInfo", loginInfo);
	
	

	%>
	
	
	
	<c:set var="uid" value="${param.uid}"/>
	<c:set var="pw" value="${param.pw}"/>
	<c:set var="uname" value="${param.uname}"/>
	<c:set var="email" value="${param.eamil}"/>
	<c:set var="img" value="${param.img}"/>
	${uid }
	<c:set var="loginInfo" value="<%=new jstl.LoginInfo()%>"/>
	<c:set target="${loginInfo }" property="uid" value="${uid}"/>
	<c:set target="${loginInfo }" property="pw" value="${pw}"/>
	<c:set target="${loginInfo }" property="uname" value="${uname}"/>
	<c:set target="${loginInfo }" property="email" value="${email}"/>
	<c:set target="${loginInfo }" property="img" value="${img}"/>
	<c:set target="${memberInfo}" property="id" value="dog"/>
	
<%
	LoginInfo loginInfo=new LoginInfo(uid,pw,uname,email,img);
	%>
	<c:set var="loginInfo" value="${sessionScope.loginInfo};/>
	
	<script>location.href="../member/loginForm.jsp";</script>
	
	
	 --%>