package com.frocerie.demoalqalam.dua;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.frocerie.demoalqalam.duafrag.DPutSixFiveFragment;
import com.frocerie.demoalqalam.duafrag.DPutSixSixFragment;
import com.frocerie.demoalqalam.R;

public class ClothesPutActivity extends AppCompatActivity {


    ViewPager mVput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes_put);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mVput = (ViewPager) findViewById(R.id.vpPutCloth);

        mVput.setAdapter(new ClothesPutAdapter(getSupportFragmentManager()));


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(ClothesPutActivity.this);

        }




        return super.onOptionsItemSelected(item);
    }





    public  class ClothesPutAdapter extends FragmentPagerAdapter{


        public ClothesPutAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if(position == 0){

                return  new DPutSixFiveFragment();
            }else


                return new DPutSixSixFragment();
        }

        @Override
        public int getCount() {
            return 2;
        }
    }



}
