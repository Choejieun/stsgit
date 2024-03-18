/**********************************************************************
rpg (v0.1.0)
***********************************************************************

[v0.1.0 업데이트 내용]
- 몬스터 클래스 생성
- 플레이어 클래스 생성
- 몬스터 객체 생성(orc)
- 플레이어 객체 생성(elf)


**********************************************************************/

function Monster(name,hp,attack){
    this.name = name;
    this.hp = hp;
    this.attack = attack;

    this.info = function(){
        hr();
        dw("["+name+"]"+"["+hp+"]"+"["+attack+"]");
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
        dw("["+name+"]"+"[체력 : "+hp+"]"+"[공격력 : "+attack+"]"+"[기운 :"+mp+"]");
        hr();
    }
}

var orc = new Monster("니르바쉬",50,300);
var elf = new Character("세르파",100,200,100);

orc.info()
elf.info()
