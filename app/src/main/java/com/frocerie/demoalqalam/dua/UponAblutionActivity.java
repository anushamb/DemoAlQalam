package com.frocerie.demoalqalam.dua;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.frocerie.demoalqalam.duafrag.DfourFragment;
import com.frocerie.demoalqalam.duafrag.DthreeFragment;
import com.frocerie.demoalqalam.duafrag.DtwoFragment;
import com.frocerie.demoalqalam.R;

public class UponAblutionActivity extends AppCompatActivity {

    ViewPager mUpon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upon_ablution);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mUpon = (ViewPager) findViewById(R.id.vpUpon);
        mUpon.setAdapter(new UponAblutionAdapter(getSupportFragmentManager()));
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(UponAblutionActivity.this);

        }




        return super.onOptionsItemSelected(item);
    }


    public  class UponAblutionAdapter extends FragmentPagerAdapter{


        public UponAblutionAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

         if (position == 0) {

             return new DtwoFragment();

         } else if (position == 1) {

             return  new DthreeFragment();

         }else {

             return  new DfourFragment();

         }

        }

        @Override
        public int getCount() {


            return 3;
        }
    }




}
