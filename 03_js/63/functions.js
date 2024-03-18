//데미지 랜덤
function getRandomAttackValue(attack) {
	attack = attack + 1;    //ex. 공격력이 10이라고 하면 0~10의 수치로 나와야 하므로
	var random = Math.floor(Math.random() * attack);  // ex. 공격력이 11이고 이 랜덤처리를 하면 랜덤 값은 0~10이 나옴
	return random;
}


//골드
function getRandomgoldgivealue(goldgive) {
	goldgive = goldgive +0;   
	var rgold = Math.floor(Math.random() * goldgive)+50;  
	return rgold;
}

// 보상
function endvs(){

	if(orc.hp < 1) {
		vsing = false;
	   maintextarea.value += '\n'+"통한의 일격! " + orc.name + "는 쓰러졌다."+'\n';
	   expup = orc.exppoint;
	   elf.exp += expup;
	   var goldup = getRandomgoldgivealue(orc.goldgive);
	   tv( elf.win()+'\n'+'\n'+"획득한 경험치 : " + expup+'\n'+"획득한 골드 : " + goldup+'\n\n');
	   tv3( elf.info());
	}
	   // break;
	   else if (elf.hp < 1) {
		vsing = false;
		   tv('\n'+"눈앞이 깜깜해졌다. " + elf.name + "는 쓰러졌다."+'\n'+" GAME OVER ");
		   // break;
	   }
   
   }



// 스크롤
   function screenMessageBoxScrollToBot(){
    // textarea.scrollTop = textarea.scrollHeight;
    maintextarea.scrollTop = maintextarea.scrollHeight;
}
