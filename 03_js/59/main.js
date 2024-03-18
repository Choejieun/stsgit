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
[v0.7.0 업데이트 내용]
- 전투 종료 처리(종료메세지 출력, 경험치 획득)
- 케릭터 클래스에 현재 경험치, 다음 레벨업에 필요한 경험치 두 변수를 추가하기. (현재 경험치는 초기값 0. 필요 경험치는 초기값 300 주기)
- 몬스터를 잡고 받은 경험치 획득 처리는 플레이어의 현재 경험치에 100을 추가해주기
- 플레이어 간략 정보 표시에 현재 경험치/다음 레벨업 필요 경험치 표시 추가 ex. [엠피스(70/100)](exp: 100/300)
(레벨업 경험치 기획은 현재 미정. 300값 하드코딩.)
- 전투 종료 후 얻은 경험치를 확인하기 위해 플레이어 info 함수 한번 호출하기
[v0.8.0 업데이트 내용]
- 전투 종료 후 경험치 획득 메세지 출력 ex. 불쌍한 토끼, 엠피스에게 경험치 100 을 주고 죽었습니다.
- 보상 추가. 몬스터 사냥 시 돈도 획득하도록 변경되었습니다..
[v0.9.0 업데이트 내용]
- 출력 중 hr() 을 모두 제거
- br()도 모두 제거
- 정보 출력을 textarea 에 하도록 변경

**********************************************************************/
var orc = new monster("니르바쉬", 300, 300, 5, 100,100);
var elf = new character("세르파", 200, 200, 100, 1000, 0, 300);
var expup;
var goldup;
var textss;
var mainbox ;
var characterimg ;
var screenPlayerInfo;
var maintextarea;
var a;
var b;

window.onload = function(){

	mainbox = document.getElementById("all"); // 전체 div
    characterimg = document.getElementById("character_img");
    screenPlayerInfo = document.getElementById("screenPlayerInfo");
    maintextarea = document.getElementById("main_textarea");
	
	Stat();
}

// a = orc.info();
// b = elf.info();

//todos


function Stat(){

tv("전투시작\n");

while (true) {

	function getRandomAttackValue(attack) {
		attack = attack + 1;    //ex. 공격력이 10이라고 하면 0~10의 수치로 나와야 하므로
		var random = Math.floor(Math.random() * attack);  // ex. 공격력이 11이고 이 랜덤처리를 하면 랜덤 값은 0~10이 나옴
		return random;
	}

	var orcdamage = getRandomAttackValue(orc.attack)
	var elfdamage = getRandomAttackValue(elf.attack);
	

	orc.hp = orc.hp - elfdamage;
	tv( "💠 " + elf.name + "는 " + orc.name + "에게 💥일반공격을 시도하였습니다."+'\n');
	tv( orc.name + "는 " + elfdamage + "의 피해를 입었습니다."+'\n');
	tv3( orc.info())
	tv3( elf.info() + '\n');

	 if (elf.hp < 1) {
		maintextarea.value +=  +'\n'+"눈앞이 깜깜해졌다. " + elf.name + "는 쓰러졌다."+'\n'+"GAME OVER";
		break;
	} else if (orc.hp < 1) {
		maintextarea.value += '\n'+"통한의 일격! " + orc.name + "는 쓰러졌다."+'\n';
		expup = orc.exppoint;
		elf.exp += expup;


		function getRandomgoldgivealue(goldgive) {
			goldgive = goldgive +0;   
			var rgold = Math.floor(Math.random() * goldgive)+50;  
			return rgold;
		}

		var goldup = getRandomgoldgivealue(orc.goldgive);
		tv( elf.win()+'\n'+'\n'+"획득한 경험치 : " + expup+'\n'+"획득한 골드 : " + goldup+'\n\n');
		tv3( elf.info());
		break;
	}


	elf.hp = elf.hp - orcdamage;
	tv( '\n' + "❗ " + orc.name + "는 " + elf.name + "에게 💥일반공격을 시도하였습니다." + '\n');
	tv( elf.name + "는 " + orcdamage+ "의 피해를 입었습니다." + '\n');
	tv3( orc.info())
	tv3( elf.info() + '\n');
	
	if (orc.hp < 1) {
		tv('\n'+"통한의 일격! " + orc.name + "는 쓰러졌다."+'\n'+" GAME OVER ");
		expup = orc.exppoint;
		elf.exp = expup;
		break;
	} else if (elf.hp < 1) {
		tv('\n'+"눈앞이 깜깜해졌다. " + elf.name + "는 쓰러졌다."+'\n'+" GAME OVER ");
		break;
	}




}



/***********************
//todo

왜 안되는지 알아내서 해결하기


**/
}