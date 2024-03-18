function monster(name,hp,mhp,attack,exppoint,goldgive){
    this.name = name;
    this.hp = hp;
    this.mhp = mhp;
    this.attack = attack;
    this.exppoint = exppoint;
    this.goldgive = goldgive;

    this.info = function(){
        maintextarea.innerHTML +="["+this.name+" ("+this.hp+"/"+this.mhp+")"+"]"+"&nbsp;";
    }    
}