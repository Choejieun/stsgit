
function character(name,hp,mhp,attack,mp,exp,needexp){
    this.name = "<a class = bule>"+name+"</a>";
    this.hp = hp;
    this.mhp = mhp;
    this.attack = attack;
    this.mp = mp;
    this.exp = exp;
    this.needexp = needexp;

    this.info = function(){
        dw("["+this.name+" ("+this.hp+"/"+this.mhp+")"+"] (exp : " +this.exp +"/"+this.needexp+")");
        dw("&nbsp;");
    }
}
