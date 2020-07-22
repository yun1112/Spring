$(document).ready(function() {

	
	// 이메일 뒤에 주소 선택 / 활성화, 비활성화
	$('#email_select2').change(function() {
		if($('#email_select2').val() == '1') {
			$('#email4').val('');
			$('#email4').prop('readonly', false);
		}else if($('#email_select2').val() == ''){
			$('#email4').val('');
			$('#email4').prop('readonly', true);
		}else{
			$('#email4').val($('#email_select2').val());
			$('#email4').prop('readonly', true);
		}
	});

$('#reservation_form').submit(function() {
	
	// 이메일 합쳐서 보냄
	var din_res_email = $('#email3').val() + '@' + $('#email4').val();
	$('#din_res_email').val(din_res_email);
	

	// 회원가입 유효성 체크
	if($('#din_res_date').val() == '') {
		alert('날짜를 입력하세요!');
		$('#din_res_date').focus();
		return false;
	}
	if($('#din_res_time').val() == '') {
		alert('예약시간을 선택해 주세요');
		$('#din_res_time').focus();
		return false;
	}
	if($('#din_res_person').val() == '') {
		alert('2명에서 30명 사이의 인원을 입력하세요');
		$('#din_res_persion').focus();
		return false;
	}
	if($('#din_res_name').val() == '') {
		alert('예약자 성함을 입력해 주세요');
		$('#birth2').focus();
		return false;
	}
	if($('#din_res_phone').val() == '') {
		alert('연락처를 입력하세요');
		$('#birth3').focus();
		return false;
	}
	if($('#email3').val() == '') {
		alert('이메일을 입력하세요!');
		$('#email3').focus();
		return false;
	}
	if($('#email4').val() == '') {
		alert('이메일을 입력하세요!');
		$('#email4').focus();
		return false;
	}

    if(!$('#agree').is(':checked')){
        alert('약관동의하세요!');
        $('#email4').focus();
        return false;
        }
    
	});	
	$('#din_res_require').on('keyup', function() {

    if($(this).val().length > 50) {
        $(this).val($(this).val().substring(0, 50));
    }
    
  //input 태그에서 영문,한글만 입력함
    function onlyKor(obj) {
    	$(obj).keyup(function(){
    		$(this).val($(this).val().replace(/[^ㄱ-ㅎ가-힣]/g,""));
    	}); 
    }
 // input 태그에서 숫자만 입력함
    function onlyNumber(obj) {
        $(obj).keyup(function(){
             $(this).val($(this).val().replace(/[^0-9]/g,""));
        }); 
    }

    // input 태그에서 영문,숫자만 입력함
    function onlyEngOrNum(obj) {
        $(obj).keyup(function(){
             $(this).val($(this).val().replace(/[^A-z|0-9]/g,""));
        }); 
    }

    //input 태그에서 영문,한글만 입력함
    function onlyEngOrKor(obj) {
    	$(obj).keyup(function(){
    		$(this).val($(this).val().replace(/[^ㄱ-ㅎ가-힣a-zA-Z]/g,""));
    	}); 
    }
    

    
   
   
  
	
      
	});
	
	
}); 
