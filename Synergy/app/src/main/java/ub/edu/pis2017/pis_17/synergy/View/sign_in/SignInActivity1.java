package ub.edu.pis2017.pis_17.synergy.View.sign_in;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ub.edu.pis2017.pis_17.synergy.R;

/**
 * Created by gerar on 26/03/2018.
 */

public class SignInActivity1 extends Activity {

    private Button confirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_layout_1);

        confirmBtn = (Button) findViewById(R.id.signin_layout_1_confirm_btn);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(new Intent(SignInActivity1.this, SignInActivity2.class));
                startActivity(i);
            }
        });
    }
}
