<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include TEST</title>
<style>
</style>
</head>
<body>

<%@ include file="include/header.jsp"%>
<%@ include file="include/div.jsp"%> 

<jsp:forward page="include/footer.jsp">
<jsp:param value="cool@gmail.com" name="email"/>
<jsp:param value="010-1111-1111" name="tell"/>
</jsp:forward>


<%-- 

<div id="wrap">
<%@ include file="include/news.jsp"%>
<%@ include file="include/news2.jsp"%> 
</div>
--%>

</body>
</html>
