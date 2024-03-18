
var random;
random = Math.floor(Math.random() * 6) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.

document.write(random);

document.write("<br>");
document.write("<br>");



switch (random) {
    case 1 :
        document.write("대실패");
        //...
        //...
        break;
    case 2 :
        document.write(2);
        //...
        //...   
        break;     
    case 3 :
    case 4 :
        document.write("3이나 4임");
        //...   
        //...   
        break;     
    case 5 :
        document.write(5);
        //...
        //...   
        break;
    default :
        document.write("디폴트 처리");
        //...
        //...         
        break;
}


var player = 2;


switch (player) {
    case "가위": a = 1;
        break;
    case "바위": a = 2;
        break;
    case "보":  a = 3;
        break;
}

document.write(player);