<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="reg">
	<h2 class="title">회원 저장</h2>
	<form action="../requestResult.jsp" method="post" id="regForm">
		<table>
			<tr>
				<td><label>아이디</label> <input type="text" id="uid"
					placeholder="아이디" required></td>
				<td><label>비밀번호</label> <input type="password" id="pw"
					placeholder="비밀번호" required></td>
				<td><label>이름</label> <input type="text" id="uname"
					placeholder="이름" required></td>
				<td><input type="submit" value="저장"></td>
			</tr>
		</table>

	</form>
</div>