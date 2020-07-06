<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.MemberInfo" %>
    <%
   //String mId=(String)session.getAttribute("memberId");
    MemberInfo memberinfo=(MemberInfo)session.getAttribute("memberInfo");
   /*  if(memberinfo.getUid()==null){ */
	   if(memberinfo==null){
    	//response.sendRedirect("sessionLoginForm.jsp");
    	%>
    	<script>
    	alert("사용자 전용 페이지입니다.\n로그인 해주세요");
    	location.href="sessionLoginForm.jsp";
    	</script>
    	<%
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 페이지</title>
</head>
<body>
<h1>로그인을 한 사용자를 위한 페이지입니다</h1>
<h3>로그인 아이디<%=memberinfo.getUid() %></h3>

<a href="logout.jsp">logout</a>
</body>
</html>