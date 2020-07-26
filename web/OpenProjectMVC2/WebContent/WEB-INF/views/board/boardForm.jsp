<%@page import="java.util.List"%>
<%@page import="member.model.Member"%>
<%@page import="login.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	LoginInfo info = (LoginInfo) request.getAttribute("info");
/* 	LoginInfo info=(LoginInfo)session.getAttribute("info"); */

Member member = (Member) request.getAttribute("member");
List<Member> list = (List) request.getAttribute("list");
request.setAttribute("info", info);
request.setAttribute("member", member);
request.setAttribute("list", list);
%>
<html lang="ko">
<meta charset="utf-8">
<style>
 td>img {
	width: 50px;
	height: 50px;
	}

    #contentForm {
      width: 40%;
      margin: 0 auto;
      padding-top: 12%;
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
.check_ok {
	color: blue;
}

.check_not {
	color: red;
}

#idchk {
	display: none;
}
</style>
</head>
<!-- private String userId;
	private String title;
	private String itemCategory;
	private String content;
	private String viewCount;
	private String fileContentAddr; -->

<c:if test="${not empty info}">

	<div>
		<h1 class="subtitle">글</h1>
		<hr>
		<form id="regForm" action="buyerBoardForm.do" method="post">
			<!-- 		<form id="regForm" action="buyerBoard.do" method="post" enctype="multipart/form-data"> -->
        <div class="input-group input-group-sm" role="group" aria-label="...">
        <table class="table table-striped table-bordered">
				<tr>
					<th width="20%">아이디</th>
					<td width="80%">${info.uid}<input type="hidden" name="uid"
						value="${info.uid}">
					</td>
				</tr>
				<tr>
				 <th style="padding-top: 15px">제목</th>
              <td><input type="text" name="title" value="${board.title}"
                    class="form-control" aria-describedby="basic-addon1" required></td>
            </tr>
				<tr>
					   <th width="20%">내용</th>
              <td width="80%"><textarea name="content" col="20" row="20" required></textarea></td>
				</tr>
				<tr><td></td>
<!-- 					<td><a href="/board/buyerBoardForm.do">게시물확인</a></td>
 -->
					<td><input type="submit" name="작성"> <input
						type="reset"></td>
				</tr>
			</table>
		</form>
	</div>
</c:if>

<c:if test="${empty info}">
	<script>
		alert('로그인 하세요');
		location.href = '${pageContext.request.contextPath}';
	</script>

</c:if>
<script>
	$(document).ready(function() {

		$('#regForm').submit(function() {

			if (!$('#idchk').prop('checked')) {
				alert('아이디 중복 체크는 필수 항목 입니다');
				$('#uid').focus();
				return false;
			}

		});

		$('#uid').focusin(function() {

			$(this).val('');
			$('#idchk').prop('checked', false);

			$('#checkmsg').text('');

			$('#checkmsg').removeClass('check_not');
			$('#checkmsg').removeClass('check_ok');
		});

		$('#uid').focusout(function() {

			if ($(this).val().length < 1) {
				$('#checkmsg').text("아이디 항목은 필수 항목입니다.");
				$('#checkmsg').addClass('check_not');
				return false;
			}

			// 비동기 통신
			$.ajax({
				url : 'idCheck.do',
				data : {
					uid : $(this).val()
				},
				success : function(data) {
					if (data == 'Y') {
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
</script>