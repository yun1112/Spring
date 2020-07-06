<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->

    <!-- 부트스트랩 -->
<!--     <link href="../css/bootstrap.min.css" rel="stylesheet">
 -->    <link href="<%=request.getContextPath() %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- <nav class="navbar navbar-dark bg-dark">
 -->
 
 </head>
 <body>
 
<nav class="navbar navbar-inverse">
 <div class="container-fluid">
 <div class="navbar-header"><a class="navbar-brand" href="#">Open Project</a></div>
 <div class="container">
 <ul class="nav navbar-nav">
 	<li class="nav-item"><a class="nav-link active" href="<%=request.getContextPath() %>/member/memberRegForm.jsp">회원가입</a></li>
	<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath() %>/member/loginForm.jsp">로그인</a></li>
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
	
	<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath() %>/member/mypage.jsp">마이페이지</a></li>
	<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath() %>/guestbook/list.jsp">방명록(비회원)</a></li>
	<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath() %>/board/list.jsp">방명록(회원제)</a></li>
</ul>



</div>
</nav>


    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="../js/bootstrap.min.js"></script>
  </body>
</html>