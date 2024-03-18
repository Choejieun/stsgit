var getid;
var getpw;
var getpwck;
var getname; 
var getemail;
var getbthy;
var getbthm;
var getbthd; 
var getsex;
var gethp010;
var gethpmid;
var gethpbut;
var getsigupsubmit;

var id;
var pw;
var pwck;
var uname; 
var email;
var bthy;
var bthm;
var bthd; 
var sex;
var hp010;
var hpmid;
var hpbut;
var sigupsubmit;

window.onload = function() {
    getid = document.getElementById("get_id");
    getpw = document.getElementById("get_pw");
    getpwck = document.getElementById("get_pw_ck");
    getname = document.getElementById("get_name");
    getemail = document.getElementById("get_email");
    getbthy = document.getElementById("get_bth_yyyy");
    getbthm = document.getElementById("get_bth_m");
    getbthd = document.getElementById("get_bth_d");
    getsex = document.getElementsByTagName("sex");
    gethp010 = document.getElementById("get_hp_010");
    gethpmid = document.getElementById("get_hp_mid");
    gethpbut = document.getElementById("get_hp_but");
    getsigupsubmit = document.getElementById("get_sigup_submit");
}

function check(){

id= getid.value;
pw= getpw.value;
pwck= getpwck.value;
uname= getname.value;
email= getemail.value;

if(checkId() && checkPw() && checkPw_re()&&checkUserName()&&checkEmail()){
    alert("회원가입 완료");
} else {
    alert("회원가입 실패");
}
}

    function checkId(){
    if ( id.length>=4 && id.length<=12  ){ 
        console.log("ok id");       
        return true;
    }  else {
        console.log("no id");
        return false;
    }}

    function checkPw(){
        if (pw.length >= 4 && pw.length <= 12){
            console.log("ok pw");
            return true;
        } else {
            console.log("no pw");
            return false;
        }
    }
    
    function checkPw_ck(){
        if (pwck.length >= 4 && pwck.length <= 12){
            console.log("ok pw");
            return true;
        } else {
            console.log("no pw");
            return false;
        }
    }

    function checkUserName(){
        if (uname.length >= 4 && uname.length <= 12){
            console.log("ok pw");
            return true;
        } else {
            console.log("no pw");
            return false;
        }
    }

    
    function checkEmail(){
        if (email.length >= 4 && email.length <= 12){
            console.log("ok pw");
            return true;
        } else {
            console.log("no pw");
            return false;
        }
    }