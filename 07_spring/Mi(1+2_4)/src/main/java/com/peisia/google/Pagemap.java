
package com.peisia.google;

import java.util.List;

import lombok.Data;

@Data
public class Pagemap {

    public List<CseThumbnail> cseThumbnail;
    public List<Metatag> metatags;
    public List<CseImage> cseImage;
    public List<Offer> offer;
    public List<Hcard> hcard;
    public List<Imageobject> imageobject;
    public List<Person> person;

}
