package com.frocerie.demoalqalam.weeklyplan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.frocerie.demoalqalam.R;
import com.frocerie.demoalqalam.service_pack.MyIntentService;
import com.frocerie.demoalqalam.service_pack.UserSharedPreference;

public class  WeeklyLessonPlanActivity extends AppCompatActivity implements View.OnClickListener {


    Button weekLkg,weekUkg,weekFirst,weekSecond,weekThird,weekForth,weekFifth,weekSixth,weekSeventh;

    public  static  final String RANK_WEEK = "RANK_WEEK";

    //private String weekTag;

    // Code adding badges value for each of the class buttons

    int weekBadgeCurrent;

    Button btLkg, btUkg, btFirst, btSecond, btThird, btForth, btFifth, btSixth, btSeventh;
    UserSharedPreference userShared;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
   /*    setContentView(R.layout.activity_weekly_lesson_plan_new);*/

       setContentView(R.layout.activity_sub_class_layout_new);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context = WeeklyLessonPlanActivity.this;
        userShared = new UserSharedPreference(context);


        setWeekButton();

        setWeekBadgesValues();

        LocalBroadcastManager.getInstance(WeeklyLessonPlanActivity.this).registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                setWeekBadgesValues();

            }
        }, new IntentFilter(MyIntentService.ACTION_UPDATE_WEEKLY_BROADCAST));


    }

    private void setWeekBadgesValues() {

        if (userShared.getWeeklyLkgBadgeVal() > 0) {
            btLkg.setVisibility(View.VISIBLE);
            btLkg.setText(String.valueOf(userShared.getWeeklyLkgBadgeVal()));
        } else
            btLkg.setVisibility(View.GONE);


        if (userShared.getWeeklyUkgBadgeVal() > 0) {
            btUkg.setVisibility(View.VISIBLE);
            btUkg.setText(String.valueOf(userShared.getWeeklyUkgBadgeVal()));
        } else
            btUkg.setVisibility(View.GONE);


        if (userShared.getWeeklyFirstBadgeVal() > 0) {
            btFirst.setVisibility(View.VISIBLE);
            btFirst.setText(String.valueOf(userShared.getWeeklyFirstBadgeVal()));
        } else
            btFirst.setVisibility(View.GONE);


        if (userShared.getWeeklySecondBadgeVal() > 0) {
            btSecond.setVisibility(View.VISIBLE);
            btSecond.setText(String.valueOf(userShared.getWeeklySecondBadgeVal()));
        } else
            btSecond.setVisibility(View.GONE);


        if (userShared.getWeeklyThirdBadgeVal() > 0) {
            btThird.setVisibility(View.VISIBLE);
            btThird.setText(String.valueOf(userShared.getWeeklyThirdBadgeVal()));
        } else
            btThird.setVisibility(View.GONE);


        if (userShared.getWeeklyFourthBadgeVal() > 0) {
            btForth.setVisibility(View.VISIBLE);
            btForth.setText(String.valueOf(userShared.getWeeklyFourthBadgeVal()));
        } else
            btForth.setVisibility(View.GONE);


        if (userShared.getWeeklyFifthBadgeVal() > 0) {
            btFifth.setVisibility(View.VISIBLE);
            btFifth.setText(String.valueOf(userShared.getWeeklyFifthBadgeVal()));
        } else
            btFifth.setVisibility(View.GONE);


        if (userShared.getWeeklySixthBadgeVal() > 0) {
            btSixth.setVisibility(View.VISIBLE);
            btSixth.setText(String.valueOf(userShared.getWeeklySixthBadgeVal()));
        } else
            btSixth.setVisibility(View.GONE);


        if (userShared.getWeeklySevenBadgeVal() > 0) {
            btSeventh.setVisibility(View.VISIBLE);
            btSeventh.setText(String.valueOf(userShared.getWeeklySevenBadgeVal()));
        } else
            btSeventh.setVisibility(View.GONE);


    }

    private void setWeekButton() {

        weekLkg = (Button) findViewById(R.id.weekLkg);
        weekLkg.setOnClickListener(WeeklyLessonPlanActivity.this);
        weekLkg.setTag("LKG");


        weekUkg = (Button) findViewById(R.id.weekUkg);
        weekUkg.setOnClickListener(WeeklyLessonPlanActivity.this);
        weekUkg.setTag("UKG");


        weekFirst = (Button) findViewById(R.id.weekFirst);
        weekFirst.setOnClickListener(WeeklyLessonPlanActivity.this);
        weekFirst.setTag("1st_Std");


        weekSecond = (Button) findViewById(R.id.weekSecond);
        weekSecond.setOnClickListener(WeeklyLessonPlanActivity.this);
        weekSecond.setTag("2nd_Std");

        weekThird = (Button) findViewById(R.id.weekThird);
        weekThird.setOnClickListener(WeeklyLessonPlanActivity.this);
        weekThird.setTag("3rd_Std");

        weekForth = (Button) findViewById(R.id.weekForth);
        weekForth.setOnClickListener(WeeklyLessonPlanActivity.this);
        weekForth.setTag("4th_Std");

        weekFifth = (Button) findViewById(R.id.weekFifth);
        weekFifth.setOnClickListener(WeeklyLessonPlanActivity.this);
        weekFifth.setTag("5th_Std");

        weekSixth = (Button) findViewById(R.id.weekSixth);
        weekSixth.setOnClickListener(WeeklyLessonPlanActivity.this);
        weekSixth.setTag("6th_Std");

        weekSeventh = (Button) findViewById(R.id.weekSeventh);
        weekSeventh.setOnClickListener(WeeklyLessonPlanActivity.this);
        weekSeventh.setTag("7th_Std");

        btLkg = (Button) findViewById(R.id.btnWeekLkg);
        btUkg = (Button) findViewById(R.id.btnWeekUkg);
        btFirst = (Button) findViewById(R.id.btnWeekFirst);
        btSecond = (Button) findViewById(R.id.btnWeekSecond);
        btThird = (Button) findViewById(R.id.btnWeekThird);
        btForth = (Button) findViewById(R.id.btnWeekForth);
        btFifth = (Button) findViewById(R.id.btnWeekFifth);
        btSixth = (Button) findViewById(R.id.btnWeekSixth);
        btSeventh = (Button) findViewById(R.id.btnWeekSeventh);



    }

    @Override
    protected void onPause() {
        super.onPause();
        userShared.setCurrentActivity("WEEKLY_LESSON_PLAN");
    }

    @Override
    protected void onResume() {
        super.onResume();
        setWeekBadgesValues();
        userShared.setCurrentActivity("WEEKLY_LESSON_PLAN");
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();



        if(id == R.id.home){

            NavUtils.navigateUpFromSameTask(this);

        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view) {

        int i = view.getId();
        Intent intent = new Intent(WeeklyLessonPlanActivity.this, ListOfSubClass.class);
        String tag = view.getTag().toString();
        intent.putExtra(RANK_WEEK, tag);

        switch (i){



            case R.id.weekLkg:

               weekBadgeCurrent = userShared.getCurWeeklyBadgeValue();
                if (weekBadgeCurrent >0){
                    weekBadgeCurrent = weekBadgeCurrent - 1;
                    userShared.setCurWeeklyBadgeValue(weekBadgeCurrent);
                }

                userShared.setWeeklyLkgBadgeVal(0);
                btLkg.setVisibility(View.GONE);
                startActivity(intent);
                break;



            case R.id.weekUkg:
                weekBadgeCurrent = userShared.getCurWeeklyBadgeValue();
                if (weekBadgeCurrent > 0){
                    weekBadgeCurrent = weekBadgeCurrent - 1;
                    userShared.setCurWeeklyBadgeValue(weekBadgeCurrent);
                }
                userShared.setWeeklyUkgBadgeVal(0);
                btUkg.setVisibility(View.GONE);
                startActivity(intent);
                break;




            case R.id.weekFirst:

                weekBadgeCurrent = userShared.getCurWeeklyBadgeValue();
                if (weekBadgeCurrent > 0){
                    weekBadgeCurrent = weekBadgeCurrent - 1;
                    userShared.setCurWeeklyBadgeValue(weekBadgeCurrent);
                }
                userShared.setWeeklyFirstBadgeVal(0);
                btFirst.setVisibility(View.GONE);
                startActivity(intent);
                break;



            case R.id.weekSecond:

                weekBadgeCurrent = userShared.getCurWeeklyBadgeValue();
                if (weekBadgeCurrent > 0){
                    weekBadgeCurrent = weekBadgeCurrent - 1;
                    userShared.setCurWeeklyBadgeValue(weekBadgeCurrent);
                }
                userShared.setWeeklySecondBadgeVal(0);
                btSecond.setVisibility(View.GONE);
                startActivity(intent);
                break;


            case R.id.weekThird:
                weekBadgeCurrent = userShared.getCurWeeklyBadgeValue();
                if (weekBadgeCurrent > 0){
                    weekBadgeCurrent = weekBadgeCurrent - 1;
                    userShared.setCurWeeklyBadgeValue(weekBadgeCurrent);
                }

                userShared.setWeeklyThirdBadgeVal(0);
                btThird.setVisibility(View.GONE);
                startActivity(intent);
                break;


            case R.id.weekForth:

                weekBadgeCurrent = userShared.getCurWeeklyBadgeValue();
                if (weekBadgeCurrent > 0){
                    weekBadgeCurrent = weekBadgeCurrent - 1;
                    userShared.setCurWeeklyBadgeValue(weekBadgeCurrent);
                }

                userShared.setWeeklyFourthBadgeVal(0);
                btForth.setVisibility(View.GONE);
                startActivity(intent);
                break;


            case R.id.weekFifth:
                weekBadgeCurrent = userShared.getCurWeeklyBadgeValue();
                if (weekBadgeCurrent > 0){
                    weekBadgeCurrent = weekBadgeCurrent - 1;
                    userShared.setCurWeeklyBadgeValue(weekBadgeCurrent);
                }
                userShared.setWeeklyFifthBadgeVal(0);
                btFifth.setVisibility(View.GONE);
                startActivity(intent);
                break;


            case R.id.weekSixth:
                weekBadgeCurrent = userShared.getCurWeeklyBadgeValue();
                if (weekBadgeCurrent > 0){
                    weekBadgeCurrent = weekBadgeCurrent - 1;
                    userShared.setCurWeeklyBadgeValue(weekBadgeCurrent);
                }
                userShared.setWeeklySixthBadgeVal(0);
                btSixth.setVisibility(View.GONE);
                startActivity(intent);
                break;

            case R.id.weekSeventh:
                weekBadgeCurrent = userShared.getCurWeeklyBadgeValue();
                if (weekBadgeCurrent > 0){
                    weekBadgeCurrent = weekBadgeCurrent - 1;
                    userShared.setCurWeeklyBadgeValue(weekBadgeCurrent);
                }
                userShared.setWeeklySevenBadgeVal(0);
                btSeventh.setVisibility(View.GONE);
                startActivity(intent);
                break;



           /* case R.id.weekLkg:
                userShared.setWeeklyLkgBadgeVal(0);
                btLkg.setVisibility(View.GONE);
                startActivity(intent);
                break;*/



            /*case R.id.weekUkg:
                userShared.setWeeklyUkgBadgeVal(0);
                btUkg.setVisibility(View.GONE);
                startActivity(intent);
                break;*/
            /*case R.id.weekFirst:
                userShared.setWeeklyFirstBadgeVal(0);
                btFirst.setVisibility(View.GONE);
                startActivity(intent);
                break;*/
            /*case R.id.weekSecond:
                userShared.setWeeklySecondBadgeVal(0);
                btSecond.setVisibility(View.GONE);
                startActivity(intent);
                break;*/
            /*case R.id.weekThird:
                userShared.setWeeklyThirdBadgeVal(0);
                btThird.setVisibility(View.GONE);
                startActivity(intent);
                break;*/
           /* case R.id.weekForth:
                userShared.setWeeklyFourthBadgeVal(0);
                btForth.setVisibility(View.GONE);
                startActivity(intent);
                break;*/
            /*case R.id.weekFifth:
                userShared.setWeeklyFifthBadgeVal(0);
                btFifth.setVisibility(View.GONE);
                startActivity(intent);
                break;*/
            /*case R.id.weekSixth:
                userShared.setWeeklySixthBadgeVal(0);
                btSixth.setVisibility(View.GONE);
                startActivity(intent);
                break;*/
            /*case R.id.weekSeventh:
                userShared.setWeeklySevenBadgeVal(0);
                btSeventh.setVisibility(View.GONE);
                startActivity(intent);
                break;
*/
           /* case R.id.weekLkg :
            case R.id.weekUkg :
            case R.id.weekFirst :
            case R.id.weekSecond :
            case R.id.weekThird :
            case R.id.weekForth :
            case R.id.weekFifth :
            case R.id.weekSixth :
            case R.id.weekSeventh :

                startActivity(intent);
                break;*/



        }


    }
}
