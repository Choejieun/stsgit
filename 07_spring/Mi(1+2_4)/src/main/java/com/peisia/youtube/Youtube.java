
package com.peisia.youtube;

import java.util.List;

import lombok.Data;
@Data
public class Youtube {

    public String kind;
    public String etag;
    public String nextPageToken;
    public String regionCode;
    public PageInfo pageInfo;
    public List<Item> items;

}
