package ub.edu.pis2017.pis_17.synergy.View.post;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import ub.edu.pis2017.pis_17.synergy.R;
import ub.edu.pis2017.pis_17.synergy.View.profile.AlienProfileActivity;

/**
 * Created by gerar on 27/03/2018.
 */

public class AlienProjectActivity extends AppCompatActivity {

    Toolbar toolbar;
    ListView vacantsListView;
    ProjectActivityListAdapter vacantsListAdapter;
    FloatingActionButton messageFab;
    FloatingActionButton flagFab;
    FloatingActionButton acceptFab;

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
                    case 0: //Admin (not you)
                        startActivity(new Intent(AlienProjectActivity.this, AlienProfileActivity.class));
                        break;
                    case 1: //Not vacant
                        startActivity(new Intent(AlienProjectActivity.this, AlienProfileActivity.class));
                        break;
                    case 2: //Vacant
                        //Enviar mensaje a admin de que quieres entrar
                        break;
                }
            }
        });

        messageFab = (FloatingActionButton) findViewById(R.id.alien_project_layout_chat_fab);
        messageFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO user una calse de AlertDialog:
                AlertDialog.Builder builder = new AlertDialog.Builder(AlienProjectActivity.this);
                builder.setTitle("Title");

                // Set up the input
                final EditText title = new EditText(AlienProjectActivity.this);
                final EditText message = new EditText(AlienProjectActivity.this);
                final LinearLayout layout = new LinearLayout(AlienProjectActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);
                title.setInputType(InputType.TYPE_CLASS_TEXT);
                title.setHint("Title");
                layout.addView(title);
                message.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_LONG_MESSAGE);
                message.setHint("Message");
                layout.addView(message);

                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                builder.setTitle("New Message")
                        .setView(layout)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("Cancel",  new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).show();
                //startActivity(new Intent(AlienProjectActivity.this, SendMessagePopup.class));
            }
        });

        flagFab = (FloatingActionButton) findViewById(R.id.alien_project_layout_flag_fab);
        flagFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Flag
            }
        });

        acceptFab = (FloatingActionButton) findViewById(R.id.alien_project_layout_accept_fab);
        acceptFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Accept
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
        vacantsListItems.add(new ProjectActivityListItem("Admin name","Project admin", 1 , getDrawable(R.drawable.ic_camera_48pt_2x)));
        for(int i = 0; i < 8; i++) {
            vacantsListItems.add(new ProjectActivityListItem("Username", "Frontend Developper", (i%2)+1, getDrawable(R.drawable.ic_camera_48pt_2x)));
        }
        //
        vacantsListAdapter.addAll(vacantsListItems);
    }

}
