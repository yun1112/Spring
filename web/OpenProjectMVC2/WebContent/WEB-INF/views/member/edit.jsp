<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정</title>
	<div>
		<h1 class="subtitle">회원 수정</h1>
		<hr>
		<h3>
		
		<c:if test="${result gt 0 && member ne null}">
			<div>
				회원수정 완료
			</div>
			${member}
		</c:if>
		
		<c:if test="${not (result gt 0 && member ne null)}">
			회원수정 실패
		</c:if>
		
		
		
		</h3>
	</div>










