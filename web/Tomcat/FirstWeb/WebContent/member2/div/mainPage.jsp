<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
*{
margin:0;
padding:0;
}
#header{
margin:10px 150px;
}
li{
list-style:none;
float:left;
margin:10px 25px;
font-size:1.5em;
}
a{
text-decoration:none;
}
#member{
float:right;
margin:50px 0;
/* border-top:1px solid grey; */
}
</style>
</head>
<body>
<div id="content">
<div id="header">
<ul>
<li><a href="../pages/page1.jsp">page1</a></li>
<li><a href="../pages/page2.jsp">page2</a></li>
<li><a href="../pages/page3.jsp">page3</a></li>
<li><a href="../pages/page4.jsp">page5</a></li>
<li><a href="../pages/page5.jsp">page6</a></li>
</ul>
</div>
<div id="member">
<ul>
<li><a href="reg.jsp">sign up</a></li>
<li><a href="login/sessionLogin.jsp">log in</a></li>
</ul>
</div>

</div>
</body>
</html>