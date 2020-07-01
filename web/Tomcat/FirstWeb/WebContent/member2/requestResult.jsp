<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    request.setCharacterEncoding("utf-8");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 확인</title>
</head>
<body>
<table border="1">
<tr>
<td>아이디</td>
<td><%=request.getParameter("uid") %></td>
</tr>
<tr>
<td>비밀번호</td>
<td><%=request.getParameter("pw") %></td>
</tr>
<tr>
<td>이름</td>
<td><%=request.getParameter("uname") %></td>
</tr>
</table>
</body>
</html>

