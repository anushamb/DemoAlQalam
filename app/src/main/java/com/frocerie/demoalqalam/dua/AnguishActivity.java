package com.frocerie.demoalqalam.dua;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.frocerie.demoalqalam.duafrag.DfiveEightFragment;
import com.frocerie.demoalqalam.duafrag.DfiveNineFragment;
import com.frocerie.demoalqalam.duafrag.DfiveSevenFragment;
import com.frocerie.demoalqalam.duafrag.DfiveSixFragment;
import com.frocerie.demoalqalam.R;

public class AnguishActivity extends AppCompatActivity {

    ViewPager mVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anguish);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mVp = (ViewPager) findViewById(R.id.vpAnguish);
        mVp.setAdapter(new AnguishAdapter(getSupportFragmentManager()));


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(AnguishActivity.this);

        }




        return super.onOptionsItemSelected(item);
    }


   public class AnguishAdapter extends FragmentPagerAdapter{


       public AnguishAdapter(FragmentManager fm) {
           super(fm);
       }

       @Override
       public Fragment getItem(int position) {

           if (position == 0){

               return new DfiveSixFragment();

           }else if(position == 1){

               return new DfiveSevenFragment();

           }else  if(position == 2){

               return new DfiveEightFragment();

           }else {

               return new DfiveNineFragment();
           }

       }

       @Override
       public int getCount() {
           return 4;
       }
   }
}
