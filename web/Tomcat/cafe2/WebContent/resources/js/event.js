$(document).ready(function(){
	$('.pop-up').hide();
	$('#event_form').submit(function(){
		if($('#event_subject').val() == '') {
			alert('제목을 입력하세요!');
			$('#subjectcheck').focus();
			return false;
		}
		if($('#event_date1').val() == ''){
			alert('이벤트 시작일을 입력하세요');
			$('#event_date1').focus();
			return false;
		}
		if($('#event_date2').val() == ''){
			alert('이벤트 종료일을 입력하세요');
			$('#event_date1').focus();
			return false;
		}
		if($('#event_content1').val().length == 0){
			alert('내용을 입력하세요');
			$('#event_content1').focus();
			return false;
		}
		if($('#event_uploadfile1').val() == ''){
			alert('메인이미지를 넣으세요');
			return false;
		}
	});
	$('#addcontent1').click(function(){
		$('.hiddencontent2').show();
	});
	$('#addcontent2').click(function(){
		$('.hiddencontent3').show();
	});
	$('#addcontent3').click(function(){
		$('.hiddencontent4').show();
	});
	$('#addcontent4').click(function(){
		$('.hiddencontent5').show();
	});
	$('#addfile1').click(function(){
		$('.hiddenfile2').show();
	});
	$('#addfile2').click(function(){
		$('.hiddenfile3').show();
	});
	$('#addfile3').click(function(){
		$('.hiddenfile4').show();
	});
	$('#addfile4').click(function(){
		$('.hiddenfile5').show();
	});
	$('#popup').click(function(){
		window.open("event_explain.do", "도움말창", "width=500, height=400, toolbar=no, menubar=no, scrollbars=no, resizable=yes");
	});
});