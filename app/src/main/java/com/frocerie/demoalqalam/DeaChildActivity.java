package com.frocerie.demoalqalam;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.frocerie.demoalqalam.duafrag.ChildDEightFragment;
import com.frocerie.demoalqalam.duafrag.ChildDnineFragment;

public class DeaChildActivity extends AppCompatActivity {

    ViewPager vpDchild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dea_child);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vpDchild = (ViewPager) findViewById(R.id.vpDchild);
        vpDchild.setAdapter(new DeaChildAdapter(getSupportFragmentManager()));



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(DeaChildActivity.this);

        }




        return super.onOptionsItemSelected(item);
    }

    public class DeaChildAdapter extends FragmentPagerAdapter{


        public DeaChildAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0){

                return  new ChildDnineFragment();
            }else
                return new ChildDEightFragment();
        }

        @Override
        public int getCount() {
            return 2;
        }
    }





}
