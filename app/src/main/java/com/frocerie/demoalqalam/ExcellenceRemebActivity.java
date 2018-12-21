package com.frocerie.demoalqalam;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class ExcellenceRemebActivity extends AppCompatActivity {

    ViewPager mVpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excellence_remeb);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mVpager = (ViewPager) findViewById(R.id.vpExcell);
        mVpager.setAdapter(new ExcellenceRemebAdapter(getSupportFragmentManager()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(ExcellenceRemebActivity.this);

        }




        return super.onOptionsItemSelected(item);
    }

    public  class ExcellenceRemebAdapter extends FragmentPagerAdapter{


        public ExcellenceRemebAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if( position == 0){

                return new ExcelRemFirstFragment();
            }else if(position == 1){

                return  new ExcelRemSecondFragment();


            }else if(position == 2){


                return new ExcellRemThirdFragment();
            }else

                return new ExcellRemFourthFragment();


        }

        @Override
        public int getCount() {
            return 4;
        }
    }


}
