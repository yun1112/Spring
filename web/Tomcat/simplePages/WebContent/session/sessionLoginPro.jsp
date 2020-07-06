<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id=request.getParameter("id");
	String pw=request.getParameter("pw");
	String loginChk=request.getParameter("loginChk");
	
	String uId="www";
	String uPw="aaa";
	
	if(id.equals(uId)){
		if(pw.equals(uPw)){
			session.setAttribute("id",id);
			
			if(loginChk!=null){
				Cookie cookie=new Cookie("id",id);
				cookie.setMaxAge(10);
				cookie.setPath("/");
				response.addCookie(cookie);
			}%>
			<script>
			alert("로그인 되었습니다.\n메인 페이지로 이동합니다");
			location.href="sessionMain.jsp";
			</script>
			<%
		}
		else{
			out.println("비밀번호가 틀렸습니다<br>");
		}
	}else{
		%>
		아이디 없음<br>
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

</body>
</html>