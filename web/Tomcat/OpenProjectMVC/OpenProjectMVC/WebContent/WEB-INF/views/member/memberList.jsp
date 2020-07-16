<%@page import="guestbook.model.MemberMessageListView"%>
<%@page import="guestbook.service.GetMemberMessageListService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
			<%

int pageNum = 1;   // list.jsp?page=9
String pageNumber = request.getParameter("page");
if(pageNumber != null) {
	pageNum = Integer.parseInt(pageNumber);
}

GetMemberMessageListService service = GetMemberMessageListService.getInstance();

// MessageListView
MemberMessageListView view = service.getMessageList(pageNum);

request.setAttribute("listView", view);
%>
	
		
		<div class="container">
		<%@ include file="/WEB-INF/views/include/header.jsp" %>
	
	
	
	
		<%-- ${listView} --%>
	<h1>전체 회원 목록</h1><hr>
	
	<c:if test="${not empty listView.messageList}">
	<c:forEach items="${listView.messageList}" var="message">
	<div class="msg_box">
		<h2> 회원 등록 번호 : ${message.idx} <br>
		아이디 : ${message.uid} <br>
		비밀번호 : ${message.upw} <br>
		이름 : ${message.uname} <br>
		사진(임시, 경로) : <img style="width:50px" src="<%=request.getContextPath() %>${message.uphoto}"/><br></h2>
<%-- 		<a href="deleteMessageConfirm.jsp?mid=${message.mid}">삭제</a>
 --%>	</div>	
	<hr>
	
	</c:forEach>
	
	</c:if>
	
	<c:if test="${listView.pageTotalCount > 0}">
	
	<div class="paging">
	<c:forEach begin="1" end="${listView.pageTotalCount}" var="num">
	<a href="list.jsp?page=${num}" ${listView.currentPageNumber eq num? 'class="currentPage"':''}>[ ${num} ]</a> 
	</c:forEach>
	</div>
	
	</c:if>	
		</div>
		<hr>
    		<%@ include file="/WEB-INF/views/include/footer.jsp" %>
    