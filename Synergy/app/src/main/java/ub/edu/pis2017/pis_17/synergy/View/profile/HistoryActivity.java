package ub.edu.pis2017.pis_17.synergy.View.profile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import ub.edu.pis2017.pis_17.synergy.R;

/**
 * Created by manuellechasanchez on 25/03/2018.
 */

public class HistoryActivity extends AppCompatActivity{

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_layout);

        // placeholder
        HistoryPost p1, p2, p3;
        p1 = new HistoryPost("Title1",getDrawable(R.drawable.logo), "PLACEHOLDER","Barcelona1", 0, getDrawable(R.drawable.background_offer_lbl));
        p2 = new HistoryPost("Title2",getDrawable(R.drawable.logo),"PLACEHOLDER","Barcelona2",1,getDrawable(R.drawable.background_request_lbl));
        p3 = new HistoryPost("Title3",getDrawable(R.drawable.logo),"PLACEHOLDER","Barcelona3", 2, getDrawable(R.drawable.background_project_lbl));
        ArrayList<HistoryPost> hist = new ArrayList<>();
        hist.add(p1);
        hist.add(p2);
        hist.add(p3);
        HistoryPastAdapter histadapt = new HistoryPastAdapter(this, hist, true);
        ListView current = findViewById(R.id.history_lstvw_ongoing);
        current.setAdapter(histadapt);

        HistoryPastAdapter histadapt2 = new HistoryPastAdapter(this, hist, false);
        ListView past = findViewById(R.id.history_lstvw_done);
        past.setAdapter(histadapt2);
        ////

        initToolBar();
    }

    public void initToolBar(){
        toolbar = (Toolbar) findViewById(R.id.history_tlb);
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
