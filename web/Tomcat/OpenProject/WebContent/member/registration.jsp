  
<%@page import="model.LoginInfo"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	// 사용자 요청 정보를 받는다.
	String uid = request.getParameter("uid");
	String pw = request.getParameter("pw");
	String email = request.getParameter("email");
	String img = request.getParameter("img");
	
	String rediectUri = request.getParameter("redirecUri");
	

	LoginInfo loginInfo=new LoginInfo(uid,pw,email,img);	
	session.setAttribute("loginInfo", loginInfo);
	%>
	
	<script>location.href="../afterLogin/mypage.jsp";</script>