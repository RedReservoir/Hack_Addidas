package com.prototype.adidas.adidas.RetroFiiit.controller;
import java.util.List;

import com.prototype.adidas.adidas.http.User;

import com.prototype.adidas.adidas.http.Credit_card;
import com.prototype.adidas.adidas.http.Gift;
import com.prototype.adidas.adidas.http.Product;
import com.prototype.adidas.adidas.http.Shop;
import com.prototype.adidas.adidas.http.Size;
import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Query;

/**
 *
 @FormUrlEncoded For HTTP Petitions
 @Field para post
 */

public interface APIService {
    @GET("/GET/USER")
    Call<User> getUser(@Query("id_user") String id_user);

    @GET("GET/SIZES")
    Call<List<Size>> getSizeList(@Query("id_user") String id_user);

    @GET("GET/GIFT")
    Call <Gift> getGift(@Query("id_user") String id_user);

    @GET("GET/CARD")
    Call <Credit_card> getCard(@Query("id_user") String id_user);

    @GET("GET/PRODUCT")
    Call <Product> getProduct(@Query("id_product") String id_product);

    @GET("GET/SHOP")
    Call <Shop> getShop(@Query("id_shop") String id_shop);
}