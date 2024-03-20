
package com.peisia.google;

import lombok.Data;

@Data
public class Request {

    public String title;
    public String totalResults;
    public String searchTerms;
    public Integer count;
    public Integer startIndex;
    public String inputEncoding;
    public String outputEncoding;
    public String safe;
    public String cx;

}
