<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Gaegu&display=swap" rel="stylesheet">
<style>
*{
font-family: 'Gaegu', cursive;
}
</style>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
	<div>
		<hr>
		<h3>
		
			<div class="container">
		<c:if test="${result gt 0 && member ne null}">
				회원 정보 수정 완료
			<%-- ${member} --%>
		</c:if>
		
		<c:if test="${not (result gt 0 && member ne null)}">
			회원 정보 수정 실패
		</c:if>
			</div>
		
		
		
		</h3>
	</div>










