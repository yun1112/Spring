<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<title>썸네일</title>
</head>
<body>
	<input type="file" id="image" accept="image/*"
		onchange="setThumbnail(event)">
	<div width size="50px" id="imageContainer"></div>
	<script>
		function setThumbnail(event) {
			var reader = new FileReader();
			reader.onload = function(event) {
				var img = document.createElement("img");
				img.src = event.target.result;
				//state.innerHTML+=document.getElementById('holder').style.height;
				//state.innerHTML+=img.width;
				var width=document.getElementById('img').style.width;
				var height=document.getElementById('img').style.height;
				// note: no onload required since we've got the dataurl...I think! :)
				if (img.width > parseInt(width)) {
					img.width = parseInt(width);
					//state.innerHTML+='<br>'+img.width;
				}
				if (img.height > parseInt(height)) { // holder width
					img.height = parseInt(height);
				}
				
				
				img.setAttribute("src", event.target.result);
				document.querySelector("div#imageContainer").appendChild(img);
				
				
			};
			reader.readAsDataURL(event.target.files[0]);
		}
	</script>
	
	
	<div id="result"></div>
</body>
</html>

