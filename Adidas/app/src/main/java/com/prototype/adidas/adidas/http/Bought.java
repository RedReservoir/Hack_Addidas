package com.prototype.adidas.adidas.http;

public class Bought {

    private Date date;
    private Boolean pay;
    private Shop shop;
    private Product p;


    public Bought(Date date, Boolean pay, Shop shop, Product p) {
        this.date = date;
        this.pay = pay;
        this.shop = shop;
        this.p = p;
    }

    public Product getP() {

        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getPay() {
        return pay;
    }

    public void setPay(Boolean pay) {
        this.pay = pay;
    }
}
