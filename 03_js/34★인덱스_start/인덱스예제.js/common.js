/*
    공통함수들을 모아놓음
*/
function dw(str){    // var str; var str = "고양이";
    document.write(str);
}
function br(){
    document.write("<br>");
}
// 가로줄을 출력하는 함수 정의
function hr() {
    document.write("<hr>"); // 가로줄을 나타내는 문자열
}

// trpg 다이스룰
function x(){
   
    switch (your) {
        case 1:
            your = "대성공";
            break;
        case 99:
            your = "대실패";
            break;
        case 100:
            your = "대실패";
            break;
        default:
            // 범위에 따라 "성공" 또는 "기타 결과"로 처리
            if (your >= givedise/2 && your <= givedise) {
                your = "성공";
            } 
            else if (your >= givedise/5 && your <= givedise/2) {
                your = "어려운 성공";
            }                  
            else if (your >= 2 && your <= givedise/5) {
                your = "극단적 성공";
            }                  
            
            else {
                your = "실패";
            }
            break;
    }}