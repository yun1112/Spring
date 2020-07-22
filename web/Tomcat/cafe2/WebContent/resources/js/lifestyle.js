//글 검사
$(document).ready(function(){
   $('#write_form').submit(function(){
      if($('#lif_realtitle').val() == '') {
         alert('큰제목을 입력하세요!');
         $('#lif_realtitle').focus();
         return false;
      }
      if($('#lif_title').val() == ''){
         alert('제목을 입력하세요');
         $('#lif_title').focus();
         return false;
      }
      if($('#lif_retitle').val() == ''){
         alert('부제목을 입력하세요');
         $('#lif_retitle').focus();
         return false;
      }
      if($('#topload').val() == ''){
          alert('파일을 넣어주세요');
          $('#topload').focus();
          return false;
       }
      
   });
});

//수정 체크modify_form
$(document).ready(function(){
	   $('#modify_form').submit(function(){
	      if($('#lif_realtitle').val() == '') {
	         alert('큰제목을 입력하세요!');
	         $('#lif_realtitle').focus();
	         return false;
	      }
	      if($('#lif_title').val() == ''){
	         alert('제목을 입력하세요');
	         $('#lif_title').focus();
	         return false;
	      }
	      if($('#lif_retitle').val() == ''){
	         alert('부제목을 입력하세요');
	         $('#lif_retitle').focus();
	         return false;
	      }
	      if($('#topload').val() == ''){
	          alert('파일을 넣어주세요');
	          $('#topload').focus();
	          return false;
	       }
	      
	   });
	});
