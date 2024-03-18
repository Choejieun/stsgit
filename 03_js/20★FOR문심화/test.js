for ( var i = 1 ; i <= 10 ; i= i+1  ){
    // i는 10보다 작다. 반복마다 1을 추가
   
    for (var k = 1 ; k <= i; k= k+1){
        document.write("&nbsp;");
    }

    // 조건 : k가 i보다 작다. 반복마다 1을 추가

   
    for (var j = 10 ; j >= i; j= j-1){
        document.write("★");
    }
    // 조건 : j가 i보다 크다. 반복마다 1을 제거

    document.write("<br>");
}

// for(var i=1; i<=10; i=i+1){

//     for(var k=1; k <= i - 1; k=k+1){
//         document.write("&nbsp;");
//     }

//     for(var j=10; j>=i; j=j-1){
//         document.write("*");
//     }
//     document.write("<br>");
// }

