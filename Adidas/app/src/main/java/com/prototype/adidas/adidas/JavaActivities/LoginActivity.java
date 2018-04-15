package com.prototype.adidas.adidas.JavaActivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.prototype.adidas.adidas.R;
import com.prototype.adidas.adidas.RetroFiiit.controller.DatabaseController;
import com.prototype.adidas.adidas.http.LoggedUser;
import com.prototype.adidas.adidas.http.User;

public class LoginActivity extends Activity {

    private TextView signInTxtvw;
    private Button logInBtn;

    private TextInputEditText userTxtietxt;
    private TextInputEditText passTxtietxt;

    private TextView incorrectTxtvw;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userTxtietxt = (TextInputEditText) findViewById(R.id.login_layout_username_txtietxt);
        passTxtietxt = (TextInputEditText) findViewById(R.id.login_layout_password_txtietxt);

        incorrectTxtvw = (TextView) findViewById(R.id.login_layout_problem_txtvw);

        signInTxtvw = (TextView) findViewById(R.id.login_layout_signin_txtvw);
        signInTxtvw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });

        logInBtn = (Button) findViewById(R.id.login_layout_login_btn);
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = String.valueOf(userTxtietxt.getText());
                String password = String.valueOf(passTxtietxt.getText());
                LoggedUser.setUser(DatabaseController.getInstance().getUser(username));
                if(LoggedUser.getInstance() != null) {
                    finish();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
                else {
                    incorrectTxtvw.setText("INCORRECT USER!!!!");
                }
            }
        });
    }

    @Override
    public void onBackPressed() {/*Do nothing*/}

}
