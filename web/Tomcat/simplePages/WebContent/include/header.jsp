<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Boolean loginCheck=session.getAttribute("loginInfo")==null?false:true;
%>

<h1 id="header">Open Project</h1>
<ul id="nav">
<li><a href="<%= request.getContextPath() %>/member/memberRegForm.jsp">회원가입</a></li>
<%
	if(loginCheck){
		%>
		<li><a href="<%= request.getContextPath() %>/member/logout.jsp">로그아웃</a>
		<%}
	else{%>
	<li><a href="<%=request.getContextPath() %>/member/loginForm.jsp">로그인</a>
	<%
	}
%>
</ul>