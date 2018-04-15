package ub.edu.pis2017.pis_17.synergy.View.main;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import ub.edu.pis2017.pis_17.synergy.View.post.NewOfferActivity;
import ub.edu.pis2017.pis_17.synergy.View.post.NewProjectActivity;
import ub.edu.pis2017.pis_17.synergy.View.post.NewRequestActivity;
import ub.edu.pis2017.pis_17.synergy.R;
import ub.edu.pis2017.pis_17.synergy.View.profile.UserProfileActivity;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private ImageButton profileButton;

    private MainActivityFragmentPagerAdapter pagerAdapter;
    private MainActivityListAdapterOR offerListAdapter;
    private MainActivityListAdapterOR requestListAdapter;
    private MainActivityListAdapterP projectListAdapter;

    private TabLayout tabLayout;
    private TextView offerTv;
    private TextView requestTv;
    private TextView projectTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.main_layout_viewpgr);
        toolbar = (Toolbar) findViewById(R.id.main_layout_tlb);
        fab = (FloatingActionButton) findViewById(R.id.main_layout_fab);
        profileButton = (ImageButton) findViewById(R.id.main_layout_profile_imgbtn);

        pagerAdapter = new MainActivityFragmentPagerAdapter(getSupportFragmentManager());
        MainActivityFragmentOR offerFragment = new MainActivityFragmentOR();
        MainActivityFragmentOR requestFragment = new MainActivityFragmentOR();
        MainActivityFragmentP projectFragment = new MainActivityFragmentP();
        offerListAdapter = new MainActivityListAdapterOR(this, new ArrayList<MainActivityListItemOR>(), getApplicationContext());
        requestListAdapter = new MainActivityListAdapterOR(this, new ArrayList<MainActivityListItemOR>(), getApplicationContext());
        projectListAdapter = new MainActivityListAdapterP(this, new ArrayList<MainActivityListItemP>(), getApplicationContext());
        offerFragment.setListAdapter(offerListAdapter);
        offerFragment.setPostType(0);
        requestFragment.setListAdapter(requestListAdapter);
        requestFragment.setPostType(1);
        projectFragment.setListAdapter(projectListAdapter);
        pagerAdapter.addFragment(offerFragment, "Fragment Offer");
        pagerAdapter.addFragment(requestFragment, "Fragment Request");
        pagerAdapter.addFragment(projectFragment, "Fragment Project");
        viewPager.setAdapter(pagerAdapter);
        refreshOfferList();
        refreshRequestList();
        refreshProjectList();

        tabLayout = (TabLayout) findViewById(R.id.main_layout_tablay);
        LinearLayout tabsContainer = (LinearLayout) tabLayout.getChildAt(0);
        LinearLayout item;
        item = (LinearLayout) tabsContainer.getChildAt(0);
        offerTv = (TextView) item.getChildAt(1);
        item = (LinearLayout) tabsContainer.getChildAt(1);
        requestTv = (TextView) item.getChildAt(1);
        item = (LinearLayout) tabsContainer.getChildAt(2);
        projectTv = (TextView) item.getChildAt(1);

        //Initial tab colors
        /*offerTv.setTextColor(getResources().getColor(R.color.colorOffer));
        requestTv.setTextColor(getResources().getColor(R.color.colorBackground));
        projectTv.setTextColor(getResources().getColor(R.color.colorBackground));
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorOffer));*/

        //Prepare Toolbar
        setSupportActionBar(toolbar);

        //Set Component Listeners
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            @Override
            public void onPageSelected(int position) {
                switch(viewPager.getCurrentItem()) {
                    case 0:
                        /*offerTv.setTextColor(getResources().getColor(R.color.colorOffer));
                        requestTv.setTextColor(getResources().getColor(R.color.colorBackground));
                        projectTv.setTextColor(getResources().getColor(R.color.colorBackground));
                        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorOffer));*/
                        break;
                    case 1:
                        /*offerTv.setTextColor(getResources().getColor(R.color.colorBackground));
                        requestTv.setTextColor(getResources().getColor(R.color.colorRequest));
                        projectTv.setTextColor(getResources().getColor(R.color.colorBackground));
                        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorRequest));*/
                        break;
                    case 2:
                        /*offerTv.setTextColor(getResources().getColor(R.color.colorBackground));
                        requestTv.setTextColor(getResources().getColor(R.color.colorBackground));
                        projectTv.setTextColor(getResources().getColor(R.color.colorTeams));
                        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorTeams));*/
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {}
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(viewPager.getCurrentItem()) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, NewOfferActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, NewRequestActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, NewProjectActivity.class));
                        break;
                }
            }
        });
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, UserProfileActivity.class));
            }
        });

    }

    // Inflate the menu; this adds items to the action bar if it is present.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        return true;
    }

    // Handle action bar item clicks here.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch(item.getItemId()) {
            case R.id.action_settings :
                //startActivity(new Intent(MainActivity.this, UserProfileActivity.class));
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {/*Do nothing*/}

    public void refreshOfferList() {
        offerListAdapter.clear();
        ArrayList<MainActivityListItemOR> listItems = new ArrayList<>();
        //Crear todos los items
        for(int i = 0; i < 50; i++) {
            listItems.add(new MainActivityListItemOR("Location", "OFFER TITLE", 134, getDrawable(R.drawable.logo)));
        }
        //
        offerListAdapter.addAll(listItems);
    }

    public void refreshRequestList() {
        requestListAdapter.clear();
        ArrayList<MainActivityListItemOR> listItems = new ArrayList<>();
        //Crear todos los items
        for(int i = 0; i < 50; i++) {
            listItems.add(new MainActivityListItemOR("Location", "REQUEST TITLE", 134, getDrawable(R.drawable.logo)));
        }
        //
        requestListAdapter.addAll(listItems);
    }

    public void refreshProjectList() {
        projectListAdapter.clear();
        ArrayList<MainActivityListItemP> listItems = new ArrayList<>();
        //Crear todos los items
        for(int i = 0; i < 50; i++) {
            listItems.add(new MainActivityListItemP("Location", "PROJECT TITLE", "Project Admin", 134, 6, 2, getDrawable(R.drawable.logo)));
        }
        //
        projectListAdapter.addAll(listItems);
    }
}
