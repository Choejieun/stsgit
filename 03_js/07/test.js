

var random;
random = Math.floor(Math.random() * 100) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.




for (var i = 1 ; i <= random ; i = i+1){

    if(i == 7){
        document.write("<img id=gold src='maddog.jpg'>"+i+"개");
    }
    else{
        document.write("<img src='maddog.jpg'>"+i+"개");
    }
    
}

document.write("<br>")

var cat = 1;

for (i = 1; i <= 5 ; i = i + 1 ){
  document.write("고양이"+i+"<br>");
}
// 여기서 사용된 i 값은 여기서만 유효



// if(random>3){
//     document.write("무사히 다리를 건넜다."+"<br>"+hps);
// } //  참일 경우 스크립트 박스, 거짓일 경우 무시하고 내려감



// 하드버전

// var random=Math.floor(Math.random()*100)+1;
// for( var i=1;  i <= random;  i=i+1  ) {
//     if ( i == 7 ) { //황금고양이 만들기
//         document.write("<img id='goldcat' src='cat.jpg' width='100px' height='100px'>");
//         document.write(i);
//         var gold_cat_img = document.getElementById("goldcat");
//         gold_cat_img.style.borderColor = "yellow";
//         gold_cat_img.style.borderStyle = "solid";
//         gold_cat_img.style.borderWidth = "10px";
//     } else {
//         document.write("<img src='cat.jpg' width='100px' height='100px'>");
//         document.write(i);
//     }
// }
