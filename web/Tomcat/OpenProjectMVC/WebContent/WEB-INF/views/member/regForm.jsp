<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INDEX</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">

<style>
.check_ok {
	color: blue;
}

.check_not {
	color: red;
}

.check {
	border-color: red;
}

#idchk {
	display: none;
}
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<div class="container">
		<h1 class="subtitle">회원 가입</h1>
		<hr>
		<form id="regForm" action="memberReg.do" method="post"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td>아이디(email)</td>
					<td><input type="email" name="uid" id="uid" required><input
						type="checkbox" name="idchk" id="idchk"> <span
						id="checkmsg"></span></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="upw" required></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="uname" required></td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="photo"></td>
<!-- 					<td><input type="file" name="photo" required></td> -->
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="회원가입"> <input
						type="reset"></td>
				</tr>
			</table>
		</form>
		<hr>
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		<hr>
	</div>

</body>
</html>
<script>
	$(document).ready(function() {
		/* $('#regForm').submit(function(){
		if(!$('#idchk').prop('checked')){
			alert('아이디중복체크는 필수항목입니다');
		}
			return false;
		}); */

		$('#uid').focusin(function() {
			$(this).val('');
			$('#checkmsg').text('');

			$('#checkmsg').removeClass('check_ok');
			$('#checkmsg').removeClass('check_not');

		});

		$('#uid').focusout(function() {
			if ($(this).val().length < 1) {
				$('#checkmsg').text("아이디항목은 필수항목입니다");

				$('#checkmsg').addClass('check_not');
				/* $(this).addClass('check'); */
				return false;

			} else {
				$(this).addClass('check2')
			}

			//비동기통신
			$.ajax({
				url : 'idCheck.do',
				data : {
					uid : $(this).val()
				},
				success : function(data) {
					if (data == 'Y') {
						$('#checkmsg').text("사용가능한 아이디입니다");
						$('#checkmsg').addClass('check_ok');
						$('#idchk').prop('checked', true);
					} else {
						$('#checkmsg').text("사용불가능한 아이디입니다");
						$('#checkmsg').addClass('check_not');
						$('#idchk').prop('checked', false);

					}
				}

			});
		});
	});
</script>








