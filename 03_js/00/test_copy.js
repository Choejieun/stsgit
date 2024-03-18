var a = 1;

if(a>0)
{
    document.write(
        "0 보다 크다<br>"
    );
};

// 구분



var hp = 10;
var hps = "현재체력"+hp;

var random;
random = Math.floor(Math.random() * 6) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.

document.write(random);

document.write("<br>")
document.write("<br>")



if(random>3){
    document.write("무사히 다리를 건넜다."+"<br>"+hps);
} //  참일 경우 스크립트 박스, 거짓일 경우 무시하고 내려감

else{
    var zerohp = hp-3;
    var hp = zerohp;
    var hps = "현재체력"+zerohp;
    
    document.write("다리를 건너기 실패해서 다쳤다."+"<br>"+hps)
}

document.write("<br>")
document.write("<br>")

if(random>2){
    document.write("무사히 다리를 건넜다."+"<br>"+hps);
} //  참일 경우 스크립트 박스, 거짓일 경우 무시하고 내려감

else if(random==1){
    var zerohp = hp-0;
    var hp = zerohp;
    var hps = "현재체력"+zerohp;
    
    document.write("완벽하게 다리를 건너뛰었다."+"<br>"+hps)
}

else if(random<4){
    var zerohp = hp-8;
    var hp = zerohp;
    var hps = "현재체력"+zerohp;

    if(hp < 0){
        var hps = "현재체력"+zerohp;
    
    document.write("사망하였다."+"<br>"+hps)
    }
    
    document.write("다리를 건너기 실패해서 다쳤다."+"<br>"+hps)
}



document.write("<br>")
