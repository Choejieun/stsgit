
function character(name,hp,mhp,attack,mp){
    this.name = name;
    this.hp = hp;
    this.mhp = mhp;
    this.attack = attack;
    this.mp = mp;

    this.info = function(){
        dw("["+this.name+" ("+this.hp+"/"+this.mhp+")"+"]");
    }
}
