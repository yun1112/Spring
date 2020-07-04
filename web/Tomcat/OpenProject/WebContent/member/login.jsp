  
<%@page import="model.LoginInfo"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	// 사용자 요청 정보를 받는다.
	String uid = request.getParameter("uid");
	String pw = request.getParameter("pw");
	String chk = request.getParameter("remember"); 
	
	String rediectUri = request.getParameter("redirecUri");
	
	
	// 로그인 처리
	boolean loginChk = false;
	
/* 	if(uid.equals(pw)){
		LoginInfo loginInfo = 
				new LoginInfo(uid, pw, "test@gmail.com", "default.jpg");
		
		session.setAttribute("loginInfo", loginInfo);
		
		loginChk = true;
	} */
	
	Cookie[] cookies=request.getCookies();
	if(cookies!=null){
		for(Cookie c:cookies){
			%>
			<script>
			console.log("getName(): "+c.getName());
			</script>
			<%}
		}
	
	System.out.println(loginChk);
	
	if(loginChk){
		// 쿠키 설정에 사용한 변수
		String cookieName = "uid";
		String cookiePw = "pw";
		String cookiepath = request.getContextPath();
		
		// 회원 아이디 쿠키 설정 
		if(chk!=null){
			
			response.addCookie(CookieBox.createCookie(cookieName, uid, cookiepath, 60*60*24*365));
			response.addCookie(CookieBox.createCookie(cookiePw, pw, cookiepath, 60*60*24*365));
		
		
		} else {
			response.addCookie(CookieBox.createCookie(cookieName, uid, cookiepath, 0));
			response.addCookie(CookieBox.createCookie(cookiePw, pw, cookiepath, 0));
		}
		
		// 로그인 이 필요했던 이전 페이지
		%>
		<script>location.href="../afterLogin/mypage.jsp";</script>
		<%
			
	} else {
		%>
		<script>
		alert('아이디 또는 비밀번호를 확인후 다시 로그인해 주세요.') 
		history.go(-1);
		</script>
		<%
	}
	
%>