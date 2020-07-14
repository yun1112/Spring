<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<div id="navigation">
	<li><a href="${pageContext.request.contextPath}/member/memberRegForm.jsp">회원가입</a></li>
	<li><a href="${pageContext.request.contextPath}/member/loginForm.jsp">로그인</a></li>
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
	
	<li><a href="${pageContext.request.contextPath}/member/mypage.jsp">마이페이지</a></li>
	<li><a href="${pageContext.request.contextPath}guestbook/list.jsp">방명록(비회원)</a></li>
	<li><a href="${pageContext.request.contextPath}/board/list.jsp">방명록(회원제)</a></li>
</ul>
</div>