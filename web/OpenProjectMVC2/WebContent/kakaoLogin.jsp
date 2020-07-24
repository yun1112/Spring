<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=ege"/>
<meta nmae="viewport" content="user-scalable=no,inital-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,width=device-width">
<title>:: Custom Login Demo - Kakao JavaScript SDK ::</title>
<script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript">
    document.addEventListener("DOMContentLoaded", function() {

        // @details 카카오톡 Developer API 사이트에서 발급받은 JavaScript Key
        Kakao.init('99700abe71de0064c0d0c5702931b834')

        // @breif 카카오 로그인 버튼을 생성합니다.
        Kakao.Auth.createLoginButton({
              container : "#kakao-login-btn"
            , success : function( authObj ) {

                // console.log( authObj );

                Kakao.API.request({
                      url : "/v2/user/me"
                    , success : function( res ) {

                        // console.log( res );
						//location.href("index.jsp");
						
						<%-- location.href='<%=request.getContextPath()%>/'; --%>
						
                        // @breif 아이디
                        document.getElementById( "kakaoIdentity" ).innerHTML = res.id;
						alert("id:"+res.id);
					/* 	alert("properties:"+properties);
                        document.getElementById( "properties" ).innerHTML = res.properties; */
						alert(JSON.stringify(res.properties));
                        document.getElementById( "properties2" ).innerHTML = JSON.stringify(res.properties);
						
                        // @breif 닉네임
                        document.getElementById( "kakaoNickName" ).innerHTML = res.properties.nickname;
                        
                        
                        var kakaoNickname = res.properties.nickname;    //카카오톡 닉네임을 변수에 저장
                        var kakaoEmail = res.properties.kaccount_email;    //카카오톡 이메일을 변수에 저장함
               			alert("kakanoNickname:"+kakaoNickname);//확인됨
                        
                        //카카오톡의 닉네임과,mail을 url에 담아 같이 페이지를 이동한다.
                        window.location.replace("http://" + window.location.hostname + ( (location.port==""||location.port==undefined)?"":":" + location.port) + "/OpenProjectMVC2/?kakaoNickname="+kakaoNickname+"&kakaoEmail="+kakaoEmail);
/*                         http://localhost:8080/OpenProjectMVC2/member/memberLogin.do
 *///
//                        // @breif 프로필 이미지
//                        document.getElementById( "kakaoProfileImg" ).src = res.properties.profile_image;
//
//                        // @breif 썸네일 이미지
//                        document.getElementById( "kakaoThumbnailImg" ).src = res.properties.thumbnail_image;

                    }, fail : function( error ) {
                        alert( JSON.stringify( error ) );
                    }
                });
            }
            , fail : function( error ) {
                alert( JSON.stringify( error ));
            }
        });
    });
</script>
</head>
<body>
    <div>카카오 아이디 : <span id="kakaoIdentity"></span></div>
    <div>닉네임 : <span id="kakaoNickName"></span></div>
    <div>속성 : <span id="properties2"></span></div>
<!--
    <div>프로필 이미지 : <img id="kakaoProfileImg" src=""/></div>
    <div>썸네일 이미지 : <img id="kakaoThumbnailImg" src=""/></div>
-->
    <br/>
    <a id="kakao-login-btn"></a>
</body>
</html> 