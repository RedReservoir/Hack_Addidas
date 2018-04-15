package ub.edu.pis2017.pis_17.synergy.View.sign_in;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

import ub.edu.pis2017.pis_17.synergy.R;

/**
 * Created by gerar on 26/03/2018.
 */

public class SignInActivity2 extends Activity {

    private FloatingActionButton nextFab;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_layout_2);

        nextFab = (FloatingActionButton) findViewById(R.id.signin_layout_2_next_fab);
        nextFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignInActivity2.this, SignInActivity3.class);
                startActivity(i);
            }
        });
    }

}
