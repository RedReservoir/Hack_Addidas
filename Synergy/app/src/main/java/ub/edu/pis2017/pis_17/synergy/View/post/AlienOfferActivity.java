package ub.edu.pis2017.pis_17.synergy.View.post;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import ub.edu.pis2017.pis_17.synergy.R;
import ub.edu.pis2017.pis_17.synergy.View.profile.AlienProfileActivity;

/**
 * Created by ruben on 25/03/2018.
 */

public class AlienOfferActivity extends AppCompatActivity {
    private FloatingActionButton SendMessageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alien_offer);

        ImageView profileImage = findViewById(R.id.imageProfile_alien_offer);
        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(new Intent(AlienOfferActivity.this, AlienProfileActivity.class));
                startActivity(i);
            }
        });

        SendMessageButton = (FloatingActionButton) findViewById(R.id.alien_offer_layout_chat_fab);
        SendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO user una calse de AlertDialog:
                AlertDialog.Builder builder = new AlertDialog.Builder(AlienOfferActivity.this);
                builder.setTitle("Title");

                // Set up the input
                final EditText title = new EditText(AlienOfferActivity.this);
                final EditText message = new EditText(AlienOfferActivity.this);
                final LinearLayout layout = new LinearLayout(AlienOfferActivity.this);
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
                //startActivity(new Intent(AlienOfferActivity.this, SendMessagePopup.class));
            }
        });


    }
}