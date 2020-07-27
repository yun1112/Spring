
<%@page import="member.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
Member member=(Member)request.getAttribute("member");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INDEX</title>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>


<style>
td>img {
	width: 50px;
	height: 50px;
	}

    #contentForm {
      width: 60%;
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
	private String photo; -->
	<div>
		<h1 class="subtitle">회원 정보 수정</h1>
		<hr>
		<h2>${member.userID}</h2>
		<!-- 이 페이지는 데이터 베이스에 저장된 데이터를 value 값에 세팅해야합니다. -->
		<form id="editForm" action="editInfoForm.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="idx" value="${member.idx}">
			<div class="input-group input-group-sm" role="group" aria-label="...">
        <table class="table table-striped table-bordered">
				<tr>
					<th width="20%">아이디 ${member.userId} </th>
					<td width="80%"> <%-- <input type="email" name="uid" id="uid" value="${member.userId}" readonly  > --%>아이디는 수정이 불가합니다.</td>
				</tr>
				<tr>
					<th width="20%">비밀번호</th>
					<td width="80%"> <input type="password" name="upw" required value="${member.userPw}"> </td>
				</tr>
				<tr>
					<th width="20%">이름 ${member.userName}</th>
					<td width="80%"> <%-- <input type="text" name="uname" value="${member.userName}" required>  --%></td>
				</tr>
				<tr>
					<th width="20%">사진</th>
					<td width="80%"><input type="file" name="photo">
						<br>
						현재 파일 : ${member.photo}
						<input type="hidden" name="oldFile" value="${member.photo}" >
					 </td>
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

</body>
</html>
<script>
	
	$(document).ready(function(){
		

		
		
		
		
	});
	
	
</script>


