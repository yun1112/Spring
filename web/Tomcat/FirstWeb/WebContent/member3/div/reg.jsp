<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="../css/reg.css" rel="stylesheet">
<div id="reg">
        <h1 id="mgr">Registration</h1><hr><br>

        <div id="div1">
            <p id="menu">회원 가입</p><br>
            
	<!-- <form action=loginForm.jsp"> -->
	<form action="../../loginResult.jsp">
	<div id="tableDiv">
		<table>
			<tr>
				<td><label>아이디(이메일)</label> <input type="text" name="id"
					placeholder="아이디" required></td></tr>
					<tr>
				<td><label>비밀번호</label> <input type="password" name="pwd"
					placeholder="비밀번호" required></td></tr>
					</tr>
				<td><label>이름</label> <input type="text" name="name"
					placeholder="이름" required></td></tr>
					<tr>
				<td><input colspan="2" type="submit" value="가입"></td></tr>
			</tr>
		</table>
</div>
	</form>
</div>