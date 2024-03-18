
package com.peisia.cyphers.matches;

import java.util.List;

import lombok.Data;

@Data
public class PlayInfo {

    public String result;
    public Boolean random;
    public Integer partyUserCount;
    public List<PartyInfo> partyInfo;
    public String playTypeName;
    public String characterId;
    public String characterName;
    public Integer level;
    public Integer killCount;
    public Integer deathCount;
    public Integer assistCount;
    public Integer attackPoint;
    public Integer damagePoint;
    public Integer battlePoint;
    public Integer sightPoint;
    public Integer towerAttackPoint;
    public Integer backAttackCount;
    public Integer comboCount;
    public Integer spellCount;
    public Integer healAmount;
    public Integer sentinelKillCount;
    public Integer demolisherKillCount;
    public Integer trooperKillCount;
    public Integer guardianKillCount;
    public Integer guardTowerKillCount;
    public Integer getCoin;
    public Integer spendCoin;
    public Integer spendConsumablesCoin;
    public Integer playTime;
    public Integer responseTime;
    public Integer minLifeTime;
    public Integer maxLifeTime;

}
