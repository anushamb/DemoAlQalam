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
import com.frocerie.demoalqalam.duafrag.ReeSeekOneFragment;
import com.frocerie.demoalqalam.duafrag.ReeSeekSecFragmnet;

public class RepenAndSeekActivity extends AppCompatActivity {

    ViewPager vpReSee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repen_and_seek);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vpReSee = (ViewPager) findViewById(R.id.vpReSee);
        vpReSee.setAdapter(new RepenAndSeekAdapter(getSupportFragmentManager()));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(RepenAndSeekActivity.this);

        }




        return super.onOptionsItemSelected(item);




    }


    public  class RepenAndSeekAdapter extends FragmentPagerAdapter{


        public RepenAndSeekAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0){

                return new ReeSeekOneFragment();



            }else


            return new ReeSeekSecFragmnet();
        }

        @Override
        public int getCount() {
            return 2;
        }
    }




}
