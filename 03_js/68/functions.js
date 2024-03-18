//데미지 랜덤 주인공용
function getRandomAttackValue_for_elf(attack) {
	var elfA = elf.attack;
	attack = attack + 1;    //ex. 공격력이 10이라고 하면 0~10의 수치로 나와야 하므로
	var random = Math.floor(Math.random() * attack) + elfA;  // ex. 공격력이 11이고 이 랜덤처리를 하면 랜덤 값은 0~10이 나옴
	return random;
}
//데미지 랜덤 몬스터용
function getRandomAttackValue(attack) {
	var elfA = monsterId().attack;
	attack = attack + 1;    //ex. 공격력이 10이라고 하면 0~10의 수치로 나와야 하므로
	var random = Math.floor(Math.random() * attack) + elfA;  // ex. 공격력이 11이고 이 랜덤처리를 하면 랜덤 값은 0~10이 나옴
	return random;
}


// 전투 턴제
function vs1() {
	var random;
	random = Math.floor(Math.random() * 6) + 1;


	tv3(elf.info());
	img.src = "img.avif";

	var orcdamage = getRandomAttackValue(monsterId().attack);
	var elfdamage = getRandomAttackValue_for_elf(elf.attack);

	tv("💠 " + elf.name + "는 " + monsterId().name + "에게 💥일반공격을 시도하였습니다." + '\n');
	if (random >= 2) {
		monsterId().hp = monsterId().hp - elfdamage;
		tv(monsterId().name + "는 " + elfdamage + "의 피해를 입었습니다." + '\n');
		tv4(monsterId().info());
	}
	else {
		tv(elf.name + "는 공격이 실패했다!" + '\n');
	}

	tv4(monsterId().info());
}
// 전투 턴제
function vs2() {
	var random;
	random = Math.floor(Math.random() * 6) + 1;


	tv3(elf.info());
	img.src = "img.avif";

	var orcdamage = getRandomAttackValue(monsterId().attack);
	var elfdamage = getRandomAttackValue_for_elf(elf.attack);

	tv('\n' + "❗ " + monsterId().name + "는 " + elf.name + "에게 💥일반공격을 시도하였습니다." + '\n');
	if (random >= 2) {
		elf.hp = elf.hp - orcdamage;
		tv(elf.name + "는 " + orcdamage + "의 피해를 입었습니다." + '\n');
		tv4(monsterId().info());
	}
	else {
		tv(monsterId().name + "는  공격이 실패했다!" + '\n');
	}
	tv4(monsterId().info());
}



//골드
function getRandomgoldgivealue(goldgive) {
	goldgive = goldgive + 0;
	var rgold = Math.floor(Math.random() * goldgive) + 50;
	return rgold;
}

// 보상
function endvs() {

	if (monsterId().hp < 1) {
		vsing = false;
		maintextarea.value += '\n' + "통한의 일격! " + monsterId().name + "는 쓰러졌다." + '\n';
		expup = monsterId().exppoint;
		elf.exp += expup;
		lvup = elf.laveUP();
		var goldup = getRandomgoldgivealue(monsterId().goldgive);
		tv(elf.win() + '\n' + '\n' + "획득한 경험치 : " + expup + '\n' + "획득한 골드 : " + goldup + '\n\n');
		tv3(elf.info());
		tv3_3(RoomId().roomName);
		tv3_3(RoomId().desc);
		tv3_3(RoomId().getRoomEnter());
		return;
	}
	// break;
	else if (elf.hp < 1) {
		vsing = false;
		tv('\n' + "눈앞이 깜깜해졌다. " + elf.name + "는 쓰러졌다." + '\n' + " GAME OVER ");
		img.src = "youdied.jfif";
		return;
		// break;
	}

}



// 스크롤
function screenMessageBoxScrollToBot() {
	// textarea.scrollTop = textarea.scrollHeight;
	maintextarea.scrollTop = maintextarea.scrollHeight;
}

// //이동
// function moveUp(){	
// 	tv("▶위쪽으로 이동했습니다.");
// 	turngo()
// }	
// function moveN(){	
// 	tv("▶북쪽으로 이동했습니다.");
// 	turngo()
// }	
// function moveW(){	
// 	tv("▶서쪽으로 이동했습니다.");
// 	turngo()
// }	
// function moveE(){	
// 	tv("▶동쪽으로 이동했습니다.");
// 	turngo()
// }	
// function moveS(){	
// 	tv("▶남쪽으로 이동했습니다.");
// 	turngo()
// }	
// function moveDo(){	
// 	tv("▶아래쪽으로 이동했습니다.");
// 	turngo()
// }	

//이동 개편
function move(moveon) {
	var nowroom = RoomId();
	var nowroomID = nowroom.getmoveid(moveon);
	var random;
	random = Math.floor(Math.random() * 6) + 1;


	if (nowroomID != 0 && vsing == true && monsterId().hp >= 0) {
		if (random >= 2) {
			tv("도망 칠 수 없다! \n");
			return;
		}
		else {
			tv("도망에 성공했다!💨💨💨 \n")
		}
	}

	if (nowroomID == 0) {
		tv("갈 수 없음");
		return;
	}


	else {
		currentRoomId = nowroomID;
		console.log("현재 방번호:" + currentRoomId);
	}

	switch (moveon) {
		case "동":
			tv("\n▶ 동쪽으로 이동합니다.");
			break;
		case "서":
			tv("\n▶ 서쪽으로 이동합니다.");
			break;
		case "남":
			tv("\n▶ 남쪽으로 이동합니다.");
			break;
		case "북":
			tv("\n▶ 북쪽으로 이동합니다.");
			break;
		case "위":
			tv("\n▶ 위쪽으로 이동합니다.");
			break;
		case "아래":
			tv("\n▶ 아래쪽으로 이동합니다.");
			break;

	}

	Start();
	sponRoomPLZ();

}


function sponRoomPLZ() {
	var nowroom2 = RoomId();  //중앙방이 현재 방일 떄
	var nowroomID2 = nowroom2.id; // 중앙방의 아이디를 가져온다.
	var nowMonter = monsterId(); //몬스터의 위치가 현재 방과 일치할 때
	var nowMonterID = nowMonter.location; //몬스터의 위치를 가져온다.
	var spp = nowMonter.spon;

	if (nowroomID2 == nowMonterID && spp == 0)  // 몬스터의 위치(1001)와 방의 아이디가 같다면(1001)
	{
		spp += 1;
		console.log("해당 몬스터의 전투이력" + spp);

		if (nowMonter.spon = true) {
			console.log("현재 괴물 이름:" + nowMonter.name);
			tv("\n ‼ 눈 앞에 적이 나타났다! [ " + nowMonter.name + ' ]\n');
			vsing = true
			return;
		}
	}

}

//방 바꾸기
function RoomId() {
	for (var i = 0; i < roomArray.length; i++) {
		if (roomArray[i].id == currentRoomId) {
			return roomArray[i]; //rooo[0]
		}
	}
}