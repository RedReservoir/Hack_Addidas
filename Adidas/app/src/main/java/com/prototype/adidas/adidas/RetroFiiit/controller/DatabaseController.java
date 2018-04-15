package com.prototype.adidas.adidas.RetroFiiit.controller;

import com.prototype.adidas.adidas.http.Credit_card;
import com.prototype.adidas.adidas.http.Gift;
import com.prototype.adidas.adidas.http.Product;
import com.prototype.adidas.adidas.http.Shop;
import com.prototype.adidas.adidas.http.Size;
import com.prototype.adidas.adidas.http.User;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class DatabaseController {
    private static final DatabaseController ourInstance = new DatabaseController();
    private APIService mAPIService;

    public static DatabaseController getInstance() {
        return ourInstance;
    }

    private DatabaseController() {
        mAPIService = ApiUtils.getAPIService();
    }

    //Methods to get data
    public User getUser(String id_user) {
        User userAux = new User();
        try {
            userAux = (User) (mAPIService.getUser(id_user).execute().body());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userAux;
    }

    public List<Size> get_clothes_size(String id) //luego esto es un list del enum del edu
    {
        List<Size> list = new LinkedList<>();
        try {

            list =  mAPIService.getSizeList(id).execute().body();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Gift get_gift(String id) //luego esto es un list del enum del edu
    {
        Gift list = new Gift();
        try {

            list =  mAPIService.getGift(id).execute().body();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    public Credit_card get_Card(String id) //luego esto es un list del enum del edu
    {
        Credit_card list = new Credit_card();
        try {

            list =  mAPIService.getCard(id).execute().body();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Product get_Product(String id) //luego esto es un list del enum del edu
    {
        Product list = new Product();
        try {

            list =  mAPIService.getProduct(id).execute().body();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Shop get_Shop(String id) //luego esto es un list del enum del edu
    {
        Shop list = new Shop();
        try {

            list =  mAPIService.getShop(id).execute().body();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
