
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
  <link href="<%=request.getContextPath() %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<style>
#container {
	width: 70%;
	margin: 0 auto; /* 가로로 중앙에 배치 */
	padding-top: 5%; /* 테두리와 내용 사이의 패딩 여백 */
}

#list {
	text-align: center;
}

#write {
	text-align: right;
}
td{
height:10%;
}
/* Bootstrap 수정 */
.table>thead {
	background-color: #b3c6ff;
}

.table>thead>tr>th {
	text-align: center;
}

.table-hover>tbody>tr:hover {
	background-color: #e6ecff;
}

.table>tbody>tr>td {
	text-align: center;
}

.table>tbody>tr>#title {
	text-align: left;
}

div>#paging {
	text-align: center;
}

.hit {
	animation-name: blink;
	animation-duration: 1.5s;
	animation-timing-function: ease;
	animation-iteration-count: infinite;
	/* 위 속성들을 한 줄로 표기하기 */
	/* -webkit-animation: blink 1.5s ease infinite; */
}

/* 애니메이션 지점 설정하기 */
/* 익스플로러 10 이상, 최신 모던 브라우저에서 지원 */
@
keyframes blink {
	from {color: white;
}

30
%
{
color
:
yellow;
}
to {
	color: red;
	font-weight: bold;
}
/* 0% {color:white;}
      30% {color: yellow;}
      100% {color:red; font-weight: bold;} */
}
td>img {
	width: 50px;
	height: 50px;
}
</style>
</head>
<body>
	<c:if test="${not empty info}">

		<div>
			<h1 class="subtitle">회원 리스트</h1>

			<c:if test="${not empty listView  }">

				<div>전체회원 ${listView.memberTotalCount} 명</div>
				<hr>
				<!-- private String userId;
	private String userPw;
	private String userName;
	private String userNickname;
	private String email;
	private String contactNumber;
	private String address;
	private String photo; -->
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th width="10%">글번호</th>
							<th width="10%">아이디</th>
							<th width="50%">이름</th>
							<th width="15%">비밀번호</th>
							<th width="10%">사진</th>
							<th width="10%">관리</th>
						</tr>
					</thead>
					<tbody>

						<c:if test="${not empty listView.memberList }">
							<c:forEach items="${listView.memberList}" var="member">
								<tr>
									<td>${member.idx}</td>
									<td>${member.userId}</td>
									<td>${member.userName}</td>
									<td>${member.userPw}</td>
									<td><img alt="프사 " src="<c:url value="${member.photo}"/>">
									</td>
									<td><a href="memberMypage.do?idx=${member.idx}">수정</a> |
										<a href="javascript:memberDel(${member.idx})">삭제</a></td>
								</tr>
							</c:forEach>
						</c:if>

						<c:if test="${empty listView.memberList }">
							<tr>
								<th>조회된 회원이 없습니다.</th>
							</tr>
						</c:if>
						</tbody>
				</table>

				<div class="paging">

					
					<span>
          <ul style="text-align:center;margin:2% 40%;" class="pagination">
					<c:forEach begin="1" end="${listView.pageTotalCount}" var="i">
						<li><a class="paging_num ${i == listView.currentPageNumber ? 'now_page' : ''}"
							href="memberList.do?page=${i}">${i}</a></li>
					</c:forEach>
          </ul>
          </span>
          </div>
				</div>



			</c:if>
	</c:if>
	<c:if test="${empty info}">
		<script>
			alert('로그인 하세요');
			location.href = '${pageContext.request.contextPath}/login.jsp';
		</script>

	</c:if>
	</div>

</body>
</html>


<script>
	function memberDel(idx) {
		if (confirm('선택하신 회원 정보를 삭제하시겠습니까?')) {
			location.href = 'memberDelete.do?idx=' + idx;
		}

	}
</script>
