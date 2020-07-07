<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="imgUpload">
	<section id="wrapper">

		<article>
			<p id="status">ㅁㅁㅁㅁㅁ</p>
			<p>
				<input id="src" name="img" type="file">
			</p>
			<div style="border:1px solid #DDD;width: 90px;height:120px;" id="holder"></div>
		</article>
		<script>
			var upload = document.getElementsByTagName('input')[0], holder = document
					.getElementById('holder'), state = document
					.getElementById('status');

			if (typeof window.FileReader === 'undefined') {
				state.className = '이미지 업로드 실패';
			} else {
				state.className = 'success';
				state.innerHTML = '이미지를 업로드하세요';
				
			}
			

			upload.onchange = function(e) {
				e.preventDefault();

				var file = upload.files[0], reader = new FileReader();
				reader.onload = function(event) {
					var img = new Image();
					img.src = event.target.result;
					//state.innerHTML+=document.getElementById('holder').style.height;
					//state.innerHTML+=img.width;
					var width=document.getElementById('holder').style.width;
					var height=document.getElementById('holder').style.height;
					// note: no onload required since we've got the dataurl...I think! :)
					if (img.width > parseInt(width)) {
						img.width = parseInt(width);
						//state.innerHTML+='<br>'+img.width;
					}
					if (img.height > parseInt(height)) { // holder width
						img.height = parseInt(height);
					}
					
					
					holder.innerHTML = '';
					holder.appendChild(img);
					//state.innerHTML+='파일url: '+img.src;
				document.getElementById("result").innerHTML+="<img src='"+img.src+"'>";//이미지 url 이대로 저장해도 됨
				};
				reader.readAsDataURL(file);
				
				return false;
			};
			/* state.innerHTML+=img.src; */
		</script>
		
		<div id="result"></div>
		</section>
		</div>
		
