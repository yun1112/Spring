//모든 멤버들의 정보를 담을 배열
var allInformation=new Array();

//객체 초기화 생성자 함수
function Member(id,pwd,name){
    this.id=id;
    this.pwd=pwd;
    this.name=name;
}
/* prototype: 자바의 클래스와 유사한 개념
prototype이라는 빈 객체 안에 들어있는 값을 다른 객체에서 공유해서 사용할 수 있음
*/
//-------------------prototype.toString사용 이유?
Member.prototype.toString=function(){
    var htmlCode='';
    htmlCode+='<td>';
    htmlCode+=this.id;
    htmlCode+='</td>';
    htmlCode+='<td>';
    htmlCode+=this.pwd;
    htmlCode+='</td>';
    htmlCode+='<td>';
    htmlCode+=this.name;
    htmlCode+='</td>';
    return htmlCode;
}

window.onload = function () {
    var d = document.getElementById("del");
    d.onclick = function () {
        confirm('삭제하시겠습니까?');
        d.onclick = null;
    }
};

function popup() {
    var url = "popup2.html";
    var name = "pop up";
    var option = "width=300, height=350, top=100, left=100,location=no";
    var child=window.open(url, name, option);
    // window.open(url, name, option);
    child.moveTo(0,0);
}
var index=0;

var information=new Array();
// var temporary=new Array();
var html='';

//회원 정보를 매개변수로 받아와서 배열에 저장하는 함수
function enrollFunc(information){
    allInformation.push(information);
    console.log(information);
    
    // var temporary=new Array();
    // var id=document.querySelector('#id');/* String형식으로 정보 입력받음 */
    // var pwd=document.querySelector('#pwd');/* String형식으로 정보 입력받음 */
    // var name=document.querySelector('#name');/* String형식으로 정보 입력받음 */

    // var h1s=document.querySelectorAll('input');
    // console.log(h1s);
    // console.log(h1s[0].value);
    console.log('id: '+information.id);
    console.log('password: '+information.value);
    console.log('name: '+information.value);

    showList();//회원 목록 리스트
    // document.body.appendChild(id);
    // var infor='';
    //Text Node 생성
    /* infor += document.createTextNode(h1s[1].value);
    infor += document.createTextNode(h1s[2].value);
    infor += document.createTextNode(h1s[3].value);
    infor+=document.createTextNode(++idx); */
    // <h1>안녕하세요</h1>
    // table_td.appendChild(infor); //<tr></tr>에 <td></td>추가
    

    // document.getElementById('result_id').setAttribute('a',h1s[1].value);
    // document.getElementById('result_id').innerHTML=h1s[1].value;
    // document.getElementById('result_pwd').innerHTML=h1s[2].value;
    // document.getElementById('result_name').innerHTML=h1s[3].value;
    // document.getElementById('idx').innerHTML=++index;

    // temporary.push(h1s[1].value);
    // temporary.push(h1s[2].value);
    // temporary.push(h1s[3].value);
    // information.push(temporary);
    // console.log(information);

    // localStorage.setItem("id",h1s[1].value);
    // localStorage.setItem("pwd",h1s[2].value);
    // localStorage.setItem("name",h1s[3].value);
    // console.log('localStorage:'+localStorage);
    // var id=localStorage.getItem("id");
    // var pwd=localStorage.getItem("pwd");
    // var name=localStorage.getItem("name");
    // alert(pwd);

    

    //그냥 받은 정보를 한번에 출력(x)->등록버튼 한 번 누를 때마다 한 줄씩 출력

    //입력받은 정보를 이차원 배열 형식으로 저장해야됨

    //입력값 유효성 검사 해야됨

    /* body 두번째 테이블에 입력받은 정보들 appendChild로 추가*/
    
    // document.body.getElementById("result_id");
}

//localStorage에 회원정보를 담은 객체 저장하는 함수
function saveInformation(){
    var id=document.querySelector('#id');/* String형식으로 정보 입력받음 */
    var pwd=document.querySelector('#pwd');/* String형식으로 정보 입력받음 */
    var name=document.querySelector('#name');/* String형식으로 정보 입력받음 */

    // var h1s=document.querySelectorAll('input');
    // console.log(h1s);
    // console.log(h1s[0].value);
    console.log('id: '+information.id);
    console.log('password: '+information.value);
    console.log('name: '+information.value);
    
    allInformation.push(new Member(id,pwd,name));
    setStorage();
    this.reset();
    return false;
    
}
function setStorage(){
    //입력받은 모든 회원 정보 저장
    //브라우저를 재시작해도 저장된 정보를 유지하기 위해서 localStorage사용함
    localStorage.setItem("storeInformation",allInformation);
    
    console.log('localStorage:'+localStorage);
    
    var id=localStorage.getItem("id");
    var pwd=localStorage.getItem("pwd");
    var name=localStorage.getItem("name");
    console.log('id: '+localStorage.id);
    console.log('password: '+localStorage.value);
    console.log('name: '+localStorage.value);
    
    //코드 추가

}

