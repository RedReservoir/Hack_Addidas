package com.prototype.adidas.adidas.http;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public  class DataBController { //este hsera implementado

    private ServiceConnection service;
    public User user;

    //los atributos para la conexion
    public DataBController(){//parte de conexion del retrofit

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
// set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
// add your other interceptors …
// add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-- this is the important line!
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://206.189.23.162/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        service = retrofit.create(ServiceConnection.class);

/*
        //get user is the first thing we do
        service.getUser(id).enqueue(new Callback<User>() {


            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.isSuccessful()) user  = response.body();
                else System.out.println("\nRESPONSE NOT SUCCESSFUL");

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println("\nOn failure");
            }

        });
        */

    }


    public void getUser(String id){

        service.getUser(id).enqueue(new Callback<User>() {

            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) System.out.print(response.body());
                else System.out.println("\nRESPONSE NOT SUCCESSFUL");
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println("\nOn failure");
            }

        });

    }

  /*
    public List<Size> clothes_size(String id) //luego esto es un list del enum del edu
    {
        service.getSizeList(id).enqueue(new Callback<List<Size>>() {

            @Override
            public void onResponse(Call<List<Size>> call, Response<List<Size>> response) {
                if (response.isSuccessful()) user.setList_size(response.body());
                else System.out.println("\nRESPONSE NOT SUCCESSFUL");
            }

            @Override
            public void onFailure(Call<List<Size>> call, Throwable t) {
            t.printStackTrace();
            }
        });

        return user.getList_size();
    }

    public String ConsultCard(String id) //la manera de pagar un producto
    {
        service.getCard(id).enqueue(new Callback<Credit_card>() {

            @Override
            public void onResponse(Call<Credit_card> call, Response<Credit_card> response) {
                if (response.isSuccessful()) user.setCard(response.body());
                else System.out.println("\nRESPONSE NOT SUCCESSFUL");
            }

            @Override
            public void onFailure(Call<Credit_card> call, Throwable t) {
            t.printStackTrace();
            }
        });
        user.getCard();
    }
    public String ConsultGift(String id) //la manera de pagar un producto
    {
        service.getGift(id).enqueue(new Callback<Gift>() {

            @Override
            public void onResponse(Call<Gift> call, Response<Gift> response) {

                if (response.isSuccessful()) user.setGift(response.body());
                else System.out.println("\nRESPONSE NOT SUCCESSFUL");
            }

            @Override
            public void onFailure(Call<Gift> call, Throwable t) {
            t.printStackTrace();
            }
        });
        return null;
    }
    public List<Bought> list_boughts(String id){

        service(id)enqueue(new Callback<Gift>() {

            @Override
            public void onResponse(Call<Gift> call, Response<Gift> response) {

                if (response.isSuccessful()) user.setGift(response.body());
                else System.out.println("\nRESPONSE NOT SUCCESSFUL");
            }

            @Override
            public void onFailure(Call<Gift> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return null;
    }

    */


}
