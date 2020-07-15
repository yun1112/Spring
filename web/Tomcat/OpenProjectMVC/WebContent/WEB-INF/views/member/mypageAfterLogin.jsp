<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<%@ include file="/include/sessionCheck.jsp" %>

	
<%-- ${sessionScope.loginInfo} --%>
<c:if test="${!empty loginInfo}">

	
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/default.css">

<style>
</style>
</head>
<body>

<%@include file="/include/header.jsp"%>
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
				<td><%= loginInfo.getPw() %></td>				
			</tr>
			<tr>
				<td>이메일</td>
				<td><%= loginInfo.getEmail() %></td>				
			</tr>
			<tr>
				<td>사진</td>
			<td><img id="img" style="width:50px" src="<%=request.getContextPath()%>/images/<%= loginInfo.getPhoto() %>"></td>
			<td><%@ include file="../uploadtest/example.jsp" %></td>
			</tr>
		</table>
		
	</div>

	<%@ include file="/include/footer.jsp" %>
</body>
</html>


</c:if>
	

