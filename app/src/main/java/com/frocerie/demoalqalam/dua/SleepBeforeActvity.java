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
import com.frocerie.demoalqalam.duafrag.SleepBefoEighFragemt;
import com.frocerie.demoalqalam.duafrag.SleepBefoFirFragment;
import com.frocerie.demoalqalam.duafrag.SleepBefoFivFragment;
import com.frocerie.demoalqalam.duafrag.SleepBefoFortFragment;
import com.frocerie.demoalqalam.duafrag.SleepBefoSeconFragemnt;
import com.frocerie.demoalqalam.duafrag.SleepBefoSevFragemt;
import com.frocerie.demoalqalam.duafrag.SleepBefoSexFragment;
import com.frocerie.demoalqalam.duafrag.SleepBefoThirFragment;

public class SleepBeforeActvity extends AppCompatActivity {


    ViewPager vpSleepBe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_before_actvity);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        vpSleepBe = (ViewPager) findViewById(R.id.vpSleepBe);
        vpSleepBe.setAdapter(new SleepBeforeAdapter(getSupportFragmentManager()));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(SleepBeforeActvity.this);

        }




        return super.onOptionsItemSelected(item);




    }

    public  class SleepBeforeAdapter extends FragmentPagerAdapter{


        public SleepBeforeAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0){

                return  new SleepBefoFirFragment();//67-68
            }else if (position == 1){


              return new SleepBefoSeconFragemnt();//69-70

            }else  if (position == 2){

                return new SleepBefoThirFragment();//71-72

            }else  if (position == 3){

                return  new SleepBefoFortFragment();//73-74



            }else  if (position == 4){

                return  new SleepBefoFivFragment();//75-76
            }else if (position == 5){

                return  new SleepBefoSexFragment();//77-78



            }else if (position == 6){

                return  new SleepBefoSevFragemt();//79-80
            }else


                return new SleepBefoEighFragemt();//81
        }

        @Override
        public int getCount() {
            return 8;
        }
    };





}
