package com.prototype.adidas.adidas.http;

public class Credit_card {
    private String name_card, num_card;
    private Date due_card;

    public Credit_card(String name_card, String num_card, Date due_card) {
        this.name_card = name_card;
        this.num_card = num_card;
        this.due_card = due_card;
    }

    public Credit_card() {
    }

    public Credit_card(String name_card) {
        this.name_card = name_card;
    }

    public String getName_card() {
        return name_card;
    }

    public void setName_card(String name_card) {
        this.name_card = name_card;
    }

    public String getNum_card() {
        return num_card;
    }

    public void setNum_card(String num_card) {
        this.num_card = num_card;
    }

    public Date getDue_card() {
        return due_card;
    }

    public void setDue_card(Date due_card) {
        this.due_card = due_card;
    }
}
