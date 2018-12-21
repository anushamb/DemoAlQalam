package com.frocerie.demoalqalam;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by avocet on 06/06/17.
 */

public class ExamHutAdapter extends FragmentStatePagerAdapter {

    private String[] titles = {"PORTION","TIME-TABLE"};


    public ExamHutAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {

        switch (position){

            case 0:

               // return  new ExamPortionFragment();
                return  new FragmentPortion();

            case 1:
               // return new FragmentTimeTabe();
            return new FragmentTimeTable();  //need to chage the new Fragment FragmentTimeTabe() Not working...packegename (imagefetch)
        }



        return null;
    }



    @Override
    public int getCount() {
        return titles.length;
    }


   public CharSequence getPageTitle(int position){

       return titles[position];

   }


}
