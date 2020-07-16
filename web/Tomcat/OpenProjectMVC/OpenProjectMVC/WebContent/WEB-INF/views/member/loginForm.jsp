<%@page import="guestbook.model.MemberMessageListView"%>
<%@page import="guestbook.service.GetMemberMessageListService"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
	<%

int pageNum = 1;   // list.jsp?page=9
String pageNumber = request.getParameter("page");
if(pageNumber != null) {
	pageNum = Integer.parseInt(pageNumber);
}

GetMemberMessageListService service = GetMemberMessageListService.getInstance();

// MessageListView
MemberMessageListView view = service.getMessageList(pageNum);

request.setAttribute("listView", view);

String uid=request.getParameter("uid");
String pw=request.getParameter("pw");

request.setAttribute("uid",uid);
request.setAttribute("pw",pw);


%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/default.css">

<style>
</style>
</head>
<body>


	<div class="container">
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
		<h1 class="subtitle">로그인</h1>
		
		<hr>
		
		<form action="memberLogin.do" method="post">
		
			
			<table class="table">
				<tr>
					<td>아이디</td>
					<td> <input type="text" name="uid" value="${uidValue}"> </td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td> <input type="password" name="pw" value="${pwValue}"> </td>
				</tr>				
				<tr>
					<td></td>
					<td> <input type="checkbox" name="remember" value="r" ${checked} > 아이디 기억하기  </td>
				</tr>
				<tr>
					<td colspan="2"> <input type="submit" value="로그인"> </td>
				</tr>
			</table>
		
		</form>
	
	
	
	<%-- ${listView} --%>
	
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
	
	<c:if test="${listView.pageTotalCount > 0}">
	
	<div class="paging">
	<c:forEach begin="1" end="${listView.pageTotalCount}" var="num">
	<c:if test="${uidValue==message.uid}">
	
<!-- 	<script>alert('zz');</script>
 -->	</c:if>
	<a href="memberPage2.jsp?page=${num}" ${listView.currentPageNumber eq num? 'class="currentPage"':''}>[ ${num} ]</a> 
	</c:forEach>
	</div>
	
	</c:if>	
	
	
</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>
