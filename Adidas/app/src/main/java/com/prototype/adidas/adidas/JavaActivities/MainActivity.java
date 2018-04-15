package com.prototype.adidas.adidas.JavaActivities;

import android.content.Intent;
import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import com.prototype.adidas.adidas.http.Date;
import com.prototype.adidas.adidas.R;

import java.io.IOException;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private Toolbar toolbar;

    private ViewPager viewPager;
    private MainActivityFragmentPagerAdapter pagerAdapter;
    private MainActivityFragmentListAdapter fragmentListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set toolbar buttons
        tabLayout = (TabLayout) findViewById(R.id.main_activity_tablay);
        toolbar = (Toolbar) findViewById(R.id.main_activity_tlb);
        setSupportActionBar(toolbar);

        //Set pager adapter
        viewPager = (ViewPager) findViewById(R.id.main_activity_viewpgr);
        pagerAdapter = new MainActivityFragmentPagerAdapter(getSupportFragmentManager());

            //Create fragment 1
        MainActivityFragmentNFC fragmentNFC = new MainActivityFragmentNFC();
        fragmentNFC.setParentActivity(this);

            //Create fragment 2
        MainActivityFragmentList fragmentList = new MainActivityFragmentList();
        fragmentListAdapter = new MainActivityFragmentListAdapter(this, new ArrayList<MainActivityFragmentListItem>(), getApplicationContext());
        fragmentList.setListAdapter(fragmentListAdapter);
        fragmentList.setParentActivity(this);

            //Add fragments to the Pager Adapter
        pagerAdapter.addFragment(fragmentNFC, "NFC Fragment");
        pagerAdapter.addFragment(fragmentList, "List Fragment");
        viewPager.setAdapter(pagerAdapter);
        refreshItemList();

        //Set Component Listeners
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            @Override
            public void onPageSelected(int position) {}
            @Override
            public void onPageScrollStateChanged(int state) {}
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }

    // Inflate the menu; this adds items to the action bar if it is present.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main1_appbar_menu, menu);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        return true;
    }

    //Refreshes Item List
    public void refreshItemList() {
        fragmentListAdapter.clear();
        ArrayList<MainActivityFragmentListItem> listItems = new ArrayList<>();
        //Crear todos los items (PLACEHOLDER, sustituir con llamada a la BD
        for(int i = 0; i < 50; i++) {
            listItems.add(new MainActivityFragmentListItem("Product name", "€", 29.99f, new Date("18","04","2010"),  getDrawable(R.drawable.ic_camera_48pt_2x)));
        }
        //
        fragmentListAdapter.addAll(listItems);
    }

}
