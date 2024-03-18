
while (true) {    // while 무한루프 걸기는 이렇게 하면 됩니다
    iam = prompt("도약,근접전,심리학");
    // iam = textbox.value;
    if (iam == "도약" || iam == "근접전" || iam == "심리학") {
        break;  // while 무한루프를 빠져나감
    } else {
        alert("초기치 없음");
        location.reload();
        break;

    }
}

// trpg 다이스룰

// case "근접전":
//     your = Math.floor(Math.random() * 100) + 1;
//     dise = your;
//     givedise = disebox.value;
//     x();


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

    max = "("+givedise+"/"+givedise/2+"/"+givedise/5+")";

    resultString = "유저:" + iam +max; // * 주의 * 다시 게임을 할 경우 이 명령줄로 인해 기존 누적된 내용이 초기화가 됨.
    resultString = resultString + "\n";
    resultString = resultString + "주사위:" + dise;
    resultString += "\n";
    // 위 max 코드로 아래 코드 생략

    // switch (iam) {
    //     case "도약":
    //         max = "(50/25/10)"
    //         break;
    //     case "근접전":
    //         max = "("+givedise+"/"+givedise/2+"/"+givedise/5+")";
    //         break;
    //     case "심리학":
    //         max = "(20/10/4)"
    //         break;
    // }



    document.getElementById("dise_box").addEventListener("input", function() {
        if (this.value > 100) {
            this.value = 100;
        }
    });
    // 넘버박스의 숫자를 100으로 제한하는 코드