<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="../js/sessionCheck.js"></script>
    <link rel="stylesheet" href="../css/popup.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="CountInit()">
<span id="counter"></span>
<input type="button" value="연장" onclick="CountReset()">

<div id="popup" style="display:none"></div>
<div style="width:300px;height:170px" align="center"><br></div>
<span id="ncounter"></span> 후 자동로그아웃됩니다<br><br>
<input type="button" value="연장하기" onclick="countReset(), closeWindow()">
<input type="button" value="로그아웃" onclick="logout()">
</body>
</html>