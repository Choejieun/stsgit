//1~45 번 숫자 공에서 6개를 뽑아서 그걸로 당첨 여부를 확인하는 복권. 
//보너스 번호도 추가로 뽑고 5개 맞추고 1개 틀렸지만 그 틀린 번호가 이 보너스 번호와 일치하면 2등.
// 그냥 5개만 맞춘 사람은 3등임. 그렇다고 이런거에 빠지진 마시고.. 사지도 마시고..

// 1. 컴퓨터가 1~45 수를 6개 뽑아서 출력		(중복 허용)	
// 1. 내가 한 게임을 구매했다고 가정하고		변수 p1 부터 ~ p6 까지 값 6 개 각각 주기	
// 2. 컴퓨터의 랜덤값도		변수명을 r[0] ~ r[5] 까지 변경해주기	


// 컴퓨터의 6개의 숫자랑 내꺼랑 각각 비교해서(6*6회) 몇개가 일치하는 지 세어 출력하기
// 컴퓨터의 두번째 번호가 첫번째 번호와 같을 경우 다시 뽑도록 하기


var com;
com = Math.floor(Math.random() * 45) + 1;
var p = new Array(5);
p = [0, 0, 0, 0, 0, 0];

p[0] = 1;
p[1] = 2;
p[2] = 3;
p[3] = 4;
p[4] = 5;
p[5] = 6;

var r = new Array(5);
r = [0, 0, 0, 0, 0, 0];

var bonus = 0;

var win = 0;
var outp = new Array(5);
var outp_win = 0;



r[0] = Math.floor(Math.random() * 45) + 1;
dw(r[0] + "<br>");

while (true) {
    r[1] = Math.floor(Math.random() * 45) + 1;
    if (r[0] != r[1]) {
        dw(r[1] + "<br>");
        break;
    }
}

while (true) {
    r[2] = Math.floor(Math.random() * 45) + 1;

    if (r[0] != r[2] && r[1] != r[2]) {
        dw(r[2] + "<br>");
        break;
    }
}

while (true) {
    r[3] = Math.floor(Math.random() * 45) + 1;

    if (r[0] != r[3] && r[1] != r[3] && r[2] != r[3]) {
        dw(r[3] + "<br>");
        break;
    }
}
while (true) {
    r[4] = Math.floor(Math.random() * 45) + 1;

    if (r[0] != r[4] && r[1] != r[4] && r[2] != r[4] && r[3] != r[4]) {
        dw(r[4] + "<br>");
        break;
    }
}
while (true) {
    r[5] = Math.floor(Math.random() * 45) + 1;

    if (r[0] != r[5] && r[1] != r[5] && r[2] != r[5] && r[3] != r[5] && r[4] != r[5]) {
        dw(r[5] + "<br>");
        break;
    }
}

//보너스
while (true) {
    bonus  = Math.floor(Math.random() * 45) + 1;

    if (r[0] != bonus && r[1] != bonus && r[2] != bonus && r[3] != bonus && r[4] != bonus && r[5] != bonus) {
        dw("보너스 : "+bonus + "<br>");
        break;
    }
}

////    앞선 번호들과 비교하여 중복된 번호가 나온 경우 다시 번호를 뽑게 하기
//      (그렇게 해서 나온 번호도 또 검사를 계속 해야함)




dw("<br>");

dw(p[0] + "<br>");
dw(p[1] + "<br>");
dw(p[2] + "<br>");
dw(p[3] + "<br>");
dw(p[4] + "<br>");
dw(p[5] + "<br>");








//구분

// 1
for (var i = 0; i <= 5; i = i + 1) {
    for (var j = 0; j <= 5; j = j + 1) {
        if (p[i] == r[j]) { win = win + 1; }
        else{ outp.push = p[i] }
    }
}
dw("win :" + win + "<dr>");


switch (win) {
    case 3:
        br()
        dw("5등입니다.");
        break;
    case 4:
        br()
        dw("4등입니다.");
        break;
    case 5:
        for (var i = 0; i <= 5; i = i + 1) {
                if (outp[i] == bonus) { outp_win = outp_win + 1; }
        }
        if (outp_win >= 0){
            br()
            dw("2등입니다.");
        }
        else{
        br()
        dw("3등입니다.");
    }
        break;
    case 6:
        br()
        dw("1등입니다.");
        break;
    default:
        br()
        dw("꽝입니다.");
        break;
}




