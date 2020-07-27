<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	String kakaoNickname=(String)request.getParameter("kakaoNickname");
	String id=(String)request.getParameter("id");
	
	%>
<html lang="ko">
<meta charset="utf-8">
<!-- ---------------------------------------------------------------------------------------------------------07/24 추가-->
 <script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<!-- ---------------------------------------------------------------------------------------------------------07/24 추가-->
<script>

</script>
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
<c:if test="${empty info}">
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

<form id="regForm" action="memberReg.do" method="post" enctype="multipart/form-data">
    <div class="container">
        <div id="contentForm">
        <div class="input-group input-group-sm" role="group" aria-label="...">
        <table class="table table-striped table-bordered">
					<th width="30%">아이디</th>
					<td width="70%">
					<c:if test="${not empty id}">
					<input type="text" name="uid" id="uid" value="${id}" readonly>
					</c:if>
					<c:if test="${empty id}">
					<input type="text" name="uid" id="uid" required>
					</c:if>
						 <span  id="checkmsg"></span>
						 <input type="checkbox" name="idchk" id="idchk">
					 </td>
				</tr>
				<tr>
					<th width="30%">비밀번호</th>
					<td width="70%"> <input type="password" name="upw" required> </td>
				</tr>
				<tr>
					<th width="30%">이름</th>
					<td width="70%"> <input type="text" name="uname" required> </td>
				</tr>
				<tr>
					<th width="30%">닉네임</th>
					<td width="70%">
					<c:if test="${not empty kakaoNickname}">
					<input type="text" name="nickname" id="nickname" value="${kakaoNickname}" readonly>
					</c:if>
					<c:if test="${empty kakaoNickname}">
					<input type="text" name="nickname" id="nickname" required>
					</c:if>
					</td>
				</tr>
				<tr>
					<th width="30%">이메일</th>
					<td width="70%"> <input type="email" name="email" required> </td>
				</tr>
				<tr>
					<th width="30%">연락처</th>
					<td width="70%"> <input type="text" name="contact" required> </td>
				</tr>
				<hr>
				<tr><th width="30%">주소</th>
				<td width="70%"><hr>
		
		<input type="text" name="postcode" id="postcode" placeholder="우편번호">
<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" name="address" id="address" placeholder="주소"><br>
<input type="text" name="detailAddress" id="detailAddress" placeholder="상세주소"><br>
<input type="text" name="extraAddress" id="extraAddress" placeholder="참고항목"><hr></td></tr>
				<!-- <tr>
					<td>주소</td>
					<td> <input type="text" name="address" required> </td>
				</tr> -->
				<tr>
					<th width="30%">사진</th>
					<td width="70%"> <input type="file" name="photo"> </td>
				</tr>
				<tr>
					<td></td>
					<td> 
						<input type="submit" name="회원가입">
						<input type="reset">
					</td>
				</tr>
			</table>
			</div>
			</div>
			</div>
		</form>
</c:if>

<script>
	
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
	
	
</script>









