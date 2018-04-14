package com.prototype.adidas.adidas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity1 extends AppCompatActivity {

    private Toolbar toolbar;

    private ViewPager viewPager;
    private MainActivityFragmentPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        //Set toolbar buttons
        toolbar = (Toolbar) findViewById(R.id.main_activity1_tlb);
        setSupportActionBar(toolbar);

        //Set pager adapter
        viewPager = (ViewPager) findViewById(R.id.main_activity1_viewpgr);
        pagerAdapter = new MainActivityFragmentPagerAdapter(getSupportFragmentManager());
    }

    // Inflate the menu; this adds items to the action bar if it is present.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main1_appbar_menu, menu);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        return true;
    }

}
