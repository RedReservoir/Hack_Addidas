package ub.edu.pis2017.pis_17.synergy.View.profile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import ub.edu.pis2017.pis_17.synergy.R;

/**
 * Created by manuellechasanchez on 24/03/2018.
 */


public class InboxActivity extends AppCompatActivity{

    private Toolbar toolbar;
    private ArrayList<MessageCategory> messageCategory;
    AdapterMessage adapterMessage;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox_layout);
        MessageCategory message1 = new MessageCategory("Manolito","Hola",getDrawable(R.drawable.logo),0,getDrawable(R.drawable.background_offer_lbl));
        MessageCategory message2 = new MessageCategory("Juanita","Bla Bla",getDrawable(R.drawable.logo),1,getDrawable(R.drawable.background_request_lbl));
        MessageCategory message3 = new MessageCategory("Pedrito","Campurrianas",getDrawable(R.drawable.logo),2,getDrawable(R.drawable.background_project_lbl));
        messageCategory = new ArrayList<MessageCategory>();
        messageCategory.add(message1);
        messageCategory.add(message2);
        messageCategory.add(message3);
        messageCategory.add(message1);
        messageCategory.add(message2);
        messageCategory.add(message3);
        messageCategory.add(message1);
        messageCategory.add(message2);
        messageCategory.add(message3);


        adapterMessage = new AdapterMessage(this, messageCategory);
        lv = (ListView) findViewById(R.id.inbox_lstvw_messages);
        lv.setAdapter(adapterMessage);

        initToolBar();

    }

    public void initToolBar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
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

