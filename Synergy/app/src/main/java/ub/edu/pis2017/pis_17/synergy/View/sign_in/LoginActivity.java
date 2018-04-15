package ub.edu.pis2017.pis_17.synergy.View.sign_in;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ub.edu.pis2017.pis_17.synergy.View.main.MainActivity;
import ub.edu.pis2017.pis_17.synergy.R;

/**
 * Created by gerar on 26/03/2018.
 */

public class LoginActivity extends Activity {

    private TextView signInTxtvw;
    private Button logInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signInTxtvw = (TextView) findViewById(R.id.login_layout_signin_txtvw);
        signInTxtvw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignInActivity1.class));
            }
        });

        logInBtn = (Button) findViewById(R.id.login_layout_login_btn);
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {/*Do nothing*/}

}
