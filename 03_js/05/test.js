

var random;
random = Math.floor(Math.random() * 100) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.




for (var i = 1 ; i <= random ; i = i+1){
    document.write("<img src='maddog.jpg'>"+i+"개");
}

document.write("<br>")

var cat = 1;

for (i = 1; i <= 5 ; i = i + 1 ){
  document.write("고양이"+i+"<br>");
}
// 여기서 사용된 i 값은 여기서만 유효