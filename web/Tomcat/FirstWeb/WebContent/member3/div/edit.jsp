<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="edit">
	<h2 class="title">회원 수정</h2>
	<form id="editForm">
		<!-- <input type="text" id="idx"> -->
		<input action="../requestResult.jsp" type="hidden" id="idx" required>
		<table>
			<tr>
				<td><label>아이디</label> <input type="text" id="eid"
					placeholder="아이디" required></td>
				<td><label>비밀번호</label> <input type="password" id="epw"
					placeholder="비밀번호" required></td>
				<td><label>이름</label> <input type="text" id="ename"
					placeholder="이름" required></td>
				<td><input type="submit" value="수정"></td>
			</tr>
		</table>

	</form>
</div>