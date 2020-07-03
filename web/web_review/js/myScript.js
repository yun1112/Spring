

function Member(img,id,name){
    this.img=img;
    this.id=id;
    this.name=name;
}

// var members=[];

var allMembers=[];
var idx=0;
function clickBtn(){
    // var src="pic/god.png";

    var src="pic/png1/img"+(++idx)+".png";
    // alert(src);
    var id=document.getElementById('inputId').value;
// alert(id);
    var name=document.getElementById('inputName').value;
    member=new Member(src,id,name);
    // member=new Member(src,'아이디','이름');
    allMembers.push(member);
    
    var setMember=JSON.stringify(allMembers);
    localStorage.setItem('allMembers',setMember);
    document.getElementById('div1');
    
    var htmlCode='';
    htmlCode+='<img class="images" onclick="clickImg(id)" style="width:50px" id="img'+idx+'" src="'+src+'"><br>';
    htmlCode+='<h1 id="id1">'+member.id+'</h1>';
    htmlCode+='<h1 id="name1">'+member.name+'</h1>';

    document.getElementById('div1').innerHTML+=htmlCode;

    document.getElementById('inputId').value='';
    document.getElementById('inputName').value='';
}

function clickDelBtn(){
    var id=document.getElementById('inputId').value;
    var name=document.getElementById('inputName').value;

    var getMember=localStorage.getItem('allMembers');
    // JSON.parse(getMember);
    for(var i=0;i<allMembers.length;i++){
        if((id==allMembers[i].id)&&(name==allMembers[i].name)){
            allMembers.pop(member);
            // allMembers.pop(this);
        }

    }
}

function clickImg(id){//id: 이미지명
    // alert("you clicked this image");
    // var img=document.getElementsByClassName('images').id;
    var contentToprint='';
    contentToprint+='id: '+id+'\n';

    // alert("name:"+name);
    for(var i=0;i<allMembers.length;i++){
        console.log(allMembers[i]);
        var str=allMembers[i].img;
        str=str.slice(9,13);
        if(id==str){
            contentToprint+='name: '+allMembers[i].name;
        }
        // console.log(str);
        console.log(str);
        // console.log(str.slice(9,4));
        // console.log(slice);
    }
    alert(contentToprint);
    // alert(id);
}


/* window.onload()=function(){

} */