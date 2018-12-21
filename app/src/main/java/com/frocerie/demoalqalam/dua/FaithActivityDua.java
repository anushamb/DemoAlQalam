package com.frocerie.demoalqalam.dua;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.frocerie.demoalqalam.duafrag.FaithDFirstFragment;
import com.frocerie.demoalqalam.duafrag.FaithDSeeFragment;
import com.frocerie.demoalqalam.R;

public class FaithActivityDua extends AppCompatActivity {

    ViewPager vpFaith;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faith_dua);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vpFaith = (ViewPager) findViewById(R.id.vpFaith);
        vpFaith.setAdapter(new FaithAdapter(getSupportFragmentManager()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(FaithActivityDua.this);

        }




        return super.onOptionsItemSelected(item);
    }


    public  class  FaithAdapter extends FragmentPagerAdapter{


        public FaithAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0){

                return new FaithDSeeFragment();
            }else


            return new FaithDFirstFragment();
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
