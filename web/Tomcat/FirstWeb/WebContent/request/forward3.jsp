<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String name=(String)request.getAttribute("username");
	String pwd=(String)request.getAttribute("password");
	String job=(String)request.getAttribute("job");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>request 속성 공유 name:<%=name %></h1>


<table border="1">
<tr>
<td>이름</td>
<td><%=request.getParameter("username") %></td>
</tr>
<tr>
<td>비밀번호</td>
<td><%=request.getParameter("password") %></td>
</tr>
<tr>
<td>직업</td>
<td><%=request.getParameter("job") %></td>
</tr>
<tr>
<td>관심사항</td>
<td>
<% String[] likes=request.getParameterValues("like");
	for(int i=0;i<likes.length;i++){
		out.println(likes[i]+"<br>");
	}
%>
<%-- <%=request.getParameter("like") %> --%>
</td>
</tr>
</table>
</body>
</html>