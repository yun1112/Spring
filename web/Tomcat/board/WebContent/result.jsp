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
	<!-- 
	board_no int(10) not null auto_increment primary key,
board_pw varchar(50) not null,
board_title varchar(50) not null,

board_content text not null,

board_user varchar(50) not null,
board_date date -->


<!-- 	private String boardPw;
	private String boardTitle;
	private String boardContent;
	private String boardUser; -->
	
<h1>result</h1>
<hr>

<h3>board list</h3>${boardList }
<hr>

<c:forEach var="list" items="${boardList }" varStatus="status">
	<p><h2>${status.count }</h2><br>
	<p><h3>password: </h3><c:out value="${list.boardPw }"/></p>
	<p><h3>title: </h3><c:out value="${list.boardTitle }"/></p>
	<p><h3>content: </h3><c:out value="${list.boardContent }"/></p>
	<p><h3>user: </h3><c:out value="${list.boardUser }"/></p>
</c:forEach>
</body>
</html>