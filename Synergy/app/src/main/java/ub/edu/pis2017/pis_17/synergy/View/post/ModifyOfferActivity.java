package ub.edu.pis2017.pis_17.synergy.View.post;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import ub.edu.pis2017.pis_17.synergy.R;

/**
 * Created by ruben on 27/03/2018.
 */

public class ModifyOfferActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_offer);

        Toolbar bar = findViewById(R.id.toolbar);
        setSupportActionBar(bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}