$(document).ready(function(){
	
	selectData($('#h_qna_seq').val());
	
	function selectData(h_qna_seq){
		$.ajax({
			type:'post',
			data:{h_qna_seq:h_qna_seq},
			url:'qna_list_reply.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				var list = data.list;
				$(list).each(function(index,item){
					var output = '';
					output += '<div class="item" id="'+item.qna_reply_seq+'">';
					output += '  <div class="sub-item">';
					output += '    <h2>답변내용</h2>';
					output += '    <p>' + item.qna_re_content + '</p>';
					output += '    <div>' + item.qna_re_date;
					if($('#mem_id').val() == 'admin'){
						//관리자인경우
						output += ' <input type="button" value="수정" data-num="'+item.qna_reply_seq+'" data-id="'+item.mem_id+'" class="modify-button myButton1">';
						output += ' <input type="button" value="삭제" data-num="'+item.qna_reply_seq+'" data-id="'+item.mem_id+'" class="delete-button myButton1">';
					}
					
					output += '      <hr size="1" noshade>';
					output += '    </div>';
					
					//문서 객체에 추가
					$('#output').append(output);
				});
			},error:function(){
				alert('목록 호출시 네트워크 오류!');
			}
		});
	}
	
	//다음 댓글 보기 버튼 클릭시 데이터 추가
	$('.paging-button input').click(function(){
		var pageNum = currentPage + 1;
		selectData($('#h_qna_seq').val());
	});
	
	//댓글 등록
	$('#re_form').submit(function(event){
		
		if($('#qna_re_content').val()==''){
			alert('내용을 입력하세요!');
			$('#qna_re_content').focus();
			return false;
		}
		
		//전송할 데이터
		var data = $(this).serialize();
		
		
		
		//댓글 전송 및 등록
		$.ajax({
			type:'post',
			data:data,
			url:'qna_write_reply.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == 'logout'){
					alert('로그인해야 작성할 수 있습니다.');
				}else if(data.result == 'success'){
					//폼초기화
					initForm();
					/*
					 *댓글 작성이 성공하면 새로 삽입한 글을 포함해서
					 *첫번째 페이지의 게시글들을 다시 호출함
					 * */
					$('#output').empty();
					selectData($('#h_qna_seq').val());	
				}else{
					alert('등록시 오류 발생!');
				}
			},
			error:function(){
				alert('등록시 네트워크 오류!');
			}
		});
		//기본 이벤트 제거
		event.preventDefault();
	});
	
	//댓글 작성 폼 초기화
	function initForm(){
		$('textarea').val('');
	}
	//댓글 수정 버튼 클릭시 수정폼 노출
	$(document).on('click','.modify-button',function(){
		//댓글 번호
		var num = $(this).attr('data-num');
		//작성자 아이디
		var id = $(this).attr('data-id');
		//댓글 내용
		var content = $('#' + num + ' p').text();
		// 글 번호
		var h_num = $('#h_qna_seq').val();
		
		//댓글 수정폼 UI
		var modifyUI =  '<form id="mre_form">';
			modifyUI += ' <input type="hidden" name="h_qna_seq" id="mh_qna_seq" value="'+h_num+'">';
		    modifyUI += ' <input type="hidden" name="qna_reply_seq" id="mqna_reply_seq" value="'+num+'">';
		    modifyUI += ' <input type="hidden" name="mem_id" id="muser_id" value="'+id+'">';
		    modifyUI += ' <textarea rows="3" cols="50" name="qna_re_content" id="mqna_re_content" class="rep-content">'+content+'</textarea>';
		    modifyUI += ' <div id="mre_second" class="align-right">';
		    modifyUI += '  <input type="submit" value="수정" class="myButton1">';
		    modifyUI += '  <input type="button" value="취소" class="re-reset myButton1">';
		    modifyUI += ' </div>';
		    modifyUI += ' <hr size="1" noshade width="96%">';
		    modifyUI += '</form>';
		    
		//이전에 이미 수정하는 댓글이 있을 경우 수정버튼을 클릭하면
		//숨김 sub-item를 환원시키고 수정폼을 초기화함    
		initModifyForm();
		
		//지금 클릭해서 수정하고자 하는 데이터는 감추기
		$('#'+num+' .sub-item').hide();
		//수정폼을 수정하고자하는 데이터가 있는 div에 노출
		$('#'+num).append(modifyUI);
		
	});
	//수정폼에서 취소 버튼 클릭시 수정폼 초기화
	$(document).on('click','.re-reset',function(){
		initModifyForm();
	});
	
	//댓글 수정 폼 초기화
	function initModifyForm(){
		$('.sub-item').show();
		$('#mre_form').remove();
	}
	
	//댓글 수정
	$(document).on('submit','#mre_form',function(event){
		
		if($('#mqna_re_content').val()==''){
			alert('내용을 입력하세요!');
			$('#mqna_re_content').focus();
			return false;
		}
		
		//폼에 입력한 데이터 반환
		var data = $(this).serialize();
		
		//수정
		$.ajax({
			type:'post',
			data:data,
			url:'qna_update_reply.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == 'logout'){
					alert('로그인해야 수정할 수 있습니다.');
				}else if(data.result == 'success'){
					//변경한 데이터로 UI 갱신
					$('#'+$('#mre_no').val()+' p').text($('#mre_content').val());
					//수정폼 초기화
					initModifyForm();
					
					// 목록 다시 뿌려주기
					$('#output').empty();
					selectData($('#h_qna_seq').val());	
				}else if(data.result == 'wrongAccess'){
					alert('타인의 글은 수정할 수 없습니다.');
				}else{
					alert('수정시 오류 발생!');
				}
			},
			error:function(){
				alert('수정시 네트워크 오류!');
			}
		});
		
		//기본 이벤트 제거
		event.preventDefault();
	});
	
	//댓글 삭제
	$(document).on('click','.delete-button',function(){
		//댓글번호
		var data_num = $(this).attr('data-num');
		//작성자 아이디
		var id = $(this).attr('data-id');
		$.ajax({
			type:'post',
			data:{qna_reply_seq:data_num,mem_id:id},
			url:'qna_delete_reply.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == 'logout'){
					alert('로그인해야 삭제할 수 있습니다.');
				}else if(data.result == 'success'){
					alert('삭제 완료!');
					$('#output').empty();
					selectData($('#h_qna_seq').val());	
				}else if(data.result == 'wrongAccess'){
					alert('타인의 글은 삭제할 수 없습니다.');
				}else{
					alert('삭제시 오류 발생!');
				}
			},
			error:function(){
				alert('삭제시 네트워크 오류!');
			}
		});
		
	});
});