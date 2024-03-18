/**********************************************************************
rpg (v0.5.0)
***********************************************************************

[v0.1.0 업데이트 내용]
- 몬스터 클래스 생성
- 플레이어 클래스 생성
- 몬스터 객체 생성(orc)
- 플레이어 객체 생성(elf)
[v0.4.0 업데이트 내용]
- 체력 표시를 [현재체력/최대체력] 식으로 변경하였습니다.		
- 케릭터 정보 표시를 수정하였습니다. ex. [엠피스(70/100)]		
- 케릭터 정보 표시에서 공격력 수치를 제거하였습니다.	
[v0.5.0 업데이트 내용]
- 케릭터 정보 출력을 한꺼번에 출력되도록 수정하였습니다. ex [엠피스(50/100)] [오크전사(30/100)]				
- 클래스 선언을 별도의 파일로 옮기고 연결했습니다.	
[v0.6.0 업데이트 내용]
- 전투 처리부분과 케릭터들의 상태 정보를 출력하는 부분을 하나의 함수로 묶어 처리					
- 전투 무한 루프 처리 : 전투 시 플레이어나 적의 currentHp 가 0 이하로 될 때까지(죽을때 까지) 전투 반복 처리									

**********************************************************************/
var orc = new monster("니르바쉬",300,300,50);
var elf = new character("세르파",200,200,100,1000);

orc.info();
elf.info();
hr();

//todos
dw("<h1>전투시작</h1>");
hr();



while (true){
	
	function getRandomAttackValue(attack){	
		attack = attack + 1;    //ex. 공격력이 10이라고 하면 0~10의 수치로 나와야 하므로
		var random = Math.floor(Math.random()*attack);  // ex. 공격력이 11이고 이 랜덤처리를 하면 랜덤 값은 0~10이 나옴
		return random;
	}
	
	var orcdamage = getRandomAttackValue(orc.attack);
	var elfdamage = getRandomAttackValue(elf.attack);

orc.hp = orc.hp - elfdamage;
elf.hp = elf.hp - orcdamage;
elf.mp = elf.mp - elf.attack; //마나(잉여)

dw(orc.name+"는 "+elf.name+"에게 💥일반공격을 시도하였습니다.");br();
dw(elf.name+"는 "+orcdamage+"만큼의 피해를 입었습니다.");
br();br();

dw(elf.name+"는 "+orc.name+"에게 💥일반공격을 시도하였습니다.");br();
dw(orc.name+"는 "+elfdamage+"만큼의 피해를 입었습니다.");
br();br();
orc.info(); elf.info();
hr();



		if(orc.hp < 1 || elf.hp <0){
			if (orc.hp < 1){
				dw("통한의 일격! "+orc.name+"는 쓰러졌다.");
			}
			else {
				dw("눈 앞이 깜깜해졌다!  "+elf.name+"는 쓰러졌다.");
			}
break;
}}




