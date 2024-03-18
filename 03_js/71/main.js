var id_a;
var pw_a;

window.onload = function(){
    
    id_a = document.getElementById("id");
    pw_a = document.getElementById("pw");

}

function login(){
    alert ("ID : "+id_a.value+" PW : "+pw_a.value);
}