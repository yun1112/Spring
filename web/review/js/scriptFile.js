// <!-- <img src="pic/images/1.1.PNG"> -->

function showMenu(){
    var htmlCode='';
    var id="img";
    // var idx=0;
    htmlCode+='<table id="menuTable">';
    for(var i=1;i<3;i++){
        htmlCode+='<tr>';
        for(var j=1;j<8;j++){
           id="img"+i+'_'+j;
            // console.log(id+i+'_'+j);
            console.log(id);
            htmlCode+='<td>';
            // htmlCode+='<img id="'+id+i+'_'+j+'" onclick="clickMenu()" style="width:15px" src="images/'+i+'.'+j+'.PNG">';
            htmlCode+='<img id="'+id+'" onclick="clickMenu(id)" style="width:20px" src="images/'+i+'.'+j+'.PNG">';
            htmlCode+='</td>';
        }
        htmlCode+='</tr>';
    }
    htmlCode+='</table>';
    // alert(htmlCode);

    //이미지 아이디: img1_1~img2_7

    // div에 지정한 html코드 추가
    document.getElementById('div1').innerHTML=htmlCode;
}

var OrderedProducts=[];
var priceOfProducts=[];
function makeRandPrice(){
    for(i=0;i<14;i++){
        var rand=Math.round(Math.random()*1000)+3000;
        priceOfProducts.push(rand);
    }
}
function Product(id,src,price,cnt){//cnt
    this.id=id;
    this.src=src;
    this.price=price;
    this.cnt=cnt;
}
var idx=0;
// var cnt=0;

var product;
function clickMenu(id){
    var htmlCode='';
    // alert(id);
    var src=document.getElementById(id).src;
    // alert(src);
/*     htmlCode+='<table>';
    htmlCode+='<tr>';
    htmlCode+='<td>';
    htmlCode+='<td>';
    htmlCode+='</tr>';
    htmlCode+='</table>'; */
    htmlCode+='<img id="'+id+'" onclick="deleteMenu(id,product)" style="width:20px" src="'+src+'">';
    document.getElementById('div2').innerHTML+=htmlCode;
// alert('aaaa:'+id);

    product=new Product(id,src,priceOfProducts[idx++],1);
    OrderedProducts.push(product);

    var setData=JSON.stringify(OrderedProducts);//문자열로 변환
    // localStorage.setItem('OrderedProducts',setData);//localStorage에 저장
    localStorage.setItem(id,setData);//localStorage에 저장
    // alert(src);
}

function deleteMenu(id,product){
    var htmlCode='';
    // alert(id);
    var src=document.getElementById(id).src;
    // var getData=localStorage.getItem('src');
    // getData=JSON.parse('src');

    for(var i=0;i<OrderedProducts.length;i++){
        if(id==OrderedProducts[i].id)
            OrderedProducts.pop(this);//이부분@@@@@@@@@
    }

    // localStorage.removeItem('OrderedProducts');
    localStorage.removeItem(id);
    for(var i=0;i<OrderedProducts.length;i++){
        var src2=OrderedProducts[i].src;
        htmlCode+='<img id="'+id+'" onclick="deleteMenu(id)" style="width:20px" src="'+src2+'">';
    }
    document.getElementById('div2').innerHTML+=htmlCode;
    window.location.reload();
    //페이지 새로고침
}
function saveLocalStorage(){

}
function showCart(){

}

window.onload=function(){
    showMenu();
    makeRandPrice();
}