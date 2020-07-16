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
<div class="container">
			<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<c:if test="${resultCode == 1}">
	
	<h1>메시지가 삭제되었습니다.</h1>
	
	</c:if>

	<c:if test="${resultCode == -1}">
	
	<h1>삭제할 메시지가 존재하지않습니다.</h1>
	
	</c:if>

	<c:if test="${resultCode == -2}">
	
	<h1>비밀번호가 일치하지않습니다.</h1>
	
	</c:if>
	
<form action="<%=request.getContextPath() %>/guest/list_view.jsp" method="post"> 
<!-- 	<a href="list_view.jsp">목록 보기</a>
 -->	<input type="submit" value="목록 보기">
	</form>
			<%@ include file="/WEB-INF/views/include/footer.jsp" %>
	</div>







</body>
</html>