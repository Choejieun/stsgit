// var sum = 0;
// for ( i = 1 ; i <= 10 ; i++ ) {
//   sum = sum + i ;
// }
// document.write ( sum+"<br>" ) ; // 55

var cat = 1;

for (i = 1; i <= 5 ; i = i + 1 ){
  document.write("고양이"+i+"<br>");
}
// 여기서 사용된 i 값은 여기서만 유효


var hpfull = 10;
var d = 5;
var hp = hpfull-d;

document.write ( "현재 체력 "+hp+"<br>" ) ;
document.write ( "최대 체력 "+hpfull+"<br>" ) ;

document.write ( "포션을 사용하여 체력을 회복하였다<br>" ) ;

for (i2 = hp; i2 < hpfull ; i2 = i2 + 1 ){
  hp = hp+1;
}
document.write ( "현재 체력 "+hp+"<br>" ) ;


for (var j1 = 1 ; j1 <= 3 ; j1 = j1+1) {
  document.write ("음료수 "+j1);

    for(var j2 = 1 ; j2 < 3 ; j2 = j2+1)
    {
      document.write("개★ ");
    }

}

 
// for ( 초기값 ; 조건 ; 증가식 ) {
//     실행할 명령
//   }