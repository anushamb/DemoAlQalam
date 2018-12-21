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
import com.frocerie.demoalqalam.duafrag.WitrQunutFirFragment;
import com.frocerie.demoalqalam.duafrag.WitrQunutSecFragment;
import com.frocerie.demoalqalam.duafrag.WitrQunutThrFragment;

public class WitrQunutActivityDua extends AppCompatActivity {


    ViewPager vpWitrQu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_witr_qunut_dua);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vpWitrQu = (ViewPager) findViewById(R.id.vpWitrQu);
        vpWitrQu.setAdapter(new WitrQunutAdapter(getSupportFragmentManager()));



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(WitrQunutActivityDua.this);

        }




        return super.onOptionsItemSelected(item);
    }

    public class WitrQunutAdapter extends FragmentPagerAdapter{


        public WitrQunutAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0){

                return new WitrQunutFirFragment();

            }else if (position == 1){

                return new WitrQunutSecFragment();

            }else

            return  new WitrQunutThrFragment();
        }

        @Override
        public int getCount() {
            return 3;
        }
    }





}
