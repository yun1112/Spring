  
<%@page import="model.LoginInfo"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
	
	
<
<c:set var="inputUid" value="${param.uid}"/>
<c:set var="inputPw" value="${param.pw}"/>
<c:set var="chk" value="${param.remember}"/>

<c:set var="loginChk" value="false"/>
	
<c:set var="loginInfo" value="${sessionScope.loginInfo }"/>	
	
<%-- <%
	LoginInfo loginInfo=(LoginInfo)session.getAttribute("loginInfo");%> --%>
	
<c:if test="${!empty loginInfo}">

<%-- <c:set var="loginInfo" value="new Logininfo(${uid},${pw},${uname},${email},${img})"/>
 --%><% session.setAttribute("loginInfo",new LoginInfo("guest","1234","이름","aa","stitch.jpeg")); %>

</c:if>	

<c:if test="${empty loginInfo}">
	<c:set var="uid" value="${loginInfo.uid}"/>
	<c:set var="pw" value="${loginInfo.pw}"/>
	<c:set var="uname" value="${loginInfo.uname}"/>
	<c:set var="email" value="${loginInfo.email}"/>
	<c:set var="img" value="${loginInfo.photo}"/>
	
	<c:if test="${inputUid}==${uid}">
		<c:if test="${inputPw}==${pw}">
			<script>alert('정상적으로 로그인되었습니다');</script>
			<c:set var="loginChk" value="true"/>
		</c:if>
	</c:if>
	
	<c:if test="${!empty loginChk}">
		<c:set var="cookieName" value="uid"/>
		<c:set var="cookiePw" value="pw"/>
		<c:set var="cookiepath" value="uid"/>
	</c:if>
	
</c:if>

	<%-- <%

	
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
		<script>location.href="${pageContext.request.contextPath}/member/mypageAfterLogin.jsp";</script>
		<%
			
	} else {
		%>
		<script>
		alert('아이디 또는 비밀번호를 확인후 다시 로그인해 주세요.') 
		history.go(-1);
		</script>
		<%
	}
	}
%> --%>