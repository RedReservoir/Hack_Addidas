package ub.edu.pis2017.pis_17.synergy.View.profile;

/**
 * Created by manuellechasanchez on 24/03/2018.
 */

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import ub.edu.pis2017.pis_17.synergy.R;

public class UserProfileActivity extends AppCompatActivity{


    private ImageButton userProfile_imgbtn_editProfile;
    private ImageButton userProfile_imgbtn_inbox;
    private ImageButton userProfile_imgbtn_history;
    private ImageButton userProfile_imgbtn_settings;
    private ImageView userProfile_img_userImage;
    private TextView userProfile_txt_description;
    private Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        userProfile_imgbtn_editProfile = (ImageButton) findViewById(R.id.userProfile_imgbtn_editProfile);
        userProfile_imgbtn_inbox = (ImageButton) findViewById(R.id.userProfile_imgbtn_inbox);
        userProfile_imgbtn_history = (ImageButton) findViewById(R.id.userProfile_imgbtn_history);
        userProfile_imgbtn_settings = (ImageButton) findViewById(R.id.userProfile_imgbtn_settings);
        userProfile_img_userImage = (ImageView) findViewById(R.id.userProfile_img_userImage);
        userProfile_txt_description = (TextView) findViewById(R.id.userProfile_txt_description);

        initToolBar();

        userProfile_imgbtn_inbox.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        userProfile_imgbtn_inbox.setBackgroundColor(Color.parseColor("#F2F5A9"));
                        return true;
                    case MotionEvent.ACTION_UP:
                        userProfile_imgbtn_inbox.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Intent Inbox = new Intent(v.getContext(), InboxActivity.class);
                        startActivity(Inbox);
                        return true;
                }
                return false;
            }
        });

        userProfile_imgbtn_history.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        userProfile_imgbtn_history.setBackgroundColor(Color.parseColor("#F2F5A9"));
                        return true;
                    case MotionEvent.ACTION_UP:
                        userProfile_imgbtn_history.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Intent History = new Intent(v.getContext(), HistoryActivity.class);
                        startActivity(History);
                        return true;
                }
                return false;
            }
        });

        userProfile_imgbtn_editProfile.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        userProfile_imgbtn_editProfile.setBackgroundColor(Color.parseColor("#F2F5A9"));
                        return true;
                    case MotionEvent.ACTION_UP:
                        userProfile_imgbtn_editProfile.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Intent UserEdit = new Intent (v.getContext(), UserEditProfileActivity.class);
                        startActivityForResult(UserEdit, 0);
                        return true;
                }
                return false;
            }
        });


        userProfile_imgbtn_settings.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        userProfile_imgbtn_settings.setBackgroundColor(Color.parseColor("#F2F5A9"));
                        return true;
                    case MotionEvent.ACTION_UP:
                        userProfile_imgbtn_settings.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Intent Options = new Intent(v.getContext(), OpcionesActivity.class);
                        startActivity(Options);
                        return true;
                }
                return false;
            }
        });


    }

    public void initToolBar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    public void setUserImage(int newIMg){
        this.userProfile_img_userImage.setImageResource(newIMg);
    }

    public void setDescription(String description){
        this.userProfile_txt_description.setText(description);
    }




}
