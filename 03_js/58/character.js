
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
        return maintextarea.innerHTML += "["+this.name+" ("+this.hp+"/"+this.mhp+")"+"] (exp : " +this.exp +"/"+this.needexp+")"+"&nbsp;";
    }

    this.win = function expshow() {
        var random;
        random = Math.floor(Math.random() * 6) + 1;
        var expshow;
    
        switch (random) {
            case 1:
                expshow = "왜 나를 때린거냐?";
                return maintextarea.innerHTML += expshow
            case 2:
                expshow = "이 녀석 나한테 골드 줬다.";
                return maintextarea.innerHTML += expshow
            case 3:
                expshow = "내 마법에 쓰러졌다.";
                return maintextarea.innerHTML += expshow
            case 4:
                expshow = "내가 죽인거 아니다.";
                return maintextarea.innerHTML += expshow
            case 5:
            expshow = "가버렸다.";
            return maintextarea.innerHTML += expshow
        }
    
    }
    
}
