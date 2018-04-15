package ub.edu.pis2017.pis_17.synergy.View.post;

import android.os.Bundle;

import ub.edu.pis2017.pis_17.synergy.R;

/**
 * Created by kanales on 24/03/2018.
 */

public class NewProjectActivity extends NewPostActivity {
    @Override
    protected void setLayout() {
        setContentView(R.layout.activity_new_project);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.title_NewProject);
    }
}
