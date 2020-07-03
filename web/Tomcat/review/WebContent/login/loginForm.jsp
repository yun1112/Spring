<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%
    request.setCharacterEncoding("utf-8");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="loginResult.jsp" method="post">
<table>
<tr>
<td>id</td>
<td><input type="text" name="id"></td>
</tr>
<tr>
<td>password</td>
<td><input type="password" name="pwd"></td>
</tr>

<tr>
<td>name</td>
<td><input type="text" name="name"></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="log in">
<input type="reset" value="sign up"></td>
</tr>
</table>

</form>
</body>
</html>