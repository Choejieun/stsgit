function monster(name,hp,mhp,attack,exppoint,goldgive){
    this.name = name;
    this.hp = hp;
    this.mhp = mhp;
    this.attack = attack;
    this.exppoint = exppoint;
    this.goldgive = goldgive;

    this.info = function(){
        return  "["+this.name+" ("+this.hp+"/"+this.mhp+")"+"] "
    }    

    // this.info = function(){
    //     return "["+this.name+" ("+this.hp+"/"+this.mhp+")"+"] (exp : " +this.exp +"/"+this.needexp+")"+"&nbsp;"
    // }

    // tv( orc.info() + elf.info() + '\n');
}