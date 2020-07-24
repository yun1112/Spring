<%@page import="java.util.List"%>
<%@page import="member.model.MemberListView"%>
<%@page import="member.model.Member"%>
<%@page import="login.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	//LoginInfo loginInfo=(LoginInfo)session.getAttribute("loginInfo");
/*  boolean loginCheck=(boolean)request.getAttribute("loginCheck");
   if(loginCheck){
  LoginInfo loginInfo=(LoginInfo)request.getAttribute("loginInfo");
   
   } */
Member member = (Member) request.getAttribute("member");

List<Member> list = (List) request.getAttribute("list");

request.setAttribute("member", member);

LoginInfo info=(LoginInfo)request.getAttribute("info");
/* LoginInfo info=(LoginInfo)session.getAttribute("info"); */
request.setAttribute("info",info);
//request.setAttribute("listView", listView);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>

</head>
<body>
	<c:if test="${not empty info}">


		<h1>반갑습니다 ${info.uid} 회원님</h1>
		<hr>
		<c:if test="${not empty list }">
			<c:forEach items="${list}" var="member">
				<c:if test="${member.userId==info.uid}">

					<form id="regForm" action="editInfo.do" method="post"
						enctype="multipart/form-data">
						<input type="hidden" id="idx" name="idx" value="${member.idx}">
						<table>
							<tr>
								<td>아이디</td>
								<td><input type="text" id="uid" name="uid"
									value="${member.userId}"></td>
							</tr>
							<tr>
								<td>비밀번호</td>
								<td><input type="password" id="upw" name="upw"
									value="${member.userPw}"></td>
							</tr>
							<tr>
								<td>이름</td>
								<td><input type="text" id="uname" name="uname"
									value="${member.userName}"></td>
							</tr>
							<tr>
								<td>닉네임</td>
								<td><input type="text" id="nickname" name="nickname"
									value="${member.userNickname}"></td>
							</tr>
							<tr>
								<td>이메일</td>
								<td><input type="text" id="email" name="email"
									value="${member.email}"></td>
							</tr>
							
							<tr>
								<td>연락처</td>
								<td><input type="text" id="contactNumber"
									name="contactNumber" value="${member.email}"></td>
							</tr>
							<tr>
								<td>주소</td>
								<td><input type="text" id="address" name="address"
									value="${member.address}"></td>
							</tr>
							<tr>
								<td>사진</td>
								<td><input type="file" name="photo"></td>
								</tr>
								<tr>
								<td>현재 파일</td>
								<td><img
									src="<%=request.getContextPath()%>/${member.photo}"> </td>
							</tr>
							<tr>		
									<td><input
									type="hidden" name="oldFile" style="width:20px" value="${member.photo}"></td>
							</tr>


							<tr>
								<td><img alt="프사 " style="width:20px" src="<c:url value="${member.photo}"/>">
								</td>
								<%-- <td><a href="memberEditForm.do?idx=${member.idx}">수정</a> <a
									href="javascript:memberDel(${member.idx})">삭제</a></td> --%>
							</tr>


							<tr>
								<td><input type="submit" value="수정"></td>
								<td></td>
							</tr> 
						</table>
					</form>
				</c:if>
			</c:forEach>
		</c:if>


	</c:if>

	<c:if test="${empty info}">
		<script>
			alert('로그인 하세요');
			location.href = '${pageContext.request.contextPath}';
		</script>
	</c:if>