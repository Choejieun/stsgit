//js
var but;
var imgCat;
var onoff = true;

window.onload = function(){
    but = document.getElementById("but");
    imgCat = document.getElementById("cat");
    btn.addEventListener("click",popup);
}

function popup(){
    if(onoff == true){
        imgCat.style.display = "inline";
        onoff = false;
    }
    else{
        imgCat.style.display = "none";
        onoff = true;
    }
    
}


