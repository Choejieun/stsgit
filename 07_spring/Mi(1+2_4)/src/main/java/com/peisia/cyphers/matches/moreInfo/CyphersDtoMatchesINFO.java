
package com.peisia.cyphers.matches.moreInfo;

import java.util.List;

import lombok.Data;

@Data
public class CyphersDtoMatchesINFO {

    public String date;
    public String gameTypeId;
    public Map map;
    public List<Team> teams;
    public List<Player> players;

}
