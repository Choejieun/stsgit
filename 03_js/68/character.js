
function character(name,hp,mhp,attack,mp,exp,needexp,gold){
    this.name = name;
    this.hp = hp;
    this.mhp = mhp;
    this.attack = attack;
    this.mp = mp;
    this.exp = exp;
    this.needexp = needexp;
    this.gold = gold;

    this.info = function(){
        return "["+this.name+" ("+this.hp+"/"+this.mhp+")"+"] \n(exp : " +this.exp +"/"+this.needexp+")\n"
    }

    this.laveUP = function(){
       if( this.exp >=  this.needexp){
        this.exp = 0;
        this.needexp += this.needexp*0.3;
        this.hp += hp*0.25;
        this.mhp += mhp*0.25;
        this.attack += attack*0.25;
        this.mp += mp*0.25;
        tv("\n💫      레벨업!       💫");
        return;
       }
    }

    // tv( orc.info() + elf.info() + '\n');

    this.win = function expshow(expshow) {
        var random;
        random = Math.floor(Math.random() * 5) + 1;
        var expshow;
    
        switch (random) {
            case 1:
                expshow = "\n왜 나를 때린거냐?";
                return expshow;
            case 2:
                expshow = "\n이 녀석 나한테 골드 줬다.";
                return expshow;
            case 3:
                expshow = "\n내 마법에 쓰러졌다.";
                return expshow;
            case 4:
                expshow = "\n내가 죽인거 아니다.";
                return expshow;
            case 5:
            expshow = "\n가버렸다.";
            return expshow;
        }
    
    }
    
}
