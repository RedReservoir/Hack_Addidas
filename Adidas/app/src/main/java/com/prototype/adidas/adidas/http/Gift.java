package com.prototype.adidas.adidas.http;

public class Gift {
    private String id_gift;
    private float money;

    public Gift() {

    }

    public Gift(String id_gift, float money) {
        this.id_gift = id_gift;
        this.money = money;
    }

    public String getId_gift() {
        return id_gift;
    }

    public void setId_gift(String id_gift) {
        this.id_gift = id_gift;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }
}
