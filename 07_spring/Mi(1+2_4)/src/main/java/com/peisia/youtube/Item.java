
package com.peisia.youtube;

import lombok.Data;

@Data
public class Item {

    public String kind;
    public String etag;
    public Id id;
    public Snippet snippet;

}
