<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");

String id=request.getParameter("id");
String pw=request.getParameter("pw");
String loginChk=request.getParameter("loginChk");

String dbId="ppp123", dbPw="7777";

if(dbId.equals(id)){
	if(dbPw.equals(pw)){//both id and pw are correct
		session.setAttribute("id",id);
		session.setAttribute("pw",pw);
		
		//whether user logged in or not depends on null check
		if(loginChk!=null){
			Cookie c=new Cookie("id",id);
			c.setMaxAge(60*2);
			c.setPath("/");
			response.addCookie(c);//send the cookie you made to client
		}
		%>
		<script>alert("autorized")
		location.href="sessionMain.jsp"</script>
		<%
	}else{//id is correct but pw is wrong
		%>
		<script>alert("you entered wrong password. try again");
		location.href="sessionLogin.jsp"</script>
		<%
	}
}else{
	%>
	<script>alert("you entered wrong id.try again");
	location.href="sessionLogin.jsp"</script>
	<%
}
%>
</body>
</html>