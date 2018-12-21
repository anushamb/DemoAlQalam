package com.frocerie.demoalqalam.dua;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.frocerie.demoalqalam.R;

public class FastBreakingActivity extends AppCompatActivity {

    ViewPager vpFastBrk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_breaking);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vpFastBrk = (ViewPager) findViewById(R.id.vpFastBrk);
        vpFastBrk.setAdapter(new FastBreakAdapter(getSupportFragmentManager()));


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(FastBreakingActivity.this);

        }




        return super.onOptionsItemSelected(item);
    }


    public  class FastBreakAdapter extends FragmentPagerAdapter{


        public FastBreakAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0){

                return  new FastBrkFirstFragment();

            }else
                return new FastBreakSecondFragment();




        }

        @Override
        public int getCount() {
            return 2;
        }
    }


}
