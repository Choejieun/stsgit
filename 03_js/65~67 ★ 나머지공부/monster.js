function monster(name,hp,mhp,attack,exppoint,goldgive,location){
    this.name = name;
    this.hp = hp;
    this.mhp = mhp;
    this.attack = attack;
    this.exppoint = exppoint;
    this.goldgive = goldgive;
    this.location = location;

    this.info = function(){
        return  "["+this.name+" ("+this.hp+"/"+this.mhp+")"+"] "
    }    
    this.getinfo = function(){
        return  tv("["+this.name+" ("+this.hp+"/"+this.mhp+")"+"] ");
    }    

    // this.info = function(){
    //     return "["+this.name+" ("+this.hp+"/"+this.mhp+")"+"] (exp : " +this.exp +"/"+this.needexp+")"+"&nbsp;"
    // }

    // tv( orc.info() + elf.info() + '\n');
}

//방 찾기
function monsterId() {
	for (var i = 0; i < monsterArray.length; i++) {
		if (monsterArray[i].location == currentRoomId) {
			return monsterArray[i]; //monster[0]
		}
	}
}