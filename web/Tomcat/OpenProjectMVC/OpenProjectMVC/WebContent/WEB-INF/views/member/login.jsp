<%@page import="guestbook.service.GetMemberMessageListService"%>
<%@page import="guestbook.model.MemberMessageListView"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	String uid=(String)request.getAttribute("uid");
	String pw=(String)request.getAttribute("pw");
	
/* 	MemberMessageListView view=(MemberMessageListView)request.getAttribute("listView");
 */	
 
 int pageNum = 1;   // list.jsp?page=9
 String pageNumber = request.getParameter("page");
 if(pageNumber != null) {
 	pageNum = Integer.parseInt(pageNumber);
 }
	GetMemberMessageListService service = GetMemberMessageListService.getInstance();

	// MessageListView
	MemberMessageListView view = service.getMessageList(pageNum);
%>
	
	<h1>로그인 결과</h1>
	${uidValue==message.uid}<hr>
	${uidValue}<hr>
	${message.uid}<hr>
	${uid}<hr>
	${pw}<hr>
	
	<c:if test="${not empty listView.messageList}">
	<c:forEach items="${listView.messageList}" var="message">
	
	<div class="msg_box">
		회원 등록 번호 : ${message.idx} <br>
		아이디 : ${message.uid} <br>
		비밀번호 : ${message.upw} <br>
		이름 : ${message.uname} <br>
		사진(임시, 경로) : ${message.uphoto}<br>
<%-- 		<a href="deleteMessageConfirm.jsp?mid=${message.mid}">삭제</a>
 --%>	</div>	
	
	</c:forEach>
	
	</c:if>
	
	<hr>
		<c:if test="${uidValue==message.uid}">
		
<!-- 	<script>alert('zz');</script>
 -->	</c:if>
	
		<c:if test="!${uidValue==message.uid}">
	
<!-- 	<script>alert('no');</script>
 -->	</c:if>