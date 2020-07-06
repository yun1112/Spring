<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="memberInfo" class="model.LoginInfo" scope="application"/>
 <!--  
 id:identifier
 class:making an object, not making new object but bring the object has already been saved
 scope: page/request/session/application->속성을 사용할 수 있는 내장 객체, possible to be omnited
 
 -->   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><%=memberInfo %></h1>
</body>
</html>