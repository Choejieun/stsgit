
package com.peisia.cyphers.matches;

import lombok.Data;

@Data
public class Row {

    public String date;
    public String matchId;
    public Map map;
    public PlayInfo playInfo;
    public Position position;

}
