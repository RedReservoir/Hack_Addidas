package ub.edu.pis2017.pis_17.synergy.View.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import ub.edu.pis2017.pis_17.synergy.R;
import ub.edu.pis2017.pis_17.synergy.View.post.SendMessagePopup;

/**
 * Created by manuellechasanchez on 24/03/2018.
 */


public class AlienProfileActivity extends AppCompatActivity{

    private Toolbar toolbar;
    private ImageButton SendMessageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alien_profile);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SendMessageButton = (ImageButton) findViewById(R.id.alienProfile_imgbtn_chatButton);
        SendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AlienProfileActivity.this, SendMessagePopup.class));
            }
        });


    }

    public void initToolBar(){
        toolbar = (Toolbar) findViewById(R.id.alienProfile_tlb);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSupportNavigateUp();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
