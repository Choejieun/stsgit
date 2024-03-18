//레츠고 밸런스 게임
// 1. while 함수 내에서 입력을 받음
// 2. 

var iam = "";
var your = "";
var textbox = "";
var disebox = ""; // 변수명 업데이트
var abox = "";
var mycard = "";
var youcard = "";
var resultString = "";
var end = "";
var dise = "꽝";
var max = "";
var n = "";

window.onload = function () {
    //전체 실행 이후 다시 와서 담아 놓았던 함수를 실행한다.

    textbox = document.getElementById("text_box");
    disebox = document.getElementById("dise_box"); // 변수명 업데이트
    storybox = document.getElementById("story_box"); // 변수명 업데이트

    document.getElementById("dise_box").addEventListener("input", function () {
        if (this.value > 100) {
            this.value = 100;
        }
    });
    // 넘버박스의 숫자를 100으로 제한하는

    abox = document.getElementById("a_box");
    mycard = document.getElementById("my_card");
    youcard = document.getElementById("you_card");
}

function start() {

    while (true) {    // while 무한루프 걸기는 이렇게 하면 됩니다
        // userRpc = prompt("가위,바위,보 중에 하나를 입력하세요:");
        iam = textbox.value;
        if (iam == "도약" || iam == "근접전" || iam == "심리학") {
            break;  // while 무한루프를 빠져나감
        } else {
            alert("초기치 없음");
            return; // 잘못된 입력이면 함수 종료

        }
    }

    switch (iam) {
        case "도약":
            your = Math.floor(Math.random() * 100) + 1;
            dise = your;
            givedise = disebox.value;
            x();
            break;

        case "근접전":
            your = Math.floor(Math.random() * 100) + 1;
            dise = your;
            givedise = disebox.value;
            x();

            break;
        case "심리학":
            your = Math.floor(Math.random() * 100) + 1;
            dise = your;
            givedise = disebox.value;
            x();
            break;
    }


max = "(" + givedise + "/" + givedise / 2 + "/" + givedise / 5 + ")";

resultString = "유저:" + iam + max; // * 주의 * 다시 게임을 할 경우 이 명령줄로 인해 기존 누적된 내용이 초기화가 됨.
resultString = resultString + "\n";
resultString = resultString + "주사위:" + dise;
resultString += "\n";

// dw(winDrawLose);    
// resultString += "결과: " + winDrawLose;
resultString = resultString + "결과: " + your;

// 결과 출력
abox.value = resultString;
//-----------------------------------------------------
end = "가나다";


storybox.value = end;
end = end + "\n";
    

}

// function xx(n){

//     if(n == 1){
//         document.write("가나다");
//     }
// }

// var rpc = x(2);
// document.write(rpc);