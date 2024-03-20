
package com.peisia.google;

import lombok.Data;

@Data
public class Item {

    public String kind;
    public String title;
    public String htmlTitle;
    public String link;
    public String displayLink;
    public String snippet;
    public String htmlSnippet;
    public String formattedUrl;
    public String htmlFormattedUrl;
    public Pagemap pagemap;
    public String cacheId;

}
