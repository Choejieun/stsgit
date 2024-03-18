/**********************************************************************
가위 바위 보 게임 (v0.5.0)

[기존 기능]
- 가위바위보 기능
- 유저 가위바위보 입력 시 예외처리 추가
- 유저 가위바위보 입력을 입력창에서 받도록 수정
- 결과 출력 화면을 dw()가 아닌 출력화면용 textarea에 출력하도록 개선
(가위바위보 게임을 단판이 아닌 무한으로 가능해졌음)
v0.5.0 업데이트 내용
- 컴퓨터와 유저의 가위 바위 보 를 이미지로도 표현

todo:
**********************************************************************/
// t1.addEventListener('click', btn_listener);

var p;
var pbox;
var c;
var buttbox;
var textbox;
var v
var score
var imgp
var imgp_on
var imgc
var imgc_on

window.onload = function () {

    pbox = document.getElementById("p_box");
    buttbox = document.getElementById("butt_box");
    textbox = document.getElementById("text_box");
    imgp = document.getElementById("img_p");
    imgc = document.getElementById("img_c");

}

function start() {

    while (true)    {
        p = pbox.value;

        if(p == "가위" || p == "바위" || p == "보"){
            break;
        }
        else {
            alert ("다시 적어주세요")
        }
    }


    c=Math.floor(Math.random()*3)+1;
    
    switch (c) {
        case 1 :
            c = "가위"    ;
        break;
        case 2 :
            c = "바위"    ;
        break;
        case 3 :
            c = "보"    ;
        break;
    }

    switch (c) {
        case "가위" :
            imgc.innerHTML = "<img src = 'c_sc.png'>"
        break;
        case "바위" :
            imgc.innerHTML = "<img src = 'c_ro.png'>"
        break;
        case "보" :
            imgc.innerHTML = "<img src = 'c_pa.png'>"
        break;
    }

    switch (p) {
        case "가위" :
            imgp.innerHTML = "<img src = 'sc.png'>"
        break;
        case "바위" :
            imgp.innerHTML = "<img src = 'ro.png'>"
        break;
        case "보" :
            imgp.innerHTML = "<img src = 'pa.png'>"
        break;

    }

    v = "나 "+p;
    v = v+"\n";
    v = v+"너 "+c;
    v = v+"\n";
    
    switch (p) {
        case "가위" :
            if (c == "가위"){
                score = "비김";
            }
            else if (c == "보"){
                score = "승리";
            }
            else if (c == "바위"){
                score = "패배";
            }
        case "바위" :
            if (c == "가위"){
                score = "승리";
            }
            else if (c == "보"){
                score = "패배";
            }
            else if (c == "바위"){
                score = "비김";
            }
        case "보" :
            if (c == "가위"){
                score = "패배";
            }
            else if (c == "보"){
                score = "비김";
            }
            else if (c == "바위"){
                score = "승리";
            }

    }
    v = v+"\n결과 : "+score;
    textbox.value = v;


}