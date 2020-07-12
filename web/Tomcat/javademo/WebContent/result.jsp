<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>
<h1>Users</h1>
<hr>


${userList }<br>
<hr>
<h3>${userList[0].first_name }</h3>
<h3>${userList[0].last_name }</h3>
<h3>${userList[0].num_points }</h3>
<hr>

<%-- <c:forEach items="${userList}" var="item">
  ${item}<br>
  <c:out value="${item.first_name }"/><br>
</c:forEach> --%>

<c:forEach var="item" items="${userList}" varStatus="status">
<h1>${status.count }</h1>
 <h3>first name: </h3>${item.first_name }<br>
 <h3>last name: </h3>${item.last_name }<br>
 <h3>num points: </h3>${item.num_points }<br>
 <hr>
</c:forEach>


	
	
	
</body>
</html>