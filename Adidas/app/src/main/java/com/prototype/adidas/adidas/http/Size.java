package com.prototype.adidas.adidas.http;

import java.lang.reflect.Type;

public class Size {

    private String country,size_c,collection, type;

    public Size(String country, String size_c, String collection, String type) {
        this.country = country;
        this.size_c = size_c;
        this.collection = collection;
        this.type = type;
    }

    public String getSize_c() {
        return size_c;
    }

    public void setSize_c(String size_c) {
        this.size_c = size_c;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    @Override
    public String toString() {
        return "Size{" +
                "country='" + country + '\'' +
                ", size_c='" + size_c + '\'' +
                ", collection='" + collection + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
