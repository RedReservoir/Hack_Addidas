package com.prototype.adidas.adidas.http;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.prototype.adidas.adidas.RetroFiiit.controller.*;

public class User {
    //Necessary metadata for declaring an attribute
    @SerializedName("id_user")
    @Expose
    private String id_user;

    @SerializedName("id_product")
    @Expose
    private Product id_product;

    @SerializedName("nom")
    @Expose
    private String name;

    @SerializedName("boughts")
    @Expose
    private String boughts;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("budget")
    @Expose
    private double budget;

    @SerializedName("gift")
    @Expose
    private String gift;

    @SerializedName("passwd")
    @Expose
    private String passwd;

    @SerializedName("surname")
    @Expose
    private String surname;

    public User(String id_user, String email, String passwd, String name, String surname) {
        this.id_user = id_user;
        this.name=name;
        this.email = email;
        this.passwd = passwd;
        this.surname = surname;
    }

    public User() {
    }

    public Tuple comprar(String id_p, String id_s){
        DatabaseController prueba = DatabaseController.getInstance();

        Product prodaux= prueba.get_Product(id_p);
        Shop shopaux=prueba.get_Shop(id_s);

        return new Tuple(prodaux,shopaux);
    }

    public Product getId_product() {
        return id_product;
    }

    public void setId_product(Product id_product) {
        this.id_product = id_product;
    }

    //Mandatory methods for declaring an attribute


    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getid_user() {
        return this.id_user;
    }

    public void setid_user(String id_user) {
        this.id_user = id_user;
    }

    public String getBoughts() {
        return boughts;
    }

    public void setBoughts(String boughts) {
        this.boughts = boughts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return id_user+' '+boughts+' '+email+' '+Double.toString(budget)+' '+gift+' '+passwd+' '+surname;
    }
}
