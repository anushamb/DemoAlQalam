package com.frocerie.demoalqalam.dua;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.frocerie.demoalqalam.duafrag.InvoDSixNineFragment;
import com.frocerie.demoalqalam.duafrag.InvoDsevOneFragment;
import com.frocerie.demoalqalam.duafrag.InvoDsevenFragment;
import com.frocerie.demoalqalam.R;

public class DeathInvocaActivity extends AppCompatActivity {

    ViewPager vpInvo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_death_invoca);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vpInvo = (ViewPager) findViewById(R.id.vpInvo);
        vpInvo.setAdapter(new InvocaAdapter(getSupportFragmentManager()));




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(DeathInvocaActivity.this);

        }




        return super.onOptionsItemSelected(item);
    }


    public  class InvocaAdapter extends FragmentPagerAdapter{


        public InvocaAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0){

                return  new InvoDSixNineFragment() ;
            }else if(position == 1){

                return  new InvoDsevenFragment();
            }else



            return new InvoDsevOneFragment() ;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }



}