function showList(){
    var listHtml = '';
    listHtml += '<table  class="listtable" style="border-collapse:collapse;background-color:cornflowerblue; border:1px solid grey">';
    listHtml += '   <tr style="background-color: mediumslateblue; border:1px solid grey">';
    listHtml += '       <th style=" border:1px solid grey">index</th>';
    listHtml += '       <th style="border:1px solid grey">ID(이메일)</th>';
    listHtml += '       <th style="border:1px solid grey">비밀번호</th>';
    listHtml += '       <th style="border:1px solid grey">이름</th>';
    listHtml += '       <th>관리</th>';
    listHtml += '   </tr>';

    // 배열의 요소를 반복문으로 테그 생성
    for (let i = 0; i < members.length; i++) {
        listHtml += '   <tr style="text-align:center; border:1px solid grey">';
        listHtml += '       <td style="border:1px solid grey">' + i + '</td>';
        listHtml += '       <td style="border:1px solid grey">' + members[i].id + '</td>';
        listHtml += '       <td style="border:1px solid grey">' + members[i].pw + '</td>';
        listHtml += '       <td style="border:1px solid grey">' + members[i].name + '</td>';
        listHtml += '       <td style="border:1px solid grey"> <a style="text-decoration:none;background-color:mediumslateblue;" id "x" href="javascript:editSet('+i+')">수정</a> | <a style="text-decoration:none;background-color:mediumslateblue;" href="javascript:deleteMember('+i+')">삭제</a> </td>';
        listHtml += '   </tr>';
    }

    listHtml += '</table>';
    var listTable = document.getElementById('list');
    
    listTable.innerHTML = listHtml;
     
}


// 리스트에서 선택한 회원의 데이터를 수정 폼에 Set
function editSet(idx){

    // 수정 폼 영역 출력
    document.getElementById('edit').style.display='block';

    // 사용자 입력 데이터 받기, document로 케스팅 후 value 속성 사용
    document.getElementById('eid').value=members[idx].id;
    document.getElementById('ename').value=members[idx].name;
    document.getElementById('epw').value=members[idx].pw;
    document.getElementById('idx').value=idx;

}

// 사용자 입력 데이터를 배열 요소 객체의 속성 값을 변경
function editMember() {
    // 사용자 입력 데이터 받기, document로 케스팅 후 value 속성 사용
    var id = document.getElementById('eid').value;
    var name = document.getElementById('ename').value;
    var pw = document.getElementById('epw').value;
    var idx = document.getElementById('idx').value;
    
    // 배열의 요소 인 Member 객체의 속성값을 변경.
    // setter/getter 메서드 구성해도 좋습니다.
    members[parseInt(idx)].id=id;
    members[parseInt(idx)].name=name;
    members[parseInt(idx)].pw=pw;

    document.getElementById('editForm').reset();

    // 리스트 테이블 갱신
    displayTable();
    // 동기화
    setStorage();


    alert("회원정보가 정상적으로 수정되었습니다.\n");
    // 수정 폼 영역 출력
    document.getElementById('edit').style.display='none';


    return false;

}

// 배열에서 데이터를 삭제
function deleteMember(idx){

    if(confirm('삭제하시겠습니까?')){
        members.splice(idx,1);
        alert("회원정보가 정상적으로 삭제되었습니다.\n");
        // 화면 갱신
        displayTable();
        // 동기화
        setStorage();
    }
}


/*   window.onload = function () {
    //Tag Element 생성
    var h1 = document.createElement('h1'); //<h1></h1>태그 생성
    //Text Node 생성
    var text = document.createTextNode('안녕하세요');
    // <h1>안녕하세요</h1>
    h1.appendChild(text); //<h1></h1>에 text추가
    document.body.appendChild(h1); //body에 <h1>안녕하세요</h1> 추가

    var img = document.createElement('img');
     img.src = "https://thumbnail.10x10.co.kr/webimage/image/basic600/262/B002626948.jpg?cmd=t" +
            "humb&w=500&h=500&fit=true&ws=false";
            img.alt='해당 이미지가 존재하지 않습니다'; 
            img.width=200;//javascript em/%단위 없음, px단위만 존재함
            img.height=100;
            img.setAttribute('src','https://thumbnail.10x10.co.kr/webimage/image/basic600/262/B002626948.jpg?cmd=t');
            img.setAttribute('data-role','test-Image');
            document.body.appendChild(img);
}; */