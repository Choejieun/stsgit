var nextbutton = "";
var storybox = "";
var textint = 0;
var love = 10 ;
var hp = 10 ;

function love_m(){
    love = love - 1;
    // dw(love);
}

function love_up(){
    love = love + 1;
    // dw(love);
}

function hp_m(){
    hp = hp - 1;
    // dw(love);
}

function hp_up(){
    hp = hp + 1;
    // dw(love);
}

window.onload = function () {
    //전체 실행 이후 다시 와서 담아 놓았던 함수를 실행한다.

    nextbutton = document.getElementById("next_button"); // 변수명 업데이트
    storybox = document.getElementById("story_box"); // 변수명 업데이트
    lcho = document.getElementById("l_cho"); // 변수명 업데이트
    rcho = document.getElementById("r_cho"); // 변수명 업데이트
}

function next(){
    // storybox.value = "가나다";
    var dynamictext = gettext();

    if (textint < dynamictext.length)
    {
        storybox.value += dynamictext.charAt(textint);
        textint++;
        setTimeout(next, 100);       
    }

    function gettext(){
        var h = "[  건강 : "+hp+"  ]";
        var l = "[  희망 : "+love+"  ]";
        var a = "살점을 먹는 좀비들은 아직 밖에 있다.";
        return  "\n"+h+l+"\n"+a+"\n"+"겨울 탓에 식량은 점점 부족해진다."+"\n"+"선택해야 한다.";
    }

    // 변경 시작: lcho 버튼의 텍스트 변경
    lcho.value = "노약자를 버리기";

    // 변경 종료

    // 변경 시작: rcho 버튼의 텍스트 변경
    rcho.value = "허기 지기";
    // 변경 종료


}



function cho_1_l() { // 노약자 버리기
    var textint_l = 0; // 지역 변수로 변경
    love_m();

    function next_l() {
        var dynamictext_1 = gettext_l_1();

        if (textint_l < dynamictext_1.length) {
            storybox.value += dynamictext_1.charAt(textint_l);
            textint_l++;
            setTimeout(next_l, 100);
        }

        // 변경 시작: lcho 버튼의 텍스트 변경
        lcho.value = "왼쪽 선택 완료";
        // 변경 종료

        // 변경 시작: rcho 버튼의 텍스트 변경
        rcho.value = "오른쪽 선택 기다리는 중...";
        // 변경 종료
    }

    function gettext_l_1() {
        var a = "[  희망 : "+love+"  ]";
        return "\n" + a + "\n" + "가장 조용히 지내던 노약자를" + "\n" + "자던 사이 입을 막고 외딴 건물에 두고 왔다.";
    }

    next_l(); // 수정: next 함수 대신 next_l 함수를 호출
}


// rcho 버튼을 눌렀을 때 호출되는 함수
function cho_1_r() { //허기지기
    var textint_l = 0; // 지역 변수로 변경
    hp_m();
    hp_m();
    hp_m();

    function next_r() {
        var dynamictext_1 = gettext_l_1();

        if (textint_l < dynamictext_1.length) {
            storybox.value += dynamictext_1.charAt(textint_l);
            textint_l++;
            setTimeout(next_r, 100);
        }

        // 변경 시작: lcho 버튼의 텍스트 변경
        lcho.value = "왼쪽 선택 기다리는 중...";
        // 변경 종료

        // 변경 시작: rcho 버튼의 텍스트 변경
        rcho.value = "오른쪽 선택 완료";
        // 변경 종료
    }

    function gettext_l_1() {
        var a = "[  건강 : "+hp+"  ]";
        return "\n" + a + "\n" + "굶주린 배를 애써 무시하며 지냈다." + "\n" + "건강과는 멀어졌지만 우린 괜찮다.";
    }

    next_r(); // 수정: next 함수 대신 next_l 함수를 호출
}