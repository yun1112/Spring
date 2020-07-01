<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include TEST</title>
<style>
*{
margin:0;
padding:0;
text-align:center;
}
body{

}
input{

}
#div1{
/* float:left;
 *//* position:absolute;
 */}
#btns{
/* float:right;
 *//* position:absolute;
 */}

</style>
</head>
<body>

<h1>Registration Form</h1>
<hr>

<form id="content" action="requestRegistration.jsp" method="post">

<div id="div1">
아이디<input type="text" name="username" required><br>
비밀번호<input type="password" name="password" required><br>
비밀번호 확인<input type="password" name="passwordCheck" required><br>
<label>직업</label>
<select name="job">
<option value="시스템엔지니어">시스템엔지니어</option>
<option value="프로그래머">프로그래머</option>
<option value="디자이너">디자이너</option>
</select>
<br>
<label>관심사항</label>
JAVA<input type="checkbox" name="like" value="JAVA">
JSP<input type="checkbox" name="like" value="JSP">
HTML5<input type="checkbox" name="like" value="HTML5">
CSS3<input type="checkbox" name="like" value="CSS3"><br>

</div>
<div id="btns">
<input type="submit" value="제출"><input type="reset"></div>
</form>


<%-- 

<div id="wrap">
<%@ include file="include/news.jsp"%>
<%@ include file="include/news2.jsp"%> 
</div>
--%>

</body>
</html>
