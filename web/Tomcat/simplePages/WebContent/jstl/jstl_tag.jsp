<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setAttribute("price",10000);
	request.setAttribute("now",new Date());
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL TAG</title>
</head>
<body>
<%--  	<c:set var="number" values="${10000 }"/>
 --%><%--  	<c:set var="number" values="10000"/> --%> 	
	
	

	<br><br>

	날짜 포맷팅<br>
	<fmt:formatDate value="${now}" pattern="yyyy.MM.dd H:mm:ss"/><br>
	<fmt:formatDate value="${now}" pattern="yyyy.MM.dd H:mm"/><br>
	<br>
	
	하와이 시간대<br>
	<fmt:timeZone value="US/Hawaii">
	<fmt:formatDate value="${now}" pattern="yyyy.MM.dd H:mm:ss"/><br>
	<fmt:formatDate value="${now}" pattern="yyyy.MM.dd H:mm"/><br>
</fmt:timeZone>
	<br><br>
	날짜와 시간을 동시에 표현<br>
	<fmt:formatDate value="${now}" type="both"/><br>
	<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br>
	<fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="full"/><br>
	<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="short"/><br>
	<fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short"/><br>
	
	<br><br>
	
	시간 표현<br>
	<fmt:formatDate value="${now}" type="time"/><br>
	<fmt:formatDate value="${now}" type="time" timeStyle="short"/><br>
	<fmt:formatDate value="${now}" type="time" timeStyle="full"/><br>
	<br><br>
	
	날짜 표현<br>
	<fmt:formatDate value="${now}"/><br>
	<fmt:formatDate value="${now}" type="date"/><br>
	<fmt:formatDate value="${now}" type="date" dateStyle="short"/><br>
	<fmt:formatDate value="${now}" type="date" dateStyle="full"/><br>
	<br>
	
		

	<hr>
 	숫자 타입: <fmt:formatNumber value="${price}" type="number"/><!-- 출력 -->
 	<fmt:formatNumber value="${price}" type="number" var="numberType"/> <!-- 저장 -->
	${numberType}
	<br>
	통화:<fmt:formatNumber value="${price }" type="currency"/>
	<fmt:formatNumber value="${price }" type="currency" var="numberType"/>
	${numberType }
	<br>
	퍼센트:<fmt:formatNumber value="${price/30000 }" type="percent"/>
	<fmt:formatNumber value="${price }" type="percent" var="numberType" groupingUsed="false"/>
	${numberType }
	<br>
	
	패턴:<fmt:formatNumber value="${price }" pattern="000000.00"/>
	<fmt:formatNumber value="${price }" pattern="000,000.0000"/>
	<br>
	
 	<hr>
 	<c:out value="jstl tag out -> 데이터를 출력합니다."/>
 	<br>
 	<c:out value="${members[7].email}" default="<i>이메일 없음</i>" escapeXml="false"/>
 	<br>
 	<c:out value="${members[8].email}" escapeXml="false">
 		<span style="color:red">이메일 없음</span>
 	</c:out>
 	
 	<c:if test="${members[8].email == null}">
 		<span style="color:blue">이메일 없음</span>
 	</c:if>
 	
 	
 	
 	<c:forEach 
 				items="${applicationScope.members}" 
 				var="member" 
 				varStatus="status"
 	>
 	<h3>
 	
 	${status.index} ${status.count}
 	
 	이름 : ${member.name}, 이메일 : 
 	
 	<c:out value="${member.email}" escapeXml="false">
 		<span style="color:red">이메일 없음</span>
 	</c:out> 
 	
 	<c:if test="${member.email == null}">
 		<span style="color:blue">이메일 없음</span>
 	</c:if>
 	
 	<c:if test="${ empty member.email}">
 		<span style="color:green">이메일 없음</span>
 	</c:if>
 	
 	
 	
 	
 	</h3>
 	</c:forEach>
 	
 	 
 	
 	
 	<br>
 	
 	<c:forTokens items="손흥민, 010-7777-1111, 런던" delims="," var="token" >
 		${token}<br>
 	</c:forTokens>
 	
 	<h1>
	URL1: <c:url value="/index.jsp"/><br>
	
	<a href="<c:url value="/index.jsp"/>">홈</a><br>
	
	
	URL2: <c:url value="jstl_tag2.jsp">
	<c:param name="year" value="1999"/>
	</c:url><br>
	URL3: <c:url value="jstl_tag2.jsp?year=1999"/><br>
	<c:url value="jstl_tag2.jsp?year=1999" var="reurl"/>
	URL4: ${reurl }
	
	
 	</h1>


<%-- 	<c:redirect url="${reurl}">
	<c:param name="month">7</c:param>
	</c:redirect> --%>
	


	













</body>
</html>