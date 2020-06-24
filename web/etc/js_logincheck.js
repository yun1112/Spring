/*
사용자 입력 폼 casting
기본적인 유효성

<form>casting
onsubmit
*/
form = document.getElementById('loginForm');
form.setAttribute('action','http://www.naver.com');


//onsubmit
form.onsubmit = function () {
    var uid = docment.getElementById('id');
    var upwd = docment.getElementById('pwd');

    //사용자 아이디 유효성 검사
    //아이디를 입력하지 않았을 경우
    if (uid.value != null || uid.value.length < 1) {
        alert('아이디를 입력해주세요');
        return false;
    }
    //비밀번호를 입력하지 않았을 경우
    if (upwd.value != null || upwd.value.length < 1) {
        alert('비밀번호를 입력해주세요');
        return false;
    }

};