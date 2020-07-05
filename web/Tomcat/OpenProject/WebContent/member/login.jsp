  
<%@page import="model.LoginInfo"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	// 사용자 요청 정보를 받는다.
	String inputUid = (String)request.getParameter("uid");
	String inputPw = (String)request.getParameter("pw");
	String chk = (String)request.getParameter("remember"); 
	
	String rediectUri = request.getParameter("redirecUri");
	
	
	// 로그인 처리
	boolean loginChk = false;
	
	/* session.setAttribute("loginInfo",new LoginInfo("qq","11","이름","aa","stitch.jpeg")); */
/* 	LoginInfo loginInfo=(LoginInfo)session.getAttribute("loginInfo");
	로그아웃 시 세션 정보 삭제되기때문에 getUid()사용 시 널포인터 에러 발생

*/
	LoginInfo loginInfo=(LoginInfo)session.getAttribute("loginInfo");

	String uid=(String)loginInfo.getUid();
	String pw=(String)loginInfo.getPw();
	String uname=(String)loginInfo.getUname();
	String email=(String)loginInfo.getEmail();
	String img=(String)loginInfo.getPhoto();


 	if(inputUid.equals(uid)){
		if(inputPw.equals(pw)){
			%><script>alert('정상적으로 로그인되었습니다');</script><%
		loginChk = true;
		}
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