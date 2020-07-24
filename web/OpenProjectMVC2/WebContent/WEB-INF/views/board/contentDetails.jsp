<%@page import="board.model.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String content=(String)request.getAttribute("content");
Board board=(Board)request.getAttribute("board");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>


<style>
td>img {
	width: 50px;
	height: 50px;
}
</style>
</head>
<body>

	<!-- private int idx;
	private String userId;
	private String title;
	private String itemCategory;
	private String content;
	private String regDate;
	private String viewCount;
	private String fileContentAddr; -->

   <!--          <th width="10%">idx</th>
            <th width="10%">userId</th>
            <th width="50%">title</th>
            <th width="15%">date</th>
            <th width="10%">delete</th> -->
             
   
       
<h1>내용확인</h1>
		<hr>
	<c:if test="${not empty content}">
<table border="1">
<tr>
<td>번호</td>
<td>${board.idx}</td>
</tr>
<tr>
<td>제목</td>
<td><input type="text" value="${board.title}"></td>
</tr>
<tr>
<td>내용</td>
<td><textarea col="50" rows="10">${content}</textarea></td>
</tr>
<tr>
 <td><a href="boardContentDetails.do?idx=${board.idx}">${board.title}</a></td>
 <td><a href="editBoardContent.do?idx=${board.idx}">수정</a> <a href="javascript:memberDel(${board.idx})">삭제</a></td>
</tr>
</table>
	</c:if>
	<c:if test="${empty content}">
작성된 게시글이 없습니다
</c:if>

    	<script>
       	function moveToBoard(){
       		location.href='';
       	}
		function memberDel(idx) {
			if (confirm('선택한 게시글을 삭제하시겠습니까?')) {
				location.href = 'deletBoardContent.do?idx=' + idx;
			}

		}
	</script>
	<%-- 
	<div>
		<h1 class="subtitle"> 리스트</h1>

		<c:if test="${not empty listView  }">

		<div>전체회원 ${listView.memberTotalCount} 명</div>
		<hr>
	
		<table class="table">
			<tr>
				<th>no</th>
				<th>아이디</th>
				<th>제목</th>
				<th>분류</th>
				<th>내용</th>
				<th>조회수</th>
			</tr>
			
		<c:if test="${not empty listView.memberList }">
		<c:forEach items="${listView.memberList}" var="member">
			<tr>
				<td>${member.idx}</td>
				<td>${member.userId}</td>
				<td>${member.userName}</td>
				<td>${member.userPw}</td>
				<td><img alt="프사 " src="<c:url value="${member.photo}"/>">  </td>
				<td>
				<a href="memberEditForm.do?idx=${member.idx}">수정</a> 
				| 
				<a href="javascript:memberDel(${member.idx})">삭제</a></td>
			</tr>
		</c:forEach>
		</c:if>
		
		<c:if test="${empty listView.memberList }">
			<tr>
				<th>조회된 회원이 없습니다.</th>
			</tr>
		</c:if>


		</table>
		
		<div class="paging">
			<c:forEach begin="1" end="${listView.pageTotalCount}" var="i">
			
			<a class="paging_num ${i == listView.currentPageNumber ? 'now_page' : ''}" href="memberList.do?page=${i}" >${i}</a>
			
			</c:forEach>
		</div>



		</c:if>
	</div>

</body>
</html>


<script>
	function memberDel(idx){
		if(confirm('선택하신 회원 정보를 삭제하시겠습니까?')){
			location.href = 'memberDelete.do?idx='+idx;
		}
		
	}
</script> --%>
<%-- 
				<c:if test="${not empty listView.memberList }">
					<c:forEach items="${listView.memberList}" var="member">
						<tr>
							<td>${member.idx}</td>
							<td>${member.uid}</td>
							<td>${member.uname}</td>
							<td>${member.upw}</td>
							<td><img alt="프사 " src="<c:url value="${member.uphoto}"/>">
							</td>
							<td><a href="memberEditForm.do?idx=${member.idx}">수정</a> | <a
								href="javascript:memberDel(${member.idx})">삭제</a></td>
						</tr>
					</c:forEach>
				</c:if>

				<c:if test="${empty listView.memberList }">
					<tr>
						<th>조회된 회원이 없습니다.</th>
					</tr>
				</c:if>


			</table>

			<div class="paging">
				<c:forEach begin="1" end="${listView.pageTotalCount}" var="i">

					<a
						class="paging_num ${i == listView.currentPageNumber ? 'now_page' : ''}"
						href="memberList.do?page=${i}">${i}</a>

				</c:forEach>
			</div>



		</c:if>
	</div>

</body>
</html>
 --%>







