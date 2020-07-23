<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="ko">
<meta charset="utf-8">


<%@ page trimDirectiveWhitespaces="true"%>
<script>
	alert('${msg}');
		//location.href = '<c:url value="/index.do"/>';
	location.href="<%=request.getContextPath()%>/deleteContentSuccess.jsp";

	/* 	histoty.go(-3);
	 */
</script>