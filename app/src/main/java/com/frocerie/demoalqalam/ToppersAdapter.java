package com.frocerie.demoalqalam;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by avocet on 10/06/17.
 */

public class ToppersAdapter extends FragmentStatePagerAdapter {

    private String[] titleTopper = {"EXAM-TOPPERS","TALENSDAY-TOPPERS"};




    public ToppersAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){

            case 0:
                return  new FragementExam();
            case 1:
                return  new FragmentTalensDay();

        }


        return null;
    }

    @Override
    public int getCount() {

        return titleTopper.length;
    }
    @Override
    public CharSequence getPageTitle(int position) {

        return titleTopper[position];
    }

}
