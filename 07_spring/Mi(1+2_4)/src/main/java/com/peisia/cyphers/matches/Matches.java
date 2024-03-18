
package com.peisia.cyphers.matches;

import java.util.List;

import lombok.Data;
@Data
public class Matches {

    public Date date;
    public String gameTypeId;
    public String next;
    public List<Row> rows;

}
