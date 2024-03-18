//js
var but;
var ppup
var onoff = false;

window.onload = function(){
    but = document.getElementById("butn");
    ppup = document.getElementById("pp");
    btn.addEventListener("click",popup);
}

function popup(){
    if(onoff == true){
        ppup.style.display = "inline";
        onoff = false;
        
    }
    else{
        ppup.style.display = "none";
        onoff = true;
    }
    
}


