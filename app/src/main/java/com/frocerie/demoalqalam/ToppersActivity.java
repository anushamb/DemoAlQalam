package com.frocerie.demoalqalam;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;

public class ToppersActivity extends AppCompatActivity implements ActionBar.TabListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toppers);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewPager page = (ViewPager) findViewById(R.id.page);
        page.setAdapter(new ToppersAdapter(getSupportFragmentManager()));

        PagerSlidingTabStrip tab = (PagerSlidingTabStrip) findViewById(R.id.tabPager);

        tab.setViewPager(page);


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();



        if(id == R.id.home){

            NavUtils.navigateUpFromSameTask(ToppersActivity.this);

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        Log.d("Main","onTabSelected at"+"position"+tab.getPosition()+"name"+tab.getText());

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        Log.d("Main","onTabUnSelected at"+"position"+tab.getPosition()+"name"+tab.getText());

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        Log.d("Main","onTabReSelected at"+"position"+tab.getPosition()+"name"+tab.getText());

   }
}
