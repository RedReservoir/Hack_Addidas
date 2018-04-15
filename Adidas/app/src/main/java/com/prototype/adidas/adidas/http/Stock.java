package com.prototype.adidas.adidas.http;

public class Stock {
    private String id_product, id_shop;
    private int quantity;

    public Stock(String id_product, String id_shop, int quantity) {
        this.id_product = id_product;
        this.id_shop = id_shop;
        this.quantity = quantity;
    }

    public String getId_product() {
        return id_product;
    }

    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    public String getId_shop() {
        return id_shop;
    }

    public void setId_shop(String id_shop) {
        this.id_shop = id_shop;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
