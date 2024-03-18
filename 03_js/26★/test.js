// 문22	고양이 나이, 고양이 종류, 고양이 이름 이 3가지를 각각 변수를 만드시고, 
// 다 합친 변수도 하나 만드시고, 합친걸 팝업으로 출력하세요	
// 		고양이 나이
// 		고양이 종류
// 		고양이 이름
// 	메모에 js 코드를 첨부하세요


function xx1(){

var random;
random=Math.floor(Math.random()*10)+1;

var random2;
random2=Math.floor(Math.random()*3)+1;


var k1
var k2

switch (random2) {
    case 1 :
        k2 = "코숏";
    break;
    case 2 :
        k2 = "페르시안";
    break;
    case 3 :
        k2 = "호랑이";
    break;

}



var a = random;
var k = k2;
var n = prompt("고양이 이름을 지어주세요")

var all = a+"세<br>"+"종류 : "+k+"<br>이름 :"+n

document.write(all)

}

xx1();


//함수

//함수선언(만들기)
function xx(){

    var a = "2살";
    var t = "시고르자브종";
    var n = "야옹이";

    var s = a + t + n;


    alert(s);

}

//함수  사용하기. 실행한다. 호출한다.

xx();

