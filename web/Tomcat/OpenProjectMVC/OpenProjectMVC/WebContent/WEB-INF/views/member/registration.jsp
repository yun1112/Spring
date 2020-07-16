<%@page import="model.LoginInfo"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<c:set var="uid" value="${param.uid}"/>
<c:set var="pw" value="${param.pw}"/>
<c:set var="uname" value="${param.uname}"/>
<c:set var="email" value="${param.email}"/>
<c:set var="img" value="${param.img}"/>

<c:set var="loginInfo" value="new Logininfo(${uid},${pw},${uname},${email},${img})"/>


<script>location.href="../member/loginForm.jsp";</script>