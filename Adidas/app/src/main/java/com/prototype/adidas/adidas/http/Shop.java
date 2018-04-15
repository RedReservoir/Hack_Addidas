package com.prototype.adidas.adidas.http;

import java.util.List;

public class Shop {

    private String id_shop;
    private float coord_X,coord_Y;
    private List<Bought> boughts;
    private List<Stock> stocks;

    public Shop(String id_shop, float coord_X, float coord_Y, List<Bought> boughts, List<Stock> stocks) {
        this.id_shop = id_shop;
        this.coord_X = coord_X;
        this.coord_Y = coord_Y;
        this.boughts = boughts;
        this.stocks = stocks;
    }

    public Shop(String id_shop, float coord_X, float coord_Y) {
        this.id_shop = id_shop;
        this.coord_X = coord_X;
        this.coord_Y = coord_Y;
    }

    public Shop() {
    }

    public List<Bought> getBoughts() {
        return boughts;
    }

    public void setBoughts(List<Bought> boughts) {
        this.boughts = boughts;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public String getId_shop() {
        return id_shop;
    }

    public void setId_shop(String id_shop) {
        this.id_shop = id_shop;
    }

    public float getCoord_X() {
        return coord_X;
    }

    public void setCoord_X(float coord_X) {
        this.coord_X = coord_X;
    }

    public float getCoord_Y() {
        return coord_Y;
    }

    public void setCoord_Y(float coord_Y) {
        this.coord_Y = coord_Y;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id_shop='" + id_shop + '\'' +
                ", coord_X=" + coord_X +
                ", coord_Y=" + coord_Y +
                ", stocks=" + stocks +
                '}';
    }
}
