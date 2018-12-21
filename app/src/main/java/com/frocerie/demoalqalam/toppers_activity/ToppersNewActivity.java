package com.frocerie.demoalqalam.toppers_activity;

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
import android.widget.TextView;

import com.frocerie.demoalqalam.R;
import com.frocerie.demoalqalam.service_pack.MyIntentService;
import com.frocerie.demoalqalam.service_pack.UserSharedPreference;

public class ToppersNewActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvExamTopper,tvTopperTalens;

    Button btnExamTopper,btnTopperTalens;
    Context context;
    UserSharedPreference userSpref;

    int examBadeValueDec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toppers_new);

        context = ToppersNewActivity.this;
        userSpref = new UserSharedPreference(context);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        initia();

        setBadgesExamVal();

        LocalBroadcastManager.getInstance(ToppersNewActivity.this).registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

            }
        },new IntentFilter(MyIntentService.ACTION_UPDATE_EXAM_TOPPER_TALE));



    }

    private void setBadgesExamVal() {

        if (userSpref.getExamToppersBadgeVal()>0){
            btnExamTopper.setVisibility(View.VISIBLE);
            btnExamTopper.setText(String.valueOf(userSpref.getExamToppersBadgeVal()));
        }else
            btnExamTopper.setVisibility(View.GONE);


        if (userSpref.getToppersTalensBadgeVal()>0){
            btnTopperTalens.setVisibility(View.VISIBLE);
            btnTopperTalens.setText(String.valueOf(userSpref.getToppersTalensBadgeVal()));
        }
        btnTopperTalens.setVisibility(View.GONE);

    }

    private void initia() {



        tvExamTopper = (TextView) findViewById(R.id.tvExamTopper);
        tvExamTopper.setOnClickListener(ToppersNewActivity.this);

        tvTopperTalens = (TextView) findViewById(R.id.tvTopperTalens);
        tvTopperTalens.setOnClickListener(ToppersNewActivity.this);

        btnExamTopper = (Button) findViewById(R.id.btn_badge_exam_topper);
        btnTopperTalens = (Button) findViewById(R.id.btn_badge_exam_talen_top);

    }


    @Override
    protected void onPause() {
        super.onPause();
        userSpref.setCurrentActivity("TOPPERS_TALENS");
    }

    @Override
    protected void onResume() {
        super.onResume();
        userSpref.setCurrentActivity("TOPPERS_TALENS");
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

        switch (i){

            case R.id.tvExamTopper :
            examBadeValueDec = userSpref.getCurToppersBadgeValue();
                if (examBadeValueDec > 0){
                    examBadeValueDec = examBadeValueDec - 1;
                    userSpref.setCurToppersBadgeValue(examBadeValueDec);
                }
                userSpref.setExamToppersBadgeVal(0);

                btnExamTopper.setVisibility(View.GONE);
                startActivity(new Intent(ToppersNewActivity.this,ExamToppersActivity.class));


                break;

            case R.id.tvTopperTalens :
             examBadeValueDec = userSpref.getCurToppersBadgeValue();
                if (examBadeValueDec > 0){
                    examBadeValueDec = examBadeValueDec - 1;
                    userSpref.setCurToppersBadgeValue(examBadeValueDec);
                }
                userSpref.setExamTalensBadgeVal(0);
                btnTopperTalens.setVisibility(View.GONE);
                startActivity(new Intent(ToppersNewActivity.this,TalenDayActivity.class));

                break;


        }



    }
}
