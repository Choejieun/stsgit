// var sum = 0 ;
// var i = 1 ;
// while ( i <= 10 ) {
//   sum = sum + i;
//   i++;
// }
// alert ( sum ); // 55


// 문15	반복문	while	참고탭 참고	prompt 함수를 이용하여 숫자 값을 하나 입력 받기	
// 				숫자가 100이 아니면 숫자를 화면에 (팝업말고) 출력	
// 				숫자가 100이면 while 반복문을 끝내도록 처리	


// window.onload = function(){
// // body 로딩 후 구현 입력


//     var t = document.getElementById("a");
//     // css(id) 가져오기 

//     var s ="";
    
    
//     while(true){
    
//         s = prompt("값을 입력하세요 :");
//         if(s==100){
//             break;
//             // 반복문 종료
//              }else{
//             t.innerHTML = "마지막 입력값:"+s+"<br>";
//             }
//     }

// }

window.onload = function () {

        var t = document.getElementById("a");
    
        var s = "";

        while(true){
        // 거짓은 아예 실행하지 않고 넘긴다
            s = prompt("천사소녀00");
            if(s == "네티"){

                break;

            } else{
                t.innerHTML = "마지막 입력값:"+s+"<br>";
                // var t 변수가 지정된 id a 태그 사이에 넣는다.

                }
        }
}

