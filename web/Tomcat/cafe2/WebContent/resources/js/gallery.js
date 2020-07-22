$(document).ready(function(){
	$('.pop-up').hide();
	$('#gallery_form, #update_form').submit(function(){
		if($('#h_gallery_subject').val() == '') {
			alert('제목을 입력하세요!');
			$('#h_gallery_subject').focus();
			return false;
		}
		if($('#h_gallery_content').val().length == 0){
			alert('내용을 입력하세요');
			$('#h_gallery_content').focus();
			return false;
		}
		if($('#upload1').val() == ''){
			alert('메인이미지를 넣으세요');
			$('#upload1').focus();
			return false;
		}
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
	$('#addfile5').click(function(){
		$('.hiddenfile6').show();
	});
	$('#addfile6').click(function(){
		$('.hiddenfile7').show();
	});
	$('#addfile7').click(function(){
		$('.hiddenfile8').show();
	});
	$('#addfile8').click(function(){
		$('.hiddenfile9').show();
	});
	$('#addfile9').click(function(){
		$('.hiddenfile10').show();
	});
	$('#addfile10').click(function(){
		$('.hiddenfile11').show();
	});
	$('#addfile11').click(function(){
		$('.hiddenfile12').show();
	});
	$('#popup').click(function(){
		window.open("gallery_explain.do", "도움말창", "width=500, height=400, toolbar=no, menubar=no, scrollbars=no, resizable=yes");
	});
});