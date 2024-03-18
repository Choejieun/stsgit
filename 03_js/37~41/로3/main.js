//1~45 번 숫자 공에서 6개를 뽑아서 그걸로 당첨 여부를 확인하는 복권. 
//보너스 번호도 추가로 뽑고 5개 맞추고 1개 틀렸지만 그 틀린 번호가 이 보너스 번호와 일치하면 2등.
// 그냥 5개만 맞춘 사람은 3등임. 그렇다고 이런거에 빠지진 마시고.. 사지도 마시고..

// 1. 컴퓨터가 1~45 수를 6개 뽑아서 출력		(중복 허용)	
// 1. 내가 한 게임을 구매했다고 가정하고		변수 p1 부터 ~ p6 까지 값 6 개 각각 주기	
// 2. 컴퓨터의 랜덤값도		변수명을 r1 ~ r6 까지 변경해주기	


// 컴퓨터의 6개의 숫자랑 내꺼랑 각각 비교해서(6*6회) 몇개가 일치하는 지 세어 출력하기

var com;
com=Math.floor(Math.random()*45)+1;
var p1 = 1;
var p2 = 2;
var p3 = 3;
var p4 = 4;
var p5 = 5;
var p6 = 6;

var win = 0;

var r1 = Math.floor(Math.random()*45)+1;
var r2 = Math.floor(Math.random()*45)+1;
var r3 = Math.floor(Math.random()*45)+1;
var r4 = Math.floor(Math.random()*45)+1;
var r5 = Math.floor(Math.random()*45)+1;
var r6 = Math.floor(Math.random()*45)+1;

dw(p1+"<br>");
dw(p2+"<br>");
dw(p3+"<br>");
dw(p4+"<br>");
dw(p5+"<br>");
dw(p6+"<br>");

dw("<br>");


dw(r1+"<br>");
dw(r2+"<br>");
dw(r3+"<br>");
dw(r4+"<br>");
dw(r5+"<br>");
dw(r6+"<br>");

//구분
if (p1 == r1){    win = win+1;}
if (p1 == r2){    win = win+1;}
if (p1 == r3){    win = win+1;}
if (p1 == r4){    win = win+1;}
if (p1 == r5){    win = win+1;}
if (p1 == r6){    win = win+1;}


if (p2 == r1){    win = win+1;}
if (p2 == r2){    win = win+1;}
if (p2 == r3){    win = win+1;}
if (p2 == r4){    win = win+1;}
if (p2 == r5){    win = win+1;}
if (p2 == r6){    win = win+1;}

if (p3 == r1){    win = win+1;}
if (p3 == r2){    win = win+1;}
if (p3 == r3){    win = win+1;}
if (p3 == r4){    win = win+1;}
if (p3 == r5){    win = win+1;}
if (p3 == r6){    win = win+1;}

if (p4 == r1){    win = win+1;}
if (p4 == r2){    win = win+1;}
if (p4 == r3){    win = win+1;}
if (p4 == r4){    win = win+1;}
if (p4 == r5){    win = win+1;}
if (p4 == r6){    win = win+1;}


if (p5 == r1){    win = win+1;}
if (p5 == r2){    win = win+1;}
if (p5 == r3){    win = win+1;}
if (p5 == r4){    win = win+1;}
if (p5 == r5){    win = win+1;}
if (p5 == r6){    win = win+1;}

if (p6 == r1){    win = win+1;}
if (p6 == r2){    win = win+1;}
if (p6 == r3){    win = win+1;}
if (p6 == r4){    win = win+1;}
if (p6 == r5){    win = win+1;}
if (p6 == r6){    win = win+1;}


dw("win :"+win);