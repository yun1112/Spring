<%@page import="member.model.MemberListView"%>
<%@page import="login.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link href="https://fonts.googleapis.com/css2?family=Gaegu&display=swap" rel="stylesheet">
<style>
*,h1,h3{
font-family: 'Gaegu', cursive;
}
</style>
    <%
 		String uid=(String)request.getParameter("uid");
 		String upw=(String)request.getParameter("upw");
 		
     	LoginInfo info=(LoginInfo)request.getAttribute("info");
    	Boolean loginCheck=(Boolean)request.getAttribute("loginCheck");
    	
    	
    %>
	<body>
	<hr>
	<c:if test="${not empty loginCheck}">
	<h3>반갑습니다 <b style="color:blue">${info.uid}</b> 회원님</h3>
	<%session.setAttribute("info",info); %>
<!-- 	<h1>로그인 완료</h1>
 -->	</c:if>
	<c:if test="${not loginCheck}">
	<h1>로그인 실패</h1>
	<script>
	alert('비밀번호를 다시 확인해주세요');
	location.href="<%=request.getContextPath()%>/login.jsp";
	</script>
	</c:if>
</body>