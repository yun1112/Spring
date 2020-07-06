<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("utf-8");
    	String id=request.getParameter("id");
    	String pwd=request.getParameter("pwd");
    	
    	String dbId="kkk", dbPwd="1111";
    	
    	if(dbId.equals(id)){
    		if(dbPwd.equals(pwd)){
    		session.setAttribute("id",id);
    		session.setAttribute("pwd",pwd);
    %>
<script>alert("successfully autorized");</script>
	<%
    	}else{
    		%>
    		<script>alert("password was incorrectly entered");
    		location.href="sessionLogin.jsp"
    		</script>
    		<%
    	}
    	}else{
    		%>
    		<script>alert("id was incorrectly entered");
    		location.href="sessionLogin.jsp"</script>
    		<%
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>successfully log in</h1>
<hr>
<table><tr>
<td>id: </td><td><%=request.getParameter("id") %></td>
</tr><tr><td>password: </td><td><%=request.getParameter("pwd") %></td>
</tr><tr><td>name: </td><td><%=request.getParameter("name") %></td>
</tr></table>

<a href="loginResult2.jsp">next</a>
</body>
</html>