$(document).ready(function(){
	
	$('#modify_form').submit(function() {
		//  유효성 체크
		if($('#din_title').val() == '') {
			alert('가게명을 입력하세요!');
			$('#din_title').focus();
			return false;
		}
		if($('#din_subtitle').val() == '') {
			alert('가게소개글을 입력해주세요');
			$('#din_subtitle').focus();
			return false;
		}
		if($('#din_loc').val() == '') {
			alert('위치를 입력해주세요');
			$('#din_loc').focus();
			return false;
		}
		if($('#din_time1').val() == '') {
			alert('점심시간을 입력해주세요');
			$('#din_time1').focus();
			return false;
		}
		if($('#din_time2').val() == '') {
			alert('저녁시간을 입력해주세요');
			$('#din_time2').focus();
			return false;
		}
		if($('#din_phone').val() == '') {
			alert('전화번호를 입력해주세요!');
			$('#din_phone').focus();
			return false;
		}
		if($('#din_seat').val() == '') {
			alert('좌석수를 입력해주세요!');
			$('#din_seat').focus();
			return false;
		}
		});	
});

$(document).ready(function(){
	
	$('#write_form').submit(function() {
		//  유효성 체크
		if($('#din_title').val() == '') {
			alert('가게명을 입력하세요!');
			$('#din_title').focus();
			return false;
		}
		if($('#din_subtitle').val() == '') {
			alert('가게소개글을 입력해주세요');
			$('#din_subtitle').focus();
			return false;
		}
		if($('#din_loc').val() == '') {
			alert('위치를 입력해주세요');
			$('#din_loc').focus();
			return false;
		}
		if($('#din_time1').val() == '') {
			alert('점심시간을 입력해주세요');
			$('#din_time1').focus();
			return false;
		}
		if($('#din_time2').val() == '') {
			alert('저녁시간을 입력해주세요');
			$('#din_time2').focus();
			return false;
		}
		if($('#din_phone').val() == '') {
			alert('전화번호를 입력해주세요!');
			$('#din_phone').focus();
			return false;
		}
		if($('#din_seat').val() == '') {
			alert('좌석수를 입력해주세요!');
			$('#din_seat').focus();
			return false;
		}
		
		if($('#upload1').val() == '') {
			alert('가게사진을 입력해주세요!');
			$('#upload1').focus();
			return false;
		}
		if($('#upload2').val() == '') {
			alert('가게부가설명사진을 입력해주세요!');
			$('#upload2').focus();
			return false;
		}
		if($('#upload3').val() == '') {
			alert('메뉴파일을 입력해주세요!');
			$('#upload3').focus();
			return false;
		}
		if($('#upload4').val() == '') {
			alert('사진을 입력해주세요!');
			$('#upload4').focus();
			return false;
		}
		if($('#upload5').val() == '') {
			alert('사진을 입력해주세요!');
			$('#upload5').focus();
			return false;
		}
		if($('#upload6').val() == '') {
			alert('사진을 입력해주세요!');
			$('#upload6').focus();
			return false;
		}
		if($('#upload7').val() == '') {
			alert('사진을 입력해주세요!');
			$('#upload7').focus();
			return false;
		}
		if($('#upload8').val() == '') {
			alert('사진을 입력해주세요!');
			$('#upload8').focus();
			return false;
		}
		if($('#upload9').val() == '') {
			alert('사진을 입력해주세요!');
			$('#upload9').focus();
			return false;
		}
		if($('#upload10').val() == '') {
			alert('사진을 입력해주세요!');
			$('#upload10').focus();
			return false;
		}
		if($('#upload11').val() == '') {
			alert('사진을 입력해주세요!');
			$('#upload11').focus();
			return false;
		}
		
		
		
		});	
});