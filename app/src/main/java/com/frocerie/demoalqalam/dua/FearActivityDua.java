package com.frocerie.demoalqalam.dua;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.frocerie.demoalqalam.duafrag.FearPeopleFragmnet;
import com.frocerie.demoalqalam.duafrag.FearShirkFragment;
import com.frocerie.demoalqalam.R;

public class FearActivityDua extends AppCompatActivity {


    ViewPager vpFear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fear_dua);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vpFear = (ViewPager) findViewById(R.id.vpFear);
        vpFear.setAdapter(new FearAdapter(getSupportFragmentManager()));




    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(FearActivityDua.this);

        }




        return super.onOptionsItemSelected(item);
    }



    public  class FearAdapter extends FragmentPagerAdapter{


        public FearAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0) {

                return new FearPeopleFragmnet();


            } else
                return new FearShirkFragment();

        }


            @Override
        public int getCount() {

                return 2;
        }
    }



}
