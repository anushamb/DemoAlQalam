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
import com.frocerie.demoalqalam.duafrag.SleeepWakeThiFragemt;
import com.frocerie.demoalqalam.duafrag.SleepWakeFirFragement;
import com.frocerie.demoalqalam.duafrag.SleepWakeForFragemnt;
import com.frocerie.demoalqalam.duafrag.SleepWakeSecFragement;

public class SleepWakeActvity extends AppCompatActivity {

    ViewPager vpSleeWak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_wake);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vpSleeWak = (ViewPager) findViewById(R.id.vpSleeWak);
        vpSleeWak.setAdapter(new SleepWakeAdapter(getSupportFragmentManager()));



    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(SleepWakeActvity.this);

        }




        return super.onOptionsItemSelected(item);
    }

    public class SleepWakeAdapter extends FragmentPagerAdapter{


        public SleepWakeAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0){


                return  new SleepWakeFirFragement();
            }else if (position == 1){


                return new SleepWakeSecFragement();
            }else if (position == 2){

                return new SleeepWakeThiFragemt();

            }else

                return new SleepWakeForFragemnt();
        }

        @Override
        public int getCount() {
            return 4;
        }
    }



}
