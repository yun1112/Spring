<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 	<% 
	Cookie[] cookies=request.getCookies();
	if(cookies!=null){
		for(Cookie c:cookies){
			if(c.getName().equals("id")){
				String uName=c.getValue();
			}
		}
	}
	%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
<link href="<%=request.getContextPath() %>/css/default.css" rel="stylesheet">
</head>
<body>
	<%@include file="/include/header.jsp" %>
		<div id="div1">
		<h1>로그아웃 하셨습니다</h1>
		</div>
	<script>
	var count=3;
	var repeat=setInterval(function(){
		document.getElementById('div1').innerHTML=('<h1>'+count+'초 후 로그인페이지로 돌아갑니다</h1>');
		count--;
		if(count==0){
			clearInterval(repeat);
			location.href="<%=request.getContextPath()%>/member/loginForm.jsp";	
		}
	},1000);
	</script>
	<%@include file="/include/footer.jsp" %>
</body>
</html>