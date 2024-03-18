/**********************************************************************
rpg (v0.2.0)
***********************************************************************

[v0.1.0 업데이트 내용]
- 몬스터 클래스 생성
- 플레이어 클래스 생성
- 몬스터 객체 생성(orc)
- 플레이어 객체 생성(elf)

    // 공격력을 해당 공격력 수치와 0사이의 값이 랜덤으로 나오도록 수정하였습니다.	
    1.다음 함수를 추가	
    function getRandomAttackValue(attack){	
	attack = attack + 1;    //ex. 공격력이 10이라고 하면 0~10의 수치로 나와야 하므로
	var random = Math.floor(Math.random()*attack);  // ex. 공격력이 11이고 이 랜덤처리를 하면 랜덤 값은 0~10이 나옴
	return random;
}	

    2.공격력으로 상대 체력을 깍는 처리를 하던 부분을 위 함수를 거친 attack 값으로 처리
    - 공격 메세지 출력 추가( ex. 오크전사가 엠피스에게 데미지를 10 입혔습니다. )
    서로 데미지를 입힐 때 누가 누구에게 몇의 데미지를 입혔는지를 출력 처리

**********************************************************************/

function Monster(name,hp,attack){
    this.name = name;
    this.hp = hp;
    this.attack = attack;

    this.info = function(){
        hr();
        dw("["+this.name+"]"+"[💟 : "+this.hp+"]"+"[공격력 : "+this.attack+"]");
        hr();
    }    
}

function Character(name,hp,attack,mp){
    this.name = name;
    this.hp = hp;
    this.attack = attack;
    this.mp = mp;

    this.info = function(){
        hr();
        dw("["+this.name+"]"+"[💟 : "+this.hp+"]"+"[공격력 : "+this.attack+"]"+"[기운 :"+this.mp+"]");
        hr();
    }
}

var orc = new Monster("니르바쉬",300,50);
var elf = new Character("세르파",200,100,1000);

orc.info();
elf.info();
br();br();

function getRandomAttackValue(attack){	
	attack = attack + 1;    //ex. 공격력이 10이라고 하면 0~10의 수치로 나와야 하므로
	var random = Math.floor(Math.random()*attack);  // ex. 공격력이 11이고 이 랜덤처리를 하면 랜덤 값은 0~10이 나옴
	return random;
}

var orcdamage = getRandomAttackValue(orc.attack);
var elfdamage = getRandomAttackValue(elf.attack);

//todos
dw("전투시작");
orc.hp = orc.hp - elfdamage;
elf.hp = elf.hp - orcdamage;
elf.mp = elf.mp - elf.attack;
br();hr();


dw(orc.name+"는 "+elf.name+"에게 💥일반공격을 시도하였습니다.");br();
dw(elf.name+"는 "+orcdamage+"만큼의 피해를 입었습니다.");
hr();


dw(elf.name+"는 "+orc.name+"에게 💥일반공격을 시도하였습니다.");br();
dw(orc.name+"는 "+elfdamage+"만큼의 피해를 입었습니다.");
hr();

br();
br();
orc.info();
elf.info();
br();br();






