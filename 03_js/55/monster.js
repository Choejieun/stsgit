function monster(name,hp,mhp,attack){
    this.name = "<a class = red>"+name+"</a>";
    this.hp = hp;
    this.mhp = mhp;
    this.attack = attack;

    this.info = function(){
        dw("["+this.name+" ("+this.hp+"/"+this.mhp+")"+"]");
    }    
}