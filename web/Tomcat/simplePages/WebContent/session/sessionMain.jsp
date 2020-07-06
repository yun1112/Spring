<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <script src="../js/sessionCheck.js"></script>
    <link rel="stylesheet" href="../css/popup.css">
<%
	Cookie[] cookies=request.getCookies();
if(cookies!=null){
	for(Cookie c:cookies){
		if(c.getName().equals("id")){
			session.setAttribute("id",c.getValue());
			
		}
	}
}
%>

<%
	String id=(String)session.getAttribute("id");
%>

<script>

function expireSession()
{
  window.location = "sessionLogin.jsp";
}
setTimeout('expireSession()', <%= request.getSession().getMaxInactiveInterval() * 1000 %>);
</script>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="CountInit()">
<span id="counter"></span>


<div id="popup" style="display:none"></div>
<div style="width:300px;height:170px" align="center"><br></div>
<span id="ncounter">후 자동로그아웃됩니다<br><br></span> 
<!-- <input type="button" value="연장하기" onclick="countReset(), closeWindow()"> -->
<!-- <body onload="expireSession()"> -->
<h1>마이페이지</h1>
<b><%=id %> 님이 로그인했습니다.</b>
<input type="button" value="로그아웃" onclick="location.href='sessionLogout.jsp'">
<input type="button" value="연장" onclick="CountReset()">
</body>
</html>