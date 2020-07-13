<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>boardView</title>
</head>
<body>

	<!-- 
	board_no int(10) not null auto_increment primary key,
board_pw varchar(50) not null,
board_title varchar(50) not null,

board_content text not null,

board_user varchar(50) not null,
board_date date -->

	<h1>BOARD VIEW</h1>

	<form method="post" action="ServletTest">
		<table>
			<tr>
				<td><label for="pw">password</label></td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td><label for="title">title</label></td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td><label for="content">content</label></td>
				<td><textarea name="content"></textarea></td>
			</tr>
			<tr>
				<td><label for="user">user</label></td>
				<td><input type="text" name="user"></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
				<td><input type="reset"></td>
			</tr>
		</table>

	</form>
</body>
</html>


