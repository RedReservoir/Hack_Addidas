package ub.edu.pis2017.pis_17.synergy.View.post;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import ub.edu.pis2017.pis_17.synergy.R;

/**
 * Created by ruben on 27/03/2018.
 */

public class SendMessagePopup extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_send_message);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(height*.6));
    }
}
