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
<h1>전송 결과</h1>
<hr>
<table border="1">
<tr>
<td>이름</td>
<td><%=request.getParameter("username") %></td>
</tr>

<tr>
<td>직업</td>
<td><%=request.getParameter("job") %>
</td></tr>

<tr>
<td>관심사항</td>
<td>
<%
	String [] likes=request.getParameterValues("like");
for(int i=0;i<likes.length;i++){
	out.println(likes[i]+"<br>");
}
%>

</td>
</tr>

<tr>
<td>클라이언트 IP주소</td><td><%=request.getRemoteAddr() %></td>
</tr>

<tr>
<td>요청 메서드</td><td><%=request.getMethod() %>
</td>
<tr>
<td>쿠키</td>
<td><%Cookie cookie[]=request.getCookies(); %>
<%=cookie[0].getName() %>
</td>
</tr>
</tr><td>프로토콜</td>
<td>
<%=request.getProtocol() %>
</td>
</tr>
</table>