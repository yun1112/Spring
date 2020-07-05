  
<%@page import="model.LoginInfo"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	// 사용자 요청 정보를 받는다.
	String uid = request.getParameter("uid");
	String pw = request.getParameter("pw");
	String email = request.getParameter("email");
	String img = request.getParameter("img");
	
	String rediectUri = request.getParameter("redirecUri");
	
	
	LoginInfo loginInfo=new LoginInfo(uid,pw,email,img);
	session.setAttribute("loginInfo", loginInfo);
	%>
	
	<!-- <script>location.href="/op/regTest/registration.jsp";</script> -->
	
	<div>
		<h1 class="subtitle">회원가입</h1>
		
		<hr>
		
		
<%-- 			<input type="text" name="redirecUri" 
			
			value="<%= request.getHeader("referer")%>" style=" width : 50% ;" >	 --%>		
			
			<!--	public LoginInfo(String uid, String uname, String email, String photo) {  -->
			<table class="table">
				<tr>
					<td>아이디</td>
					<td> <%= uid%></td>
				</tr>
				<tr>q
					<td>비밀번호</td>
					<td> <%= pw%> </td>
				</tr>				
				<tr>
					<td>이메일</td>
					<td> <%= email%></td>
				</tr>
				<tr>
					<td>사진</td>
					<%-- <td> <img style="width:100px" src="<%= img%>"> </td> --%>
					<td> <img value="<%=img %>"> </td>
				</tr>				
				<tr>
				<td><a href="registrationForm.jsp">다시</a></td>
				</tr>
			</table>
		
		</form>
		
	</div>