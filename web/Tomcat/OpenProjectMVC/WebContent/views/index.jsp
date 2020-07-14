<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/css/default.css" rel="stylesheet">
<%-- <link href="${pageContext.request.contextPath}/css/default.css" rel="stylesheet"> --%>

</head>
<body>


	<%@include file="/include/header.jsp"%>
<%-- 	<%@include file="/WEB-INF/views/include/header.jsp"%> --%>
	<div class="container">
		<h1>마이페이지</h1>
	</div>
	<%-- <img src="/WEB-INF/views/stitch.jpg"/>
	<img src="file:///Users/won-yungyeong/git-workshop/web/Tomcat/OpenProjectMVC/WebContent/WEB-INF/views/stitch.jpg"/>
	<img src="stitch.jpeg"/>
	<img src="<c:url value='/views/flowers.png' />" />
	<img src="<c:url value='/WEB-INF/views/flowers.png' />" />
	<img src="<c:url value='/WebContent/WEB-INF/views/flowers.png' />" />
	<img src="<c:url value='/flowers.png' />" /> --%>
	<%@include file="/include/footer.jsp"%>
</body>
</html>