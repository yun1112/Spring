
<%@page import="model.Guest"%>
<%@page import="service.GuestListService"%>
<%@page import="dao.GuestbookDao"%>
<%@page import="jdbc.ConnectionProvider"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Guest"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GUEST LIST</title>
<style>
table {
	width: 80%;
}
table td {
	padding: 10px;
	text-align: center;
}
</style>
</head>
<body>

	<%
	
	List<Guest> guestList = GuestListService.getInstance().getGuestbookList();
	request.setAttribute("guestList", guestList);
	%>

	<jsp:forward page="guestList_view.jsp" />







</body>
</html>