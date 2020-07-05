<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/include/sessionCheck.jsp" %>
<%
	session.getAttribute("loginInfo");

	if(loginInfo!=null){%>
	
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/default.css">

<style>
</style>
</head>
<body>

	<%@ include file="/afterLogin/include/header.jsp" %>

	<div class="container">
		<h1 class="subtitle">마이페이지</h1>
		
		<hr>
		
		<h3>로그인 회원 정보 </h3>
		
		<table class="table">
			<tr>
				<td>아이디</td>
				<td><%= loginInfo.getUid() %></td>				
			</tr>
			<tr>
				<td>이름</td>
				<td><%= loginInfo.getUname() %></td>				
			</tr>
			<tr>
				<td>비밀번호</td>
				<td></td>				
			</tr>
			<tr>
				<td>이메일</td>
				<td><%= loginInfo.getEmail() %></td>				
			</tr>
			<tr>
				<td>사진</td>
			<%--  <td><img src=<%=request.getContextPath()%>/images/<%= loginInfo.getPhoto() %>"></td> --%>
			<td><%@ include file="../uploadtest/example.jsp" %></td>
			</tr>
		</table>
		
	</div>

	<%@ include file="/include/footer.jsp" %>
</body>
</html>
<%} %>




