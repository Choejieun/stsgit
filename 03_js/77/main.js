var id_a;
var pw_a;
var ok_id;
var ok_pw;
var hionlogin


ok_id = 1234;
ok_pw = 1234;

window.onload = function () {

    id_a = document.getElementById("id");
    pw_a = document.getElementById("pw");
    hionlogin = document.getElementById("hi");

}

function login() {
    
    var id_v = id_a.value;
    var pw_v = pw_a.value;

    if (id_v == ok_id && pw_v == ok_pw) {
        alert("로그인 성공");
        hionlogin.innerHTML = id_v+"회원님 반갑습니다.";
    }
    else {
        alert("로그인 실패")
    }

    // alert ("ID : "+id_a.value+" PW : "+pw_a.value);
}