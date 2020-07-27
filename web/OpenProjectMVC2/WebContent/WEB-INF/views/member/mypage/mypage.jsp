<%@page import="java.util.List"%>
<%@page import="member.model.MemberListView"%>
<%@page import="member.model.Member"%>
<%@page import="login.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	//LoginInfo loginInfo=(LoginInfo)session.getAttribute("loginInfo");
/*  boolean loginCheck=(boolean)request.getAttribute("loginCheck");
   if(loginCheck){
  LoginInfo loginInfo=(LoginInfo)request.getAttribute("loginInfo");
   
   } */
Member member = (Member) request.getAttribute("member");
String[] arr = (String[])request.getAttribute("arr");

String postcode=(String)request.getAttribute("postcode");
String address=(String)request.getAttribute("address");
String detailAddress=(String)request.getAttribute("detailAddress");
String extraAddress=(String)request.getAttribute("extraAddress");

List<Member> list = (List) request.getAttribute("list");

request.setAttribute("member", member);

LoginInfo info=(LoginInfo)session.getAttribute("info");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link href="https://fonts.googleapis.com/css2?family=Gaegu&display=swap" rel="stylesheet">
<style>
*,.greeting,h3{
font-family: 'Gaegu', cursive;
}
form{
	padding:2% 10%;
}

input{
margin:0.5%;
}
input[type="text"],input[type="password"],input[type="email"]{
width:30%;
}
input[type="text"]>.addr{
width:50%;
}
 td>img {
	width: 50px;
	height: 50px;
	}

    #contentForm {
      width: 50%;
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
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailAddress").focus();
            }
        }).open();
    }
</script>




<hr>
<%-- <c:forEach items="${arr}" var="a">
${a}<hr>
</c:forEach>
${list}<hr>
${member}<hr>${info}<hr> --%>
		<div class="container">
       <h3><b style="color:blue">${info.uid}</b> 회원님</h3>
		<c:if test="${not empty list }">
			<c:forEach items="${list}" var="member">
				<c:if test="${member.userId==info.uid}">

					<form id="regForm" action="editInfo.do" method="post"
						enctype="multipart/form-data">
						<input type="hidden" id="idx" name="idx" value="${member.idx}">
						 <div class="input-group input-group-sm" role="group" aria-label="...">
        <table class="table table-striped table-bordered">
							<tr>
								<th width="20%">아이디</th>
								<td width="80%"><input type="text" id="uid" name="uid"
									value="${member.userId}" readonly></td>
							</tr>
							<tr>
								<th width="20%">비밀번호</th>
								<td width="80%"><input type="password" id="upw" name="upw"
									value="${member.userPw}">
									<!-- <input type="submit" value="수정"> -->
									</td>
							</tr>
				<%-- 			<tr>
								<td>비밀번호확인</td>
								<td><input type="password" id="upwChk" name="upwChk"
									value="${member.userPw}"><input type="submit" value="수정"></td>
							</tr> --%>
							<tr>
								<th width="20%">이름</th>
								<td width="80%"><input type="text" id="uname" name="uname"
									value="${member.userName}"><!-- <input type="submit" value="수정"> --></td>
							</tr>
							<tr>
								<th width="20%">닉네임</th>
								<td width="80%"><input type="text" id="nickname" name="nickname"
									value="${member.userNickname}"><!-- <input type="submit" value="수정"> --></td>
							</tr>
							<tr>
								<th width="20%">이메일</th>
								<td width="80%"><input type="email" id="email" name="email"
									value="${member.email}"><!-- <input type="submit" value="수정"> --></td>
							</tr>
							
							<tr>
								<th width="20%">연락처</th>
								<td width="80%"><input type="text" id="contact"
									name="contact" value="${member.contactNumber}"><!-- <input type="submit" value="수정"> --></td>
							</tr>
							
							<tr><th width="20%">주소</th>
							<td width="80%"><hr><c:if test="${not empty postcode}">
		<input style="width:35%" class="addr" type="text" name="postcode" id="postcode" value="${postcode}">
</c:if>
<c:if test="${empty postcode}">
		<input style="width:35%" class="addr" type="text" name="postcode" id="postcode" placeholder="우편번호">
</c:if>
<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>


<c:if test="${not empty address}">
<input style="width:35%" class="addr" type="text" name="address" id="address" value="${address}"><br>
</c:if>
<c:if test="${empty address}">
<input style="width:35%" class="addr" type="text" name="address" id="address" placeholder="주소"><br>
</c:if>

<c:if test="${not empty detailAddress}">
<input style="width:35%" class="addr" type="text" name="detailAddress" id="detailAddress" value="${detailAddress}"><br>
</c:if>
<c:if test="${empty detailAddress}">
<input style="width:35%" class="addr" type="text" name="detailAddress" id="detailAddress" placeholder="상세주소"><br>
</c:if>

<c:if test="${not empty extraAddress}">
<input style="width:35%" class="addr" type="text" name="extraAddress" id="extraAddress" value="${extraAddress}">
</c:if>
<c:if test="${empty extraAddress}">
<input style="width:35%" class="addr" type="text" name="extraAddress" id="extraAddress" placeholder="참고항목">
</c:if><hr></td>
							</tr><hr>
							
							<%-- <tr>
								<td>주소</td>
								<td><input type="text" id="address" name="address"
									value="${member.address}"><input type="submit" value="수정"></td>
							</tr> --%>
							<tr>
								<th width="20%">사진</th>
								<td width="80%"><img alt="프사 " style="width:10%" src="<c:url value="${member.photo}"/>"><input type="file" name="photo"></td>
								</tr>
								<%-- <tr>
								<td>현재 파일</td>
								<td><img
									src="<%=request.getContextPath()%>/${member.photo}"> </td>
							</tr> --%>
									<input
									type="hidden" name="oldFile" style="width:20px" value="${member.photo}">


							<%-- 	<tr>
							<td><a href="memberEditForm.do?idx=${member.idx}">수정</a></td>
							<td><a href="javascript:memberDel(${member.idx})">삭제</a></td>
							</tr> --%>


							<tr>
								<td>
<!-- 								<input type="submit" value="수정">
 -->								</td>
								<td>
								<input  class="btn btn-outline-primary" style="float:right" type="button" value="탈퇴" onclick="memberDel(${member.idx})">
								<input  class="btn btn-outline-primary" style="float:right" type="submit" value="수정">
								
								</td>
							</tr> 
						</table>
						</div>
					</form>
				</c:if>
			</c:forEach>
		</c:if>

</div>
      	<script>
       	function moveToBoard(){
       		location.href='temp.do';
       	}
		function memberDel(idx) {
			if (confirm('탈퇴하시겠습니까?')) {
				location.href = 'deleteMember.do?idx=' + idx;
			}

		}
	</script>
	<c:if test="${empty info}">
		<script>
			alert('로그인 하세요');
			location.href = '${pageContext.request.contextPath}/login.jsp';
		</script>
	</c:if>