package com.prototype.adidas.adidas.http;

public class Tuple {
    private Product prod;
    private Shop shop;

    public Tuple(Product prod, Shop shop) {
        this.prod = prod;
        this.shop = shop;
    }

    public Product getProd() {
        return prod;
    }

    public void setProd(Product prod) {
        this.prod = prod;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "prod=" + prod +
                ", shop=" + shop +
                '}';
    }
}
