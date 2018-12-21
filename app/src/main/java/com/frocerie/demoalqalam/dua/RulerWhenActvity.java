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
import com.frocerie.demoalqalam.duafrag.RulWhnFirstFragment;
import com.frocerie.demoalqalam.duafrag.RulWhnSecondFragment;
import com.frocerie.demoalqalam.duafrag.RulWhnThrFragment;

public class RulerWhenActvity extends AppCompatActivity {


    ViewPager vpRuWhn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruler_when);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        vpRuWhn = (ViewPager) findViewById(R.id.vpRuWhn);
        vpRuWhn.setAdapter(new RulerWhenAdapter(getSupportFragmentManager()));

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(RulerWhenActvity.this);

        }




        return super.onOptionsItemSelected(item);




    }



    public  class RulerWhenAdapter extends FragmentPagerAdapter{


        public RulerWhenAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0){

                return  new RulWhnFirstFragment();



            }else  if (position == 1){


                return new RulWhnSecondFragment();
            }else



            return new RulWhnThrFragment();
        }

        @Override
        public int getCount() {
            return 3;
        }
    }


}
