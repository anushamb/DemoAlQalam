package com.frocerie.demoalqalam.dua;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.frocerie.demoalqalam.duafrag.DeadDsevEightFragment;
import com.frocerie.demoalqalam.duafrag.DeadDsevFivFragment;
import com.frocerie.demoalqalam.duafrag.DeadDsevSevFragment;
import com.frocerie.demoalqalam.duafrag.DeadDsevSexFragment;
import com.frocerie.demoalqalam.R;

public class DeathDeadActivity extends AppCompatActivity {

    ViewPager mVDead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_death_dead);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mVDead = (ViewPager) findViewById(R.id.vpDeathDea);
        mVDead.setAdapter(new DeadAdapter(getSupportFragmentManager()));


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(DeathDeadActivity.this);

        }




        return super.onOptionsItemSelected(item);
    }







    public  class  DeadAdapter extends FragmentPagerAdapter{


        public DeadAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0){

                return  new DeadDsevFivFragment();
            }else if (position == 1){

                return  new DeadDsevSexFragment();
            }else if (position == 2) {
                return new DeadDsevSevFragment();
            }else

                return new DeadDsevEightFragment();





        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
