<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
    <link
    href="https://fonts.googleapis.com/css2?family=Yeon+Sung&display=swap"
    rel="stylesheet">
<!-- <srcipt src="externalJS.js"></srcipt> -->
<style>
    /*   #btn{
background-color:black;
color:white;
} */
    * {
        margin: 0;
        padding: 0;
        font-family: 'Yeon Sung', cursive;
    }
    .button {
        background-color: cornflowerblue;
        /* Green */
        border: none;
        color: white;
        padding: 5px 8px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 1em;
        margin: 4px 2px;
        transition-duration: 0.4s;
        cursor: pointer;
    }

    .button2 {
        background-color: cornflowerblue;
        color: black;
        /* border: 2px solid mediumblue; */
        border: none;
    }

    .button2:hover {
        background-color: white;
        color: cornflowerblue;
        /* border:2px solid mediumslateblue */
        border: none;
    }
    /* #tb { */
    table{
        text-align: center;
        width: 90%;
        border: 1px solid black;
        border-collapse: collapse;
        font-size: 1.1em;
        /* 테이블 테두리 한줄(테두리선 겹쳐서 표현) */
    }
    #tb > tr,
    #tt > td {
        border: 1px solid black;
    }

    #tb2 {
        text-align: center;
        font-size: 1.1em;
        border:none;
    }
    #tb2 > input {
        margin: 100px;
        /* padding: 10px; */
    }

    #menu {
        font-size: 1.5em;
        font-weight: bold;
    }
    #d {
        padding: 30px;
        position: relative;
        /* background-color:white; */
    }
    #tdiv1 {
        /* left:100px; */
        padding: 0 50px;
        /* position:absolute; */
    }
    #tdiv2 {
        /* left:100px; */
        padding: 0 50px;
        /* position:absolute; */
    }
    #div1 {
        padding: 0 50px;
    }
    #div2 {
        padding: 0 50px;
    }
    body {
        background-image: url("");
    }
    #mgr {
        padding: 10px;
    }
    #enroll {
        padding: 10px;

    }
    input {
        margin: 5px;
    }
</style>
</head>
<body>
    <div id="d">
        <h1 id="mgr">Login</h1><hr><br>

        <div id="div1">
            <p id="menu">로그인</p><br>
            <form action="../../loginResult.jsp">
            <div id="tdiv1">
                <table id="tb2">
                <!-- <label>이름</label> <input type="text" id="uname"
					placeholder="이름" required></td> -->
                    <tr>
                        <td>아이디(이메일)</td><td><input name="id" type="text" required></td>
                        </tr>
                        <tr>
                        <tr><td>비밀번호</td><td><input name="pwd" type="password" required></td></tr>
                        <td>이름</td>
                        <td><input name="name" type="text" required></td>
                        </tr>
           <!--              <td><input colspan="2"
                            type="submit"
                            value="로그인"></td> -->
            			<td><input 
                            type="submit"
                            value="로그인"></td>    
                        <td><input onclick="goToReg()" 
                            type="submit"
                            value="회원가입"></td>
                    </tr>
                        
                        
                        
                    </tr>
                </table></form>
            </div>
        </div><br><hr>
</div>
</body>
<script src="../js/logincheck.js"></script>
<script>
function goToReg(){
	location.href="reg.jsp";
}
</script>
</html>