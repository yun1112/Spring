$(document).ready(function(){
	$('#qna_form').submit(function(){
		if($('#h_qna_subject').val() == '') {
			alert('제목을 입력하세요!');
			$('#h_qna_subject').focus();
			return false;
		}
		if($('#h_qna_content').val() == ''){
			alert('내용을 입력하세요');
			$('#h_qna_content').focus();
			return false;
		}
		if($('#h_qna_lastname').val() == ''){
			alert('성을 입력하세요');
			$('#h_qna_lastname').focus();
			return false;
		}
		if($('#h_qna_firstname').val().length == 0){
			alert('이름을 입력하세요');
			$('#h_qna_firstname').focus();
			return false;
		}
		if($('#h_qna_email').val() == ''){
			alert('이메일을 입력하세요');
			$('#h_qna_email').focus();
			return false;
		}
		if($('#h_qna_phone').val() == ''){
			alert('전화번호를 입력하세요');
			$('#h_qna_phone').focus();
			return false;
		}
		if($('#chkBox').is(':checked') == false) {
			alert('약관동의를 체크해주세요.');
			return false;
		}
	});
});