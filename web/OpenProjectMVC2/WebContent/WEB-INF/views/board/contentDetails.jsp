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



<link href="bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <style>
  td>img {
	width: 50px;
	height: 50px;
	}

    #contentForm {
      width: 70%;
      margin: 0 auto;
      padding-top: 2%;
    }
 
    .table > thead > tr > th, .table > tbody > tr > th {
      background-color: #e6ecff;
      text-align: center;
    }
  </style>



</head>
<body>
	<c:if test="${not empty content}">

<form action="#" method="post">
    <div id="contentForm">
        <input type="hidden" name="pageNum" value="${pageNum}">
        <input type="hidden" name="articleNumber" value="${article.articleNumber}">
         
        <div class="input-group input-group-sm" role="group" aria-label="...">
        <table class="table table-striped table-bordered">
          <thead>
            <tr>
              <th width="20%">글번호</th>
              <td width="80%">${board.idx}</td>
            </tr>
            <tr>
              <th width="20%">글쓴이</th>
              <td width="80%">${board.userId}</td>
            </tr>
            <tr>
              <th style="padding-top: 15px">제목</th>
              <td><input type="text" name="title" value="${board.title}"
                    class="form-control" aria-describedby="basic-addon1" readonly></td>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th width="20%">내용</th>
              <td width="80%">
                <textarea class="form-control" rows="100" name="content" readonly>${board.content}</textarea>
              </td>
            </tr>
            <!-- <tr>
              <th style="padding-top: 15px">첨부파일</th>
              <td><input type="file" class="btn btn-default" name="fileName"></td>
            </tr> -->
          </tbody>
        </table>
      </div>
      <%-- <div class="btn-group btn-group-sm" role="group" aria-label="...">
        <input type="submit" class="btn btn-default" value="수정하기">
        <input type="button" class="btn btn-default" value="취소" onclick="document.location.href='/bbs/content.bbs?articleNumber=${articleNumber}&pageNum=${pageNum}'">
      </div> --%>
      <div class="btn-group btn-group-sm" role="group" aria-label="...">
       <a  class="btn btn-outline-primary" href="editBoardContent.do?idx=${board.idx}">수정</a>
       <a  class="btn btn-outline-primary" href="javascript:memberDel(${board.idx})">삭제</a>
      </div>
    </div>
  </form>
</c:if>

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
             
   
       
	<c:if test="${empty content}">
작성된 게시글이 없습니다
</c:if>
<%-- 
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
 <td><a href="editBoardContent.do?idx=${board.idx}">수정</a> <a href="javascript:memberDel(${board.idx})">삭제</a></td>
</tr>
</table>
	</c:if>
	<c:if test="${empty content}">
작성된 게시글이 없습니다
</c:if> --%>

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







