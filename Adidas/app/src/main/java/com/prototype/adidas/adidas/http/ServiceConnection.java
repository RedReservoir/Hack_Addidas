package com.prototype.adidas.adidas.http;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServiceConnection {

    @GET("GET/USER")
    Call<User> getUser(@Query("id_user") String id_user);

    @GET("GET/SIZES")
    Call<List<Size>> getSizeList(@Query("id") String id);

    @GET("GET/GIFT")
    Call <Gift> getGift(@Query("id") String id);

    @GET("GET/CARD")
    Call <Credit_card> getCard(@Query("id") String id);


}
