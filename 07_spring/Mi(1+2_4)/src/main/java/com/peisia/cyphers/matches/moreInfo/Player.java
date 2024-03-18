
package com.peisia.cyphers.matches.moreInfo;

import java.util.List;

import lombok.Data;

@Data
public class Player {

    public String playerId;
    public String nickname;
    public Map__1 map;
    public PlayInfo playInfo;
    public Position position;
    public List<Item> items;

}
