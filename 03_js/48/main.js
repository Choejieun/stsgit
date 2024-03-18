function cyphers(){
    this.name = "";
    this.power = "";
    this.age =0;
    }

var tomas = new cyphers()

tomas.name = "토마스 스티븐슨";
tomas.power= "얼음 능력자";
tomas.age= Math.floor(Math.random()*6)+1;

var louis = new cyphers()

louis.name = "루이스";
louis.power= "얼음 능력자";
louis.age= Math.floor(Math.random()*6)+1;



document.write(tomas.name); br();
document.write(tomas.power); br();
document.write(tomas.age); br();
br();
document.write(louis.name); br();
document.write(louis.power); br();
document.write(louis.age); br();
br();
//구분

if(louis.age == tomas.age){ 

    document.write("둘은 동갑이다.")
}
else if(louis.age > tomas.age){
    document.write("루이스가 나이가 더 많다")
}
else if(louis.age < tomas.age){
    document.write("토마스가 나이가 더 많다")
}