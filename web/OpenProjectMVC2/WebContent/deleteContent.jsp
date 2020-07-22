<%@page import="login.LoginInfo"%>
<%@page import="board.model.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
     List<Board> listAll=(List)request.getAttribute("listAll");
    LoginInfo info=(LoginInfo)session.getAttribute("info");
   	Board board=(Board)request.getAttribute("board");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
삭제

</body>
</html>