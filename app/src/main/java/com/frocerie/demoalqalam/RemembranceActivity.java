package com.frocerie.demoalqalam;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class RemembranceActivity extends AppCompatActivity {

    ViewPager vpRem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remembrance);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        vpRem =(ViewPager) findViewById(R.id.vpRem);

        vpRem.setAdapter(new RemembranceAdapter(getSupportFragmentManager()));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(RemembranceActivity.this);

        }




        return super.onOptionsItemSelected(item);
    }



    public  class RemembranceAdapter extends FragmentPagerAdapter{


        public RemembranceAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0) {

                return new DfiveFragment(); //D5

            }else if(position == 1) {

                return  new DsixFragment(); //D6

            }else if( position == 2) {

                return new DsevenFragment();//D7


            }else if(position == 3) {
                return new DeightFragment();  //D8

            }else  if(position == 4) {

                return  new DnineFragment(); //D9


            }else if(position == 5) {


                return   new DtenFragment(); //D10


            }else if(position == 6) {

                return  new DelevFragment();  //D11


            }else if(position == 7) {

                return new DtwlFragment();  //D12


            }else  if(position ==8) {

                return new DthrtyFragment();   //D13


            }else if(position == 9) {

                return  new DfrtyFragment();   //D14


            }else if(position == 10) {

                return   new DfvftynnFragment();   //D15.........11page


            }else if(position == 11) {

                return  new DsextynFragment();  //D16.....12


            }else if(position == 12) {

                return new DsevntynFragment();  //D17.....13


            }else if(position == 13) {

                return new DeightynFragment();  //D18......14


            }else if (position == 14) {

                return  new DnyntynFragmnet(); //D19......15


            }else  if(position == 15) {

                return   new DtwntynFragment();  //D20./.......16


            }else  if(position == 16) {

                return  new DtwntyOneFragment();  //D21.....17


            }else  if (position == 17) {

                return new DtwntyTwoFragment();  //D22........18


            }else if(position == 18) {

                return new DtwntyThrFragment(); //D23..............19


            }else if (position == 19) {
                return  new DtwntyFourFragmnet(); //D24.............20


            }else  if(position == 20) {

                return   new DtwntyFiveFragment(); //D25........21


            }else  if (position == 21) {

                return  new DtwntySexFragment();  //D26...22


            }else  if(position == 22) {

                return new DtwntySevenFragment(); //D27....23


            }else  if (position == 23) {

                return new DtwntyEightFragment();  //D28...24

            }else if (position == 24) {

                return  new DtwntyNineFragmnet();   //D29....25


            }else if (position == 25) {

                return   new DtrtyFragment();   //D30


            }

            return null;

        }

        @Override
        public int getCount() {
            return 26;
        }
    }
}
