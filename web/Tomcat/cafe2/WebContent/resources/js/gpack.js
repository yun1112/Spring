$(document).ready(function(){
	 $('#gpWrite_form').submit(function(){
		 if($('#norr_form').val() == '추천구분'){
	    	  $('#norr-err').text('');
	    	  $('#norr-err').append('추천구분을 선택주세요.');
	    	  
	    	  return false;
	   	  	} else {
	 	    	  $('#norr-err').text('');
	   	  	}
	      if($('#gpa_upload').val() == ''){
	    	  $('#gpa_upload-err').text('');
	    	  $('#gpa_upload-err').append('메인 사진을 채워주세요.');
	    	  
	    	  return false;
    	  	} else {
	 	    	  $('#gpa_upload-err').text('');
	   	  	}
	      if($('#gpa_title').val() == ''){
	    	  $('#gpa_title-err').text('');
	    	  $('#gpa_title-err').append('제목은 필수 항목입니다.');
	    	  
	    	  return false;
      		} else {
	 	    	  $('#gpa_title-err').text('');
	   	  	}
	      if($('#gpa_term').val() == ''){
	    	  $('#gpa_term-err').text('');
	    	  $('#gpa_term-err').append('이 부분은 필수 항목입니다.');
	    	  
	    	  return false;
      		} else {
	 	    	  $('#gpa_term-err').text('');
	   	  	}
	      if($('#gpa_money').val() == ''){
	    	  $('#gpa_money-err').text('');
	    	  $('#gpa_money-err').append('이 부분은 필수 항목입니다.');
	    	  
	    	  return false;
	      	} else {
 	    	  $('#gpa_money-err').text('');
	   	  	}
	      if($('#cnt1').val() == ''){
	    	  $('#cnt1-err').text('');
	    	  $('#cnt1-err').append('이 내용는 필수 항목입니다.');
	    	  
	    	  return false;
    	    } else {
 	    	  $('#cnt1-err').text('');
	   	  	}
	      if($('#cnt2').val() == ''){
	    	  $('#cnt2-err').text('');
	    	  $('#cnt2-err').append('이 내용는 필수 항목입니다.');
	    	  
	    	  return false;
	        } else {
 	    	  $('#cnt2-err').text('');
	   	  	}
	      if($('#cnt3').val() == ''){
	    	  $('#cnt3-err').text('');
	    	  $('#cnt3-err').append('이 내용는 필수 항목입니다.');
	    	  
	    	  return false;
	        } else {
 	    	  $('#cnt3-err').text('');
	   	  	}
	      if($('#gpa_dmload').val() == ''){
	    	  $('#gpa_dmload-err').text('');
	    	  $('#gpa_dmload-err').append('상세 상단 사진은 필수 항목입니다.');
	    	  
	    	  return false;
	      	} else {
 	    	  $('#gpa_dmload-err').text('');
	   	  	}
	      if($('#gpa_dpload').val() == ''){
	    	  $('#gpa_dpload-err').text('');
	    	  $('#gpa_dpload-err').append('상세 중단 사진은 필수 항목입니다.');
	    	  
	    	  return false;
	    	} else {
 	    	  $('#gpa_dpload-err').text('');
	   	  	}
	      if($('#gpa_rtload').val() == ''){
	    	  $('#gpa_rtload-err').text('');
	    	  $('#gpa_rtload-err').append('상세 하부 사진은 필수 항목입니다.');
	    	  
	    	  return false;
	        } else {
 	    	  $('#gpa_rtload-err').text('');
	   	  	}
	      
	 });    
	 
	 $('#gpModify_form').submit(function(){
		 if($('#gpa_title').val() == ''){
	    	  $('#gpa_title-err').text('');
	    	  $('#gpa_title-err').append('제목은 필수 항목입니다.');

	    	  return false;
	        } else {
	    	  $('#gpa_title-err').text('');
	   	  	}
	      if($('#gpa_term').val() == ''){
	    	  $('#gpa_term-err').text('');
	    	  $('#gpa_term-err').append('이 부분은 필수 항목입니다.');
	    	  return false;
	        } else {
	    	  $('#gpa_term-err').text('');
	   	  	}
	      if($('#gpa_money').val() == ''){
	    	  $('#gpa_money-err').text('');
	    	  $('#gpa_money-err').append('이 부분은 필수 항목입니다.');
	    	  return false;
	        } else {
	    	  $('#gpa_money-err').text('');
	   	  	}
	      if($('#cnt1').val() == ''){
	    	  $('#cnt1-err').text('');
	    	  $('#cnt1-err').append('이 내용는 필수 항목입니다.');
	    	  return false;
	        } else {
	    	  $('#cnt1-err').text('');
	   	  	}
	      if($('#cnt2').val() == ''){
	    	  $('#cnt2-err').text('');
	    	  $('#cnt2-err').append('이 내용는 필수 항목입니다.');
	    	  return false;
	        } else {
	    	  $('#cnt2-err').text('');
	   	  	}
	      if($('#cnt3').val() == ''){
	    	  $('#cnt3-err').text('');
	    	  $('#cnt3-err').append('이 내용는 필수 항목입니다.');
	    	  return false;
	        } else {
	    	  $('#cnt3-err').text('');
	   	  	}
	      
	 });
	 
});
	   
