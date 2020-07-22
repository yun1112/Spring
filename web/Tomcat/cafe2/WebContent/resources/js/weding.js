//웨딩 글작성  유효성 검사
$(document).ready(function(){
   $('#write_form').submit(function(){
      if($('#wed_realtitle').val() == '') {
         alert('큰제목을 입력하세요!');
         $('#wed_realtitle').focus();
         return false;
      }
      if($('#wed_title').val() == ''){
         alert('제목을 입력하세요');
         $('#wed_title').focus();
         return false;
      }
      if($('#topload').val() == ''){
          alert('파일을 넣어주세요');
          $('#topload').focus();
          return false;
       }
      
   });
});

//웨딩 수정 유효성 검사modify_form
$(document).ready(function(){
	   $('#modify_form').submit(function(){
	      if($('#wed_realtitle').val() == '') {
	         alert('큰제목을 입력하세요!');
	         $('#wed_realtitle').focus();
	         return false;
	      }
	      if($('#wed_title').val() == ''){
	         alert('제목을 입력하세요');
	         $('#wed_title').focus();
	         return false;
	      }
	      if($('#topload').val() == ''){
	          alert('파일을 넣어주세요');
	          $('#topload').focus();
	          return false;
	       }
	      
	   });
	});