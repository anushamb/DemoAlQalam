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
import com.frocerie.demoalqalam.duafrag.HajjSafaDeightFragment;
import com.frocerie.demoalqalam.duafrag.HajjSafaDsevFragment;
import com.frocerie.demoalqalam.duafrag.HajjsafaDsexfragment;

public class HajjSafaActivity extends AppCompatActivity {

    ViewPager vpHajjSafa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hajj_safa);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        vpHajjSafa = (ViewPager) findViewById(R.id.vpHajjSafa);

        vpHajjSafa.setAdapter(new HajjSafaAdapter(getSupportFragmentManager()));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(HajjSafaActivity.this);

        }




        return super.onOptionsItemSelected(item);
    }

    public  class HajjSafaAdapter extends FragmentPagerAdapter{


        public HajjSafaAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0){

                return  new HajjsafaDsexfragment();


            }else if (position == 1){

                return new HajjSafaDsevFragment();


            }
            return new HajjSafaDeightFragment();
        }

        @Override
        public int getCount() {
            return 3;
        }
    }




}
