<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="temporary.Info" %>
<%
Info info=(Info)session.getAttribute("info");
String uid=info.getUid();
String pw=info.getPw();

%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 정보</h1>
<table>
			<tr>
				<th>아이디</th>
				<td><%=info.getUid() %></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><%=info.getPw() %></td>
			</tr>
			
			<tr>
			<td colspan="2"><a href="loginPage.jsp">로그인페이지</a></td>
			</tr>
		</table>
		<hr>
	<form action="loginPro.jsp" method="post">
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
			<td colspan="2"><input type="submit" value="로그인"><input type="reset" value="초기화"><a href="registrationPage.jsp">회원가입페이지</a></td>
			</tr>
			<tr>
			<td><input type="button" value="체크" onclick="checkInfo()"></td>
			</tr>
		</table>

	</form>
</body>
</html>