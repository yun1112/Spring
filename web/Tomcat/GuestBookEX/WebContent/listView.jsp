<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="#">
<table>
<tr>
<td><label for="name">이름</lable></td>
<td><input type="text" name="name" required></td>
</tr>
<tr>
<td><label for="pw">암호</label></td>
<td><input type="password" name="pw" required></td>
</tr>
<tr>
<td><label for="message">메시지</label></td>
<td><textarea name="message" rows="10" cols="20" required></textarea></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="메시지 남기기"></td>
</tr>
</table>
</form>

<hr>



</body>
</html>