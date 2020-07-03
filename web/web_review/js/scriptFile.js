// var id;
function showMenu() {
    var cnt = 0;
    var htmlCode = '';
    var id = "img";
    htmlCode += '<table>';
    for (var i = 1; i <= 2; i++) {
        htmlCode += '<tr>';
        for (var j = 1; j <= 7; j++) {
            htmlCode += '<td><a href="#" >';
            htmlCode += '<img onclick="clickMenu(' + id + (++cnt) + ')" id="' + id + (cnt) + '" class="menuItems" src="pic/images/' + i + '.' + j + '.PNG">';
            htmlCode += '</a></td>';
            // if(cnt<3)
            // alert(htmlCode);
            // id=i+i*j-1;
        }
        htmlCode += '</tr>';
    }

    htmlCode += '<table>';
    document.getElementById('div1').innerHTML += htmlCode;
    // return htmlCode;
}

function clickMenu(id) { //id매개변수 전달 제대로 되는지 확인
    var src = document.getElementById('id').src;
    // var src=document.getElementsByClassName('menuItems').src;
    // var src=document.getElementById(id).src;
    alert(id);
}

function showCart() {
    var htmlCode = '';
    htmlCode += '<table>';
    for (var i = 1; i <= 2; i++) {
        htmlCode += '<tr>';
        for (var j = 1; j <= 7; j++) {
            htmlCode += '<td>';
            htmlCode += '<img class="menuItems" src="pic/images/' + i + '.' + j + '.PNG">';
            htmlCode += '</td>';
        }
        htmlCode += '</tr>';
    }

    htmlCode += '<table>';
    document.getElementById('div2').innerHTML += htmlCode;
}

/* ------------------------------------------객체초기화 */
//제품 초기화 생성자 함수
function Product(no, name, price, option, count) { //제품번호, 제품명, 가격, 옵션(토핑), 개수
    this.no = no;
    this.name = name;
    this.price = price;
    this.option = option; //배열로 선언할 경우도 생각해볼 것@@@@@@@@@
    this.count = count;
}

var allProducts = []; //판매 제품 전체를 담을 배열
var cart = []; //장바구니
var option1 = 1; //옵션 비트연산하기위해서 2제곱값줌@@@@@@@@@@@
var option2 = 2;
var option3 = 4;

//제품 배열
var kindOfProducts=['greantea','strawberry','cookie','yogurt','cream','vanilla','blueberry','mango','coffee','melon']
var priceOfProducts=[3000,3200,3800,4000,4200,3000,5000,3800,3200,5000];
//제품 데이터 초기화 함수
function initData() {
    for(var i=0;i<10;i++){
        allProducts.push(new Product(i+1,kindOfProducts[i],priceOfProducts[i],0,0));
    }
    console.log(allProducts);
   /*  allProducts.push(new Product(1, 'greentea', 3000, 0, 0));
    allProducts.push(new Product(2, 'strawberry', 3200, 0, 0));
    allProducts.push(new Product(3, 'cookie', 3800, 0, 0));
    allProducts.push(new Product(4, 'yogurt', 4000, 0, 0));
    allProducts.push(new Product(5, 'cream', 4200, 0, 0));
    allProducts.push(new Product(6, 'vanilla', 3000, 0, 0));
    allProducts.push(new Product(7, 'blueberry', 5000, 0, 0));
    allProducts.push(new Product(8, 'mango', 3800, 0, 0));
    allProducts.push(new Product(9, 'coffee', 3200, 0, 0));
    allProducts.push(new Product(10, 'melon', 5000, 0, 0)); */
}

//장바구니에 해당 제품 추가하는 함수
function addToCart(no, option) {
    var find = false; //장바구니에 추가하고자 하는 제품과 일치 여부 판단하기 위한 불리안값 find
    if ((no == cart[i].no) && (option = cart[i].option)) { //장바구니에 등록된 제품번호와 옵션이 일치할 경우
        cart[i].count++; //장바구니에 담겨진 개수 추가
        find = true; //해당 제품 찾을 경우 불리안값 true로 변경
        break;
    }
    if(!find){//찾고자 하는 제품을 못 찾았을 경우
        //function Product(no, name, price, option, count)
        //제품 개수 증가시키지 않고 그냥 장바구니에 추가
        cart.push(new Product(no,allProducts[no-1],name,allProducts[no-1].price,option,allProducts[no-1].count));
    }
    saveLocalStorage();//localStorage에 해당 장바구니 정보 저장
}
/* ------------------------------------------localStorage관련 */
//localStroage에 장바구니 정보 저장하는 함수
function saveLocalStorage(){
    var setData=JSON.stringify(cart);
    localStorage.setItem("cart",setData);
}
//localStroage에서 장바구니 정보 불러오는 함수
function loadLocalStorage(){
    var getData=localStorage.getItem("cart");
    cart=JSON.parse(getData);
}

window.onload = function () {
    showMenu();
    showCart();
}