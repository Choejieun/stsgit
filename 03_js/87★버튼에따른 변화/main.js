var onoff = true;

window.onload = function(){
    btn.addEventListener("click",popup);
}

function popup(){
    var ppup = document.getElementById("pp");

    if(onoff == true){
        // ppup.style.display = "inline";
        ppup.style.width = "500px";
        ppup.style.height = "500px";
        ppup.style.background = "red";
        ppup.style.transition = "width 2s, height 2s, background 2s";

        // ppup.style.transitionProperty = "width, height, color";
        // ppup.style.transitionDuration = "2s";

        return  onoff = false;
    }
    else{
        // ppup.style.display = "none";
        ppup.style.width = "10px";
        ppup.style.height = "10px";
        ppup.style.background = "aqua";  
        ppup.style.transition = "width 2s, height 2s, background 2s";

        // ppup.style.transitionProperty = "width, height, color";
        // ppup.style.transitionDuration = "2s";
        return  onoff = true;
    }
    
}


