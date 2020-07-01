<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
    request.setCharacterEncoding("utf-8");
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자의 요청정보 출력</title>
</head>
<body>

<h1>로그인 완료</h1>

<hr>
<table border="1">
<tr>
<td>아이디(이메일)</td>
<td><%=request.getParameter("id") %></td>
</tr>
<tr>
<td>비밀번호</td>
<td><%=request.getParameter("pwd") %></td>
</tr>
<tr>
<td>이름</td>
<td><%=request.getParameter("name") %></td>
</tr>

</table>

<script>
var i=3;
setInterval(function(){
	out.println(i--);
	if(i<1){
		//종료 후 로그인 화면으
	}
},3000);
</script>
</body>
</html>