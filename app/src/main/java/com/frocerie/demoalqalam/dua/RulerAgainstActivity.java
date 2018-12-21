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
import com.frocerie.demoalqalam.duafrag.RulAgaFirstFragment;
import com.frocerie.demoalqalam.duafrag.RulAgaSecondFragment;

public class RulerAgainstActivity extends AppCompatActivity {

    ViewPager vpRulAga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruler_against);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vpRulAga = (ViewPager) findViewById(R.id.vpRulAga);
        vpRulAga.setAdapter(new RulerAgainstAdapter(getSupportFragmentManager()));


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(RulerAgainstActivity.this);

        }




        return super.onOptionsItemSelected(item);




    }

    public  class RulerAgainstAdapter extends FragmentPagerAdapter{


        public RulerAgainstAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0){

                return  new RulAgaFirstFragment();


            }else



            return new RulAgaSecondFragment();
        }

        @Override
        public int getCount() {
            return 2;
        }
    }



}
