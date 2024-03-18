//     var t = document.getElementById("a");
//     // css(id) 가져오기 

//     var s ="";
    
    
//     while(true){
    
//         s = prompt("값을 입력하세요 :");

            // 진실이 오기 전까지 위 내용을 반복
//         if(s==100){
//             break;
//             // 반복문 종료
//              }else{
//             t.innerHTML = "마지막 입력값:"+s+"<br>";
//             }
//     }

// }


var n=0;

while(true){

    n=n+1;
    // n에게 1을 반복부여, 거짓일 경우 반복하여 거짓 결과 출력

    if(n>10){
        break;
    }
    else{
        document.write(n);
    }

}
