// %=	- >> ex. y %= x 는 y = y % x 를 의미 함

for (var i = 1 ; i <= 10 ; i=i+1){
    
    if ( i % 2 == 1){
        document.write(i+"은 홀입니다.");
    }
    else if (i % 2 != 1){
        
        document.write(i+"은 짝입니다.");
    }

    document.write("<br>");
}