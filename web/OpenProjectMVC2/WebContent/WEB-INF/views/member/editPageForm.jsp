<%@page import="java.util.List"%>
<%@page import="board.model.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%

int idx=Integer.parseInt(request.getParameter("idx"));
Board board=(Board)request.getAttribute("board");
List<Board> listAll=(List)request.getAttribute("listAll");


request.setAttribute("idx",idx);
request.setAttribute("board",board);
request.setAttribute("listAll",listAll);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>


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
	.check_ok {
		color : blue;
	}
	.check_not {
		color : red;
	}
	#idchk {
		display: none;
	}
</style>
</head>
<body>
<!-- 
private String userId;
	private String userPw;
	private String userName;
	private String userNickname;
	private String email;
	private String contactNumber;
	private String address;
	private String photo; 
	
	
int idx=(int)request.getAttribute("idx");
Board board=(Board)request.getAttribute("board");
List<Board> listAll=(List)request.getAttribute("listAll");
	
	-->
	
	<form action="editBoardContent2.do" method="post">
    <div id="contentForm">
        <input type="hidden" name="pageNum" value="${pageNum}">
        <input type="hidden" name="articleNumber" value="${article.articleNumber}">
         
        <div class="input-group input-group-sm" role="group" aria-label="...">
        <table class="table table-striped table-bordered">
          <thead>
            <tr>
              <th width="20%">글번호</th><input type="hidden" id="idx" name="idx" value="${board.idx}">
              <td width="80%">${board.idx}</td>
            </tr>
            <tr>
              <th width="20%">글쓴이</th><input type="hidden" id="userId" name="userId" value="${board.userId}">
              <td width="80%">${board.userId}</td>
            </tr>
            <tr>
              <th style="padding-top: 15px">제목</th>
              <td><input type="text" name="title" id="title" value="${board.title}"
                    class="form-control" aria-describedby="basic-addon1"></td>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th width="20%">내용</th>
              <td width="80%">
                <textarea class="form-control" rows="10" id="content" name="content">${board.content}</textarea>
              </td>
         <%--    </tr>
                          <td>
                          <a href="editBoardContent.do?idx=${board.idx}">수정</a> <a href="javascript:memberDel(${board.idx})">삭제</a>
                          </td> --%>
            
            <!-- <tr>
              <th style="padding-top: 15px">첨부파일</th>
              <td><input type="file" class="btn btn-default" name="fileName"></td>
            </tr> -->
          </tbody>
        </table>
        <input class="btn btn-outline-primary" type="submit" value="수정">
        <input class="btn btn-outline-primary" type="reset" value="초기화">
                          <%-- <a href="editBoardContent2.do?idx=${board.idx}">수정</a> <a href="javascript:memberDel(${board.idx})">삭제</a> --%>
      </div>
      <%-- <div class="btn-group btn-group-sm" role="group" aria-label="...">
        <input type="submit" class="btn btn-default" value="수정하기">
        <input type="button" class="btn btn-default" value="취소" onclick="document.location.href='/bbs/content.bbs?articleNumber=${articleNumber}&pageNum=${pageNum}'">
      </div> --%>
      <!-- <div class="btn-group btn-group-sm" role="group" aria-label="...">
       <input type="submit" value="수정">
	   <input type="reset">
      </div> -->
    </div>
   </form>
 
       	<script>
       	function moveToBoard(){
       		location.href='temp.do';
       	}
		function memberDel(idx) {
			if (confirm('선택한 게시글을 삭제하시겠습니까?')) {
				location.href = 'deletBoardContent.do?idx=' + idx;
			}

		}
	</script>
<hr>
<%-- 	<div>
	<h1>전달확인</h1>
	${idx}<hr>
	${board}<hr>
	${listAll}<hr>
	
		<h1 class="subtitle">게시물 수정</h1>
		<hr>
		<!-- 이 페이지는 데이터 베이스에 저장된 데이터를 value 값에 세팅해야합니다. -->
<!-- 		index.do로 임시 이
 -->		<form id="editForm" action="editBoardSuccessContent.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="idx" value="${board.idx}">
			<table>
				<tr>
					<td>아이디</td>
					<td> <input type="text" name="uid" id="uid" value="${board.userId}" readonly  >아이디는 수정이 불가합니다.</td>
				</tr>
				<tr>
					<td>제목</td>
					<td> <input type="text" name="title" id="title" value="${board.title}" required> </td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea col="10" row="10" name="content" id="content" required>${board.content}</textarea></td>
				</tr>
				<tr>
					<td></td>
					<td> 
						<input type="submit" value="수정">
						<input type="reset">
					</td>
				</tr>
			</table>
		</form>
	</div>
 --%><!-- <script>
	
	$(document).ready(function(){
		
		$('#regForm').submit(function(){
			
			if(!$('#idchk').prop('checked')){
				alert('아이디 중복 체크는 필수 항목 입니다');
				$('#uid').focus();
				return false;
			}
			
			
			
		});
		
		$('#uid').focusin(function(){
			
			$(this).val('');
			$('#idchk').prop('checked', false);
			
			$('#checkmsg').text('');
			
			$('#checkmsg').removeClass('check_not');
			$('#checkmsg').removeClass('check_ok');
		});
		
		$('#uid').focusout(function(){
			
			if($(this).val().length<1){
				$('#checkmsg').text("아이디 항목은 필수 항목입니다.");
				$('#checkmsg').addClass('check_not');
				return false;
			}
			
			// 비동기 통신
			$.ajax({
				url : 'idCheck.do',
				data : { uid : $(this).val()},
				success : function(data){
					if(data == 'Y'){
						$('#checkmsg').text("사용가능한 아이디 입니다.");
						$('#checkmsg').addClass('check_ok');
						$('#idchk').prop('checked', true);
					} else {
						$('#checkmsg').text("사용이 불가능한 아이디 입니다.");
						$('#checkmsg').addClass('check_not');
						$('#idchk').prop('checked', false);
					}
				}
			});
			
			
		});
		
		
	});
	
	
</script> -->
</body>
</html>


