package com.prototype.adidas.adidas.JavaActivities;

import android.app.Activity;
import android.content.Intent;
import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.prototype.adidas.adidas.R;

import java.io.IOException;

import static android.content.ContentValues.TAG;

public class MainActivityFragmentNFC extends Fragment {

    private Activity parentActivity;
    private RelativeLayout relativeLayout;
    private String scannedNCFmessage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_swipe_fragment_nfc, container, false);
        return view;
    }

        //relativeLayout = (RelativeLayout) view.findViewById(R.id.activity_main_swipe_fragment_nfc_nfc_rllay);
        //int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 320, parentActivity.getApplicationContext().getResources().getDisplayMetrics());
        //RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(height, height);
        //relativeLayout.setLayoutParams(params);
        //relativeLayout.setLayoutParams(params);

    public void setParentActivity(Activity parentActivity) {this.parentActivity = parentActivity;}

}
