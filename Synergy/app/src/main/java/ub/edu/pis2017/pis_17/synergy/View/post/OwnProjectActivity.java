package ub.edu.pis2017.pis_17.synergy.View.post;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import ub.edu.pis2017.pis_17.synergy.R;
import ub.edu.pis2017.pis_17.synergy.View.profile.AlienProfileActivity;
import ub.edu.pis2017.pis_17.synergy.View.profile.UserProfileActivity;

/**
 * Created by gerar on 27/03/2018.
 */

public class OwnProjectActivity extends AppCompatActivity {

    Toolbar toolbar;
    ListView vacantsListView;
    ProjectActivityListAdapter vacantsListAdapter;
    FloatingActionButton eraseFab;
    FloatingActionButton editFab;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alien_project);

        toolbar = (Toolbar) findViewById(R.id.alien_project_layout_tlb);
        initToolBar();

        vacantsListView = (ListView) findViewById(R.id.alien_project_layout_vacants_lstvw);
        final ArrayList<ProjectActivityListItem> vacantsListItems = new ArrayList<>();
        vacantsListAdapter = new ProjectActivityListAdapter(this, vacantsListItems, this.getApplicationContext());
        vacantsListView.setAdapter(vacantsListAdapter);
        refreshVacantsList();

        vacantsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProjectActivityListItem item = (ProjectActivityListItem) vacantsListView.getAdapter().getItem(position);
                switch(item.getState()) {
                    case 0: //Admin
                        startActivity(new Intent(OwnProjectActivity.this, UserProfileActivity.class));
                    case 1: //Not vacant
                        startActivity(new Intent(OwnProjectActivity.this, AlienProfileActivity.class));
                        break;
                    case 2: //Vacant
                        //No hacer nada
                        break;
                }
            }
        });

        eraseFab = (FloatingActionButton) findViewById(R.id.alien_project_layout_chat_fab);
        eraseFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Erase
            }
        });

        editFab = (FloatingActionButton) findViewById(R.id.alien_project_layout_chat_fab);
        editFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Edit
            }
        });

    }

    public void initToolBar(){
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSupportNavigateUp();
            }
        });
    }

    public void refreshVacantsList() {
        vacantsListAdapter.clear();
        ArrayList<ProjectActivityListItem> vacantsListItems = new ArrayList<>();
        //Crear todos los items
        vacantsListItems.add(new ProjectActivityListItem("Admin name","Project admin",0, getDrawable(R.drawable.ic_camera_48pt_2x)));
        for(int i = 0; i < 8; i++) {
            vacantsListItems.add(new ProjectActivityListItem("Username", "Frontend Developper", (i%2)+1, getDrawable(R.drawable.ic_camera_48pt_2x)));
        }
        //
        vacantsListAdapter.addAll(vacantsListItems);
    }

}
