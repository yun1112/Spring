<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="requestMessage" class="guestbook.model.Message" scope="request"/>
<jsp:setProperty property="*" name="requestMessage"/>


<jsp:forward page="messageWriteView.jsp"/>

