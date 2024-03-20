
package com.peisia.google;

import java.util.List;

import lombok.Data;
@Data
public class GoogleSearchDto {

    public String kind;
    public Url url;
    public Queries queries;
    public Context context;
    public SearchInformation searchInformation;
    public List<Item> items;

}
