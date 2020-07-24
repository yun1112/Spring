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
	<div>
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
						<input type="submit" name="수정">
						<input type="reset">
					</td>
				</tr>
			</table>
		</form>
	</div>
<!-- <script>
	
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


