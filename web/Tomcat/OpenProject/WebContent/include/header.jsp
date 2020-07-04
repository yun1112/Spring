<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%
String referer = (String)request.getHeader("REFERER");
if(referer.equals("http://localhost:8081/op/afterLogin/mypage.jsp")){
	%><script>alert("로그인");</script><%
}
%> --%>
<%-- <h1><%=referer %></h1><hr> --%>
<h1 id="header">Open Project</h1>
<%-- <%
	boolean loginOrNot=false;
	if(referer.equals("http://localhost:8081/op/mypage/mypage.jsp")){
		loginOrNot=true;
		%>
		<script>
			alert("로그인 상태");
			<% loginOrNot=true;%>
		</script>
		<%
	}
%> --%>
<ul id="navigation">
	<li><a href="<%=request.getContextPath() %>/member/memberRegForm.jsp">회원가입</a></li>
	<li><a href="<%=request.getContextPath() %>/member/loginForm.jsp">로그인</a></li>
<%-- 	<%
	if(loginOrNot){
		%>
		<li><a href="<%=request.getContextPath() %>/member/loginForm.jsp">로그인</a></li>
		<%
	}else{
		%>
		<li><a href="<%=request.getContextPath() %>/member/logout.jsp">로그아웃</a></li>
		<%
	}
	%> --%>
	
	<li><a href="<%=request.getContextPath() %>/member/mypage.jsp">마이페이지</a></li>
	<li><a href="<%=request.getContextPath() %>/guestbook/list.jsp">방명록(비회원)</a></li>
	<li><a href="<%=request.getContextPath() %>/board/list.jsp">방명록(회원제)</a></li>
</ul>