var time_ta = 10;
var time_onoff = true;

function br() {
    document.write("<br><br>");
}

window.onload = function () {

    var time_c;
    var time_d;
    time_c = document.getElementById("time_c");
    time_d = document.getElementById("time_d");
    setInterval(t, 1000);  // 타이머 시작(1000밀리초=1초 마다 x 함수를 실행한다. 반복실행문)
    setInterval(ta, 1000);  // 타이머 시작(1000밀리초=1초 마다 x 함수를 실행한다. 반복실행문)



}

function t() {
    var now = new Date();
    var m = now.getMonth() + 1;

    var a =
        now.getFullYear() + "년 " +
        m + "월 " +
        now.getDate() + "일 " +
        now.getHours() + "시 " +
        now.getMinutes() + "분 " +
        now.getSeconds() + "초 " +
        now.getMilliseconds() + "밀리초 ";

        time_d.innerHTML = a;
}
function ta() {
    if(time_onoff == true){
    if (time_ta == 1) {
        time_onoff = false;
        time_ta = "불좀 꺼줄래?";
        time_c.innerHTML = time_ta;
    }
    else {
        time_ta = time_ta - 1;
        time_c.innerHTML = time_ta;
    }

}
}
// ㅇㅇㅇㅇ년 ㅇㅇ월 ㅇㅇ일 ㅇㅇ시 ㅇㅇ분 ㅇㅇ초 ㅇㅇㅇ 밀리초			


