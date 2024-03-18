function next(){
    // storybox.value = "가나다";

    var dynamictext = gettext();
    if (textint < dynamictext.length)
    // 텍스트 갯수 < length 속성은 해당 문자열에 포함된 문자의 개수
    // 텍스트 갯수 보다 문자열 개수가 적다면 초과할 때 까지 추가한다.
    {
        // storybox의 값을 변경하여 타이핑 효과를 나타내는 함수
        // 각 호출마다 dynamicText의 다음 문자를 storybox에 추가함으로써 타이핑 효과를 구현한다.
        // 문자를 1개씩 추가한다.
        storybox.value += dynamictext.charAt(textint);
                        //이 변수에 저장된 문자를 가져온다(문자열의 번호(1이면 ㅎ, 2면 ㅇ))
        textint++;
        setTimeout(next, 100);
                        //반복 시 1개씩 추가한다. 하여 위쪽 charAt(인덱스) 가 추가된다.
                        //고로 버튼을 활성화 할 때 마다 storybox 에 각 인덱스 번호의 것만이 온다.
        // textint를 증가시켜 다음 번 호출 시에 dynamicText에서 다음 문자를 가져올 수 있도록 한다.

        //만약 dynamicText가 "안녕하세요"이고 currentIndex가 2라면,
        //  dynamicText.charAt(currentIndex)는 문자열에서 세 번째(인덱스 2) 위치에 있는 문자인
        //  "하"를 반환합니다.

// setTimeout 함수는 두 개의 인자를 받습니다.
// 첫 번째 인자: 실행할 함수 (여기서는 next 함수)
// 두 번째 인자: 실행을 지연시킬 시간 (밀리초 단위, 여기서는 100 밀리초)

// 아래 코드는 next 함수를 현재 실행 스택에서 완료된 후에 100 밀리초 뒤에 다시 호출하도록 예약합니다.
// 이를 통해 각 글자를 storybox에 추가할 때 100 밀리초 간격을 두고 실행되어
// 글자가 하나씩 나타나는 타이핑 효과를 구현합니다.
        
    }
}

function gettext(){
    var a = "그러나 그가 원하는 것은 없었다.";
    return  a;
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
}

function gettext(){
    var a = "그러나 그가 원하는 것은 없었다.";
    return  "\n"+a;
}