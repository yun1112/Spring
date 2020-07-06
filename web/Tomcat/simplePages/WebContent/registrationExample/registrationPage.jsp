<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="temporary.Info" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입</h1><hr>
	<form action="registrationPro.jsp" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="uid" required></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" required></td>
			</tr>
			
			<tr>
			<td colspan="2"><input type="submit" value="가입"><input type="reset" value="초기화"></td>
			</tr>
		</table>

	</form>
</body>
</html>