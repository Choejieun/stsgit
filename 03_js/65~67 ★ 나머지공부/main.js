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
[v0.11.0 업데이트 내용]
- 턴 진행 버튼 추가
- 테스트로 턴 진행 버튼에 console.log 적용 ( ex. console.log("로그찍기"); )
- 턴 진행 버튼 왼쪽에 턴수 표시 input text 추가
[v0.12.0 업데이트 내용]
- 전투를 턴버튼을 누를때마다 한턴씩 진행하도록 수정
- 적 간략 정보가 textarea game object 에 나오도록 수정
[v0.13.0 업데이트 내용]
- 전투 종료 후 턴 진행 시 전투가 더 진행되지 않게 처리
- 전투 종료 시 적 오브젝트 처리(전투가 끝났으니 더 이상 안나오게)
[v0.14.0 업데이트 내용]
- 메세지 textarea 의 글이 길어질 경우 스크롤이 자동으로 아래로 내려가도록 처리
- main.js 의 function 들을 functions.js 로 분리함
- endBattle() 의 currentMode = "비전투" 를 "대기" 로 변경
[v0.15.0 업데이트 내용]
- 최초 turnCount 값을 0에서 1로 수정
- 이동 버튼 추가(동, 서, 남, 북, 위, 밑)
- 이동 함수들을 추가( 함수에서 이동 메세지 출력과 턴진행 수행 )
- 처음에 currentMode 값을 "대기" 로 수정하여 전투가 바로 시작되지 않도록 수정함
- 전투시작 메시지 삭제 (추후 전투모드 전환 시 재추가 예정 )
- procNormalTurn() 내 텍스트 삭제 함수 tvClear() 제거
- procNormalTurn() 내에 메세지 출력 변경. "특별한 것은 보이지 않는다.\n"
[v0.16.0 업데이트 내용]
- 맵 기획, 설계	
- 작은 공간을 표현하기 위한 Room 클래스 추가 ( Room.js ) 및 연결	
- Room 객체 3개 생성	
- Room 클래스에 () 추가 - displayRoomInfo (방제목, 방설명, 다른방과 연결되는 방 표시)	
- Room 클래스에 () 추가 - getRoomEnter (다른방과 연결되는 방 표시)	
- 테스트로 처음 시작 시 roomA.displayRoomInfo(); 식으로 호출 하여 방 정보 출력	
[v0.17.0 업데이트 내용]
- 방 객체들을 배열에 넣음
- 방 id 값을 입력 값으로 받아 방 배열 중 해당 id 값을 가진 객체만을 리턴하는 함수 추가
- displayRoomInfo() 에서 현재 플레이어가 위치한 방 정보를 출력하도록 처리
[v0.18.0 업데이트 내용]
- 이동 함수들을 하나로 통합 moveEast > move
- 이동 버튼을 눌렀을 때 해당 방향으로 이동 할수 없으면 "갈수 없음" 이동 가능하면 해당 방으로 이동 처리(현재 방 번호 id를 바꾸고 해당 방의 정보를 출력) *여기까지 하면 방 개념과 이동이 구현됨*
[v0.20.0 업데이트 내용]
- 오브젝트 창의 orc 간략 정보 출력을 주석처리
- 몬스터 클래스에 배치위치 변수 추가. 초기값 0
- 몬스터들을 (허수아비4,쥐2) 객체 생성하고  monsterArray 배열에 넣음
- 몬스터 생성 시 생성자의 location 값에 각 방의 id를 넣어 해당 방에 위치시킴
- 몬스터 클래스에 getInfo 를 추가하고 간략 정보를 문자열로 리턴하는 함수로 함
- 몬스터 하나 추가(왕쥐, 위치 = 연습장 지하)
- 현재 방의 몬스터들을 출력 처리
- 각방 이동이 잘 되는지 확인
- 각방마다 존재하는 몬스터들이 게임 오브젝트 창에 잘 표시되는지 확인
**********************************************************************/
var elf = new character("세르파", 200, 200, 100, 1000, 0, 300);
var expup;
var goldup;
var textss;
var mainbox;
var characterimg;
var screenPlayerInfo;
var maintextarea;
var a;
var b;
var turnCount = 1;
var turn_number;
var gameobject;
var vsing = false;  //전투 온오프
var img
var currentRoomId = 1000;
var roomA = new Room("연습장 입구", "연습장으로 들어가는 입구다.", 1000, 1001, 0, 0, 0, 0, 0);
var roomB = new Room("연습장 서쪽", "연습장 서쪽이다.", 1001, 1002, 1000, 0, 0, 0, 0);
var roomC = new Room("연습장 중앙", "연습장 중앙이다.", 1002, 0, 1001, 1004, 1003, 1005, 1006);
var roomN = new Room("연습장 북쪽", "연습장 북쪽이다.", 1003, 0, 0, 1002, 0, 0, 0);
var roomS = new Room("연습장 남쪽", "연습장 남쪽이다.", 1004, 0, 0, 0, 1002, 0, 0);
var roomNoogak = new Room("연습장 누각", "연습장 누각이다.", 1005, 0, 0, 0, 0, 0, 1002);
var roomBasement = new Room("연습장 지하", "연습장 지하이다.", 1006, 0, 0, 0, 0, 1002, 0);
//  		 di  동 서  남 북 위 아래
var roomArray = [
	new Room("연습장 입구", "연습장으로 들어가는 입구다.", 1000, 1001, 0, 0, 0, 0, 0),
	new Room("연습장 서쪽", "연습장 서쪽이다.", 1001, 1002, 1000, 0, 0, 0, 0),
	new Room("연습장 중앙", "연습장 중앙이다.", 1002, 0, 1001, 1004, 1003, 1005, 1006),
	new Room("연습장 북쪽", "연습장 북쪽이다.", 1003, 0, 0, 1002, 0, 0, 0),
	new Room("연습장 남쪽", "연습장 남쪽이다.", 1004, 0, 0, 0, 1002, 0, 0),
	new Room("연습장 누각", "연습장 누각이다.", 1005, 0, 0, 0, 0, 0, 1002),
	new Room("연습장 지하", "연습장 지하이다.", 1006, 0, 0, 0, 0, 1002, 0)
];

// monster(이름,체력,최대체력,공격력,  경험치,골드,위치(location))
// var orc = new monster("니르바쉬", 300, 300, 5, 100, 100,0);
var monster_scarecrow_1 = new monster("허수아비1", 50, 50, 0, 100,  100, 1002);
var monster_scarecrow_2 = new monster("허수아비2", 50, 50, 0, 100,  100, 1002);
var monster_scarecrow_3 = new monster("허수아3", 50, 50, 0, 100,  100, 1002);
var monster_scarecrow_4 = new monster("허수아비", 50, 50, 0, 100,  100, 1002);
var monster_rat_1 = new monster("허수아비", 50, 50, 0, 100,  100, 1002);
var monster_rat_2 = new monster("허수아비", 50, 50, 0, 100,  100, 1002);

var monsterArray = [
	new monster("허수아비1", 50, 50, 0, 100,  100, 1002),
	new monster("허수아비1", 50, 50, 0, 100,  100, 1002),
	new monster("허수아3", 50, 50, 0, 100,  100, 1002),
	new monster("허수아비", 50, 50, 0, 100,  100, 1002) ,           
	new monster("허수아비", 50, 50, 0, 100,  100, 1002),             
	new monster("허수아비", 50, 50, 0, 100,  100, 1002)         
];



var time_log


window.onload = function () {

	mainbox = document.getElementById("all"); // 전체 div
	characterimg = document.getElementById("character_img");
	screenPlayerInfo = document.getElementById("screenPlayerInfo");
	maintextarea = document.getElementById("main_textarea");
	turn_number = document.getElementById("turn_number");
	gameobject = document.getElementById("gameobject");
	img = document.getElementById("img");

	Start();
}

function Start() {
	tv3(elf.info());
	RoomId().displayRoomInfo(); //roomA.di...info();
	tv3_3(RoomId().roomName);
	tv3_3(RoomId().desc);
}


//메인 턴 진행
function turngo() {
	console.log("현재 턴은? :" + turnCount);
	turnCount++;    // 턴 1 증가
	turn_number.value = turnCount;


	if (vsing == true) {
		vs();
		endvs();
	}

	else if (vsing == false) {
		tv("특별한 것은 보이지 않는다.");
		tv3(elf.info());
		tv3_3(RoomId().roomName);
		tv4("");
		img.src = "img_mein.png";
	}
}


