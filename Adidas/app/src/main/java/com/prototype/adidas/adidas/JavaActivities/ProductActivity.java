package com.prototype.adidas.adidas.JavaActivities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.prototype.adidas.adidas.RetroFiiit.controller.APIService;
import com.prototype.adidas.adidas.RetroFiiit.controller.DatabaseController;
import com.prototype.adidas.adidas.http.LoggedUser;
import com.prototype.adidas.adidas.http.Product;
import com.prototype.adidas.adidas.http.ServiceConnection;
import com.prototype.adidas.adidas.http.Tuple;
import static com.prototype.adidas.adidas.http.StaticMethods.LoadImageFromWebOperations;
import com.prototype.adidas.adidas.R;
import com.prototype.adidas.adidas.http.User;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.squareup.picasso.Picasso;

public class ProductActivity extends AppCompatActivity {

    private String scannedNCFmessage;
    private NfcAdapter nfcAdapter;
    private DatabaseController dbCont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        dbCont = DatabaseController.getInstance();

        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if (nfcAdapter == null || !nfcAdapter.isEnabled()) {
            finish();
            return;
        }

        Tag tag = getIntent().getParcelableExtra(NfcAdapter.EXTRA_TAG);
        if(tag != null) {
            Ndef ndef = Ndef.get(tag);
            try {
                ndef.connect();
                NdefMessage ndefMessage = ndef.getNdefMessage();
                scannedNCFmessage = new String(ndefMessage.getRecords()[0].getPayload());
                ndef.close();
            }
            catch (IOException | FormatException e) {
                e.printStackTrace();
            }
        }



         HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
// set your desired log level
        logging.setLevel(okhttp3.logging.HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
// add your other interceptors …
// add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-- this is the important line!
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://206.189.23.162/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

       APIService service = retrofit.create(APIService.class);

        service.getProduct(scannedNCFmessage).enqueue(new Callback<Product>() {


            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if (response.isSuccessful()) {

                    Product p = response.body();

                    String title = p.getName();
                    Float price = p.getPrice();

                    /*
                    String imgLink = p.getImage_link();
                    ImageView mainImage = findViewById(R.id.center_img_product);
                    Picasso.with(getApplicationContext()).load(imgLink).into(mainImage);
                    Drawable d = LoadImageFromWebOperations(imgLink, title);
                    Log.d("", String.valueOf(d==null));
                    //mainImage.setImageDrawable(d);
                    */

                    Drawable d = null;
                    switch(p.getId_product()) {
                        case "1":
                            d = getDrawable(R.drawable.product1);
                            break;
                        case "2":
                            d = getDrawable(R.drawable.product2);
                            break;
                        case "3":
                            d = getDrawable(R.drawable.product3);
                            break;
                        case "4":
                            d = getDrawable(R.drawable.product4);
                            break;
                        case "5":
                            d = getDrawable(R.drawable.product5);
                            break;
                    }
                    ImageView mainImage = findViewById(R.id.center_img_product);
                    mainImage.setImageDrawable(d);
                    mainImage.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(ProductActivity.this, Tobogan.class));
                        }
                    });



                    System.out.println("LOKOOO: " + p);

                }
                else System.out.println("\nRESPONSE NOT SUCCESSFUL");
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {

            }
        });

        System.out.println(LoggedUser.getInstance().getId_product());
        //Tuple t = LoggedUser.getInstance().comprar(scannedNCFmessage, "Adidas");
       // Product p = dbCont.get_Product(scannedNCFmessage);
        //String title = p.getName();
        //Float price = p.getPrice();
        //String imgLink = p.getImage_link();
        //System.out.println(imgLink);
        //ImageButton mainImage = findViewById(R.id.main_activity_profile_imgbtn);
        //mainImage.setImageDrawable(LoadImageFromWebOperations(imgLink, title));
    }
}
