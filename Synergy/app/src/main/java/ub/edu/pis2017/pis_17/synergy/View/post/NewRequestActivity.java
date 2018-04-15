package ub.edu.pis2017.pis_17.synergy.View.post;

import android.os.Bundle;

import ub.edu.pis2017.pis_17.synergy.R;

public class NewRequestActivity extends NewPostActivity {
    @Override
    protected void setLayout() {
        setContentView(R.layout.activity_new_request);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.title_NewRequest);
    }

}
