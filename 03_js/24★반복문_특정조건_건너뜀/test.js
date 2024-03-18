// 문24
// 1 ~ 10 랜덤값 준비		
// 반복문을 1~10 까지 10번 반복하기
// 반복 도중 반복용 변수 값( var i ) 이 랜덤값과 일치하는 경우 해당 반복 회차를 건너뛰고 다음 회차 진행.	
// 일치 하지 않은 경우 i 값을 출력하기


var random;
random=Math.floor(Math.random()*10)+1;

for ( var i = 1 ; i <= 10 ; i = i +1){

        if ( i == random){
            continue;
            // 브레이크와 동일 효과, 반복문을 건너뛰는 경우에 사용
        }

    document.write(i);    

}