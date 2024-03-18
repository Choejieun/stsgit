/**********************************************************************
rpg (v0.2.0)
***********************************************************************

[v0.1.0 업데이트 내용]
- 몬스터 클래스 생성
- 플레이어 클래스 생성
- 몬스터 객체 생성(orc)
- 플레이어 객체 생성(elf)

// 			오크와 엘프 간 전투 처리 (서로 한번씩만 때려 피해를 입히는 처리)
//				상대의 공격력(attack) 수치 만큼 hp(체력) 에 피해 ( 마이너스 ) 처리	
// 			각 객체의 info 를 호출하여 현재 정보 출력	

**********************************************************************/

function Monster(name,hp,attack){
    this.name = name;
    this.hp = hp;
    this.attack = attack;

    this.info = function(){
        hr();
        dw("["+name+"]"+"[체력 : " +this.hp+"]"+"[공격력 : "+attack+"]");
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
        dw("["+name+"]"+"[체력 : "+this.hp+"]"+"[공격력 : "+attack+"]"+"[기운 :"+mp+"]");
        hr();
    }
}

var orc = new Monster("니르바쉬",300,100);
var elf = new Character("세르파",200,100,100);

orc.info();
elf.info();
br();br();

//todo
dw("전투시작");
br();
orc.hp = orc.hp - elf.attack;
elf.hp = elf.hp - orc.attack;
br();
orc.info();
elf.info();
br();br();



