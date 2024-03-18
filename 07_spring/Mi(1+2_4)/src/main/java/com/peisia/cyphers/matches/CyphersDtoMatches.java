
package com.peisia.cyphers.matches;

import java.util.List;

import lombok.Data;
@Data
public class CyphersDtoMatches {

    public String playerId;
    public String nickname;
    public Integer grade;
    public Boolean tierTest;
    public Represent represent;
    public String clanName;
    public Object ratingPoint;
    public Object maxRatingPoint;
    public Object tierName;
    public List<Record> records;
    public Matches matches;

}
