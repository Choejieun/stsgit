
package com.peisia.cyphers.matches.moreInfo;

import lombok.Data;

@Data
public class PlayInfo {

    public Boolean random;
    public Integer partyUserCount;
    public String partyId;
    public String playTypeName;
    public String characterId;
    public String characterName;
    public Integer level;
    public Integer killCount;
    public Integer deathCount;
    public Integer assistCount;
    public Integer attackPoint; //공격 데미지 포인트
    public Integer damagePoint; //피해 데미지 포인트
    public Integer battlePoint; //전투 참여 포인트
    public Integer sightPoint; //시야 확보 포인트
    public Integer towerAttackPoint; //타워에게 준 총 공격 포인트
    public Integer backAttackCount;
    public Integer comboCount;
    public Integer spellCount;
    public Integer healAmount;
    public Integer sentinelKillCount; //센티넬 킬 수
    public Integer demolisherKillCount; //철거반 킬 수
    public Integer trooperKillCount; //트루퍼 킬 수
    public Integer guardianKillCount;
    public Integer guardTowerKillCount;
    public Integer getCoin; //코인 코인 획득량
    public Integer spendCoin; //코인 소모량
    public Integer spendConsumablesCoin; //도핑량
    public Integer playTime;
    public Integer responseTime;
    public Integer minLifeTime;
    public Integer maxLifeTime;

}
