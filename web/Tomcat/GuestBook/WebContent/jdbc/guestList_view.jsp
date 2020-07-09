<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- ${empList} --%>
	
	<h1>게스트 리스트</h1>
	<hr>
	
	<table border=1>
	
		<tr>
			<th>메시지 아이디</th>
			<th>게스트 이름</th>
			<th>비밀번호</th>
			<th>메시지</th>
		</tr>
		
		<c:if test="${ empty guestList}">
		<tr>
			<td colspan="4">데이터가 존재하지 않습니다.</td>
		</tr>
		</c:if>
		
		
		<c:if test="${ not empty guestList}">
		<c:forEach items="${guestList}" var="guest">
		<tr>
			<td>${guest.mesaage_id}</td>
			<td>${guest.guest_name}</td>
			<td>${guest.password}</td>
			<td>${guest.message}</td>
		</tr>		
		</c:forEach>
		</c:if>
	
	
	</table>
	












</body>
</html>