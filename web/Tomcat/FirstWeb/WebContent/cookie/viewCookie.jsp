<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="util.CookieBox" %>
    <%-- <%
    Cookie [] cookies=request.getCookies();
    %> --%>
    <%
    CookieBox cookieBox=new CookieBox(request);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 확인</title>
</head>
<body>
<h1>쿠키 정보(회원 정보)</h1>

<div>
uid=<%=cookieBox.getCookie("uid").getValue()%>
pw=<%=cookieBox.getCookie("pw").getValue() %>
uname=<%=cookieBox.getCookie("uname").getValue()%>

</div>



<a href="editCookie.jsp">쿠키값 수정하기</a>
<a href="deleteCookie.jsp">쿠키값 삭제하기</a>
<a href="../member2/div/loginMain.jsp">로그인 페이지로 돌아가기</a>
<a href="showAllCookies.jsp">모든 쿠키값 확인</a>
</body>
</html>