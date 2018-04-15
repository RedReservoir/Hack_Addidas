package com.prototype.adidas.adidas.JavaActivities;

import android.graphics.drawable.Drawable;

import com.prototype.adidas.adidas.http.Date;

public class MainActivityFragmentListItem {

    private String name;
    private String currencySymbol;
    private float price;
    private Date date;
    private Drawable productPic;

    public MainActivityFragmentListItem(String name, String currencySymbol, float price, Date date, Drawable productPic) {
        this.name = name;
        this.currencySymbol = currencySymbol;
        this.price = price;
        this.date = date;
        this.productPic = productPic;
    }

    //Getters and Setters
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getCurrencySymbol() {return currencySymbol;}
    public void setCurrencySymbol(String currencySymbol) {this.currencySymbol = currencySymbol;}
    public float getPrice() {return price;}
    public void setPrice(float price) {this.price = price;}
    public Date getDate() {return date;}
    public void setDate(Date date) {this.date = date;}
    public Drawable getProductPic() {return productPic;}
    public void setProductPic(Drawable productPic) {this.productPic = productPic;}

}
