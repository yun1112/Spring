<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="temporary.Info" %>
<%
request.setCharacterEncoding("utf-8");

String uid=request.getParameter("uid");
String pw=request.getParameter("pw");

Info info=new Info(uid,pw);//객체 생성

session.setAttribute("info",info);//세션 생성
/* session.setAttribute("uid",uid);//세션 생성
session.setAttribute("pw",pw); */


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 정보 확인</title>
</head>
<body>
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
</body>
</html>