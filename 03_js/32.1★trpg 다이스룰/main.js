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
var s_a = "";

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


    iam = textbox.value;


    your = Math.floor(Math.random() * 100) + 1;
    dise = your;
    givedise = disebox.value;
    x();

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
    
    if (your == "실패") {
        end = "설득에 실패하였다.";
    }
    else if (your == "성공")
    {  end = "성공했다.";
}

 
    // end = "가나다";


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