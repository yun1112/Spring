var members = [];

//멤버 객체 초기화 생성자 함수
function Member(mid, mname, mpw) {
    this.id = mid;
    this.name = mname;
    this.pw = mpw;
}

//공통함수 정의
Member.prototype.toString=function(){
    var makeHtml='';
    makeHtml+='<td>';
    makeHtml+=this.id;
    makeHtml+='</td>';
    makeHtml+='<td>';
    makeHtml+=this.name;
    makeHtml+='</td>';
    makeHtml+='<td>';
    makehtml+=this.pw;
    makeHtml+='</td>';
    return makeHtml;
}

function addMember(member){
    members.push(member);
    setStorage();
    console.log(members);
    displayTable();
}

function createMember(){
    var id=document.getElementById('uid').value;
    var name=document.getElementById('uname').value;
    var pw=document.getElementById('pw').value;

    addMember(new Member(id,name,pw));//멤버 객체 생성 후 추가

    document.getElementById('regForm').reset();

    return false;
}

//회원리스트 출력
function displayTable(){
    var listHtml='';
    listHtml+='<table class="lissTable">';
    listHtml+='<tr>';
    listHtml+='<th>index</th>';
    listHtml+='<th>password</th>';
    listHtml+='<th>id(email)</th>';
    listHtml+='<th>name</th>';
    listHtml+='<th>management</th>';
    listHtml+='</tr>';

    for(let i=0;o<members.length;i++){
        listHtml+='<tr>';
        listHtml+='<td>'+i+'</td>';
        listHtml+='<td>'+members[i].pw+'</td>';
        listHtml+='<td>'+members[i].id+'</td>';
        listHtml+='<td>'+members[i].name+'</td>';
        listHtml+='<td><a href="javascript:editSet('+i+')">edit</a>'
        +'|<a href="javascript:deleteMember('+i+')">delete</a></td>';
        listHtml+='</tr>';
        listHtml+='</table>';

        var listTable=document.getElementById('list');
        listTable.innerHTML=listHtml;
    }

    function editSet(idx){
        document.getElementById('edit').style.display="block";

        document.getElementById('eidt').value=members[idx].id;
        document.getElementById('ename').value=members[idx].name;
        document.getElementById('epw').value=members[idx].pw;
        document.getElementById('idx').value=members[idx].idx;
    }

    function editMember(){
        var id=document.getElementById('eid').value;
        var name=document.getElementById('ename').value;
        var pw=document.getElementById('epw').value;
        var idx=document.getElementById('idx').value;

        members[parseInt(idx)].id=id;
        members[parseInt(idx)].name=name;
        members[parseInt(idx)].pw=pw;

        document.getElementById('editForm').reset();

        displayTable();
        setStorage();

        alert("수정 완료");
        
        document.getElementById('edit').style.display="none";

        return false;
    }

    function deleteMember(idx){
        if(confirm('삭제?')){
            members.splice(idx,1);
            displayTable();
            setStorage();
        }
    }

    function setStorage(){
        localStorage.setItem('members',JSON.stringify(members));
    }

    function initStorage(){
        var storageData=localStorage.getItem('members');

        if(storageData==null){
            localStorage.setItem('members',JSON.stringify(members));
        }else{
            members=JSON.parse(storageData);
        }
    }

    window.onload=function(){
        initStorage();
        displayTable();
        document.getElementById('reForm').onsubmit=createMember;
        document.getElementById('editForm').onsubmit=editMember;
    }
}