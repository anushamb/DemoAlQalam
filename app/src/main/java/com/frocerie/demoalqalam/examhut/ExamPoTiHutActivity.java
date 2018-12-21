package com.frocerie.demoalqalam.examhut;

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
import com.frocerie.demoalqalam.examhut.model.ListOfClassPortionActivity;
import com.frocerie.demoalqalam.service_pack.MyIntentService;
import com.frocerie.demoalqalam.service_pack.UserSharedPreference;

import static com.frocerie.demoalqalam.R.id.ivExPo;
import static com.frocerie.demoalqalam.R.id.ivExTime;

public class ExamPoTiHutActivity extends AppCompatActivity implements View.OnClickListener {

   /* ImageView ivExPo,ivExTime;*/

    Button btExPo, btExTime;

    int examCurrentBadgeVal;

    public static final String RANK_TAG = "RANK_TAG";

    //Code to updating the badges values...

    Button btnExmPo,btnExmTime;
    UserSharedPreference userPre;
    Context cnt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_po_ti_hut);
        
        cnt = ExamPoTiHutActivity.this;
        userPre = new UserSharedPreference(cnt);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setButtons();
        
        setExamBadgeValues();

        LocalBroadcastManager.getInstance(ExamPoTiHutActivity.this).registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                setExamBadgeValues();

            }
        },new IntentFilter(MyIntentService.ACTION_EXMHUT_UPDATE_BROADCAST));


    }

    private void setExamBadgeValues() {

        if (userPre.getCurrentExamHutPortionBadgeVal() > 0){

            btnExmPo.setVisibility(View.VISIBLE);
            btnExmPo.setText(String.valueOf(userPre.getCurrentExamHutPortionBadgeVal()));
        }else
            btnExmPo.setVisibility(View.GONE);

        if (userPre.getCurrentExamHutTimeTableBadgeVal() > 0){

            btnExmTime.setVisibility(View.VISIBLE);
            btnExmTime.setText(String.valueOf(userPre.getCurrentExamHutTimeTableBadgeVal()));
        }else
            btnExmTime.setVisibility(View.GONE);

    }

    private void setButtons() {


        btExPo = (Button) findViewById(ivExPo);
        btExPo.setOnClickListener(ExamPoTiHutActivity.this);
        btExPo.setTag("portions");


        btExTime = (Button) findViewById(ivExTime);
        btExTime.setOnClickListener(ExamPoTiHutActivity.this);
        btExTime.setTag("Time_table");


        btnExmPo = (Button) findViewById(R.id.btn_badge_examtime);
        btnExmTime = (Button) findViewById(R.id.btn_badge_portion);


      /*  ivExPo = (ImageView) findViewById(ivExPo);
        ivExPo.setOnClickListener(ExamPoTiHutActivity.this);
        ivExPo.setTag("portions");


        ivExTime = (ImageView) findViewById(ivExTime);
        ivExTime.setOnClickListener(ExamPoTiHutActivity.this);
        ivExTime.setTag("Time_table");*/

    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        /*Intent intent = new Intent(ExamPoTiHutActivity.this, ListOfClassButActivity.class);*/
        String tag = view.getTag().toString();

        System.out.println("get tag" + view.getTag().toString());


        //System.out.println("Rank :"+tag);

       /* intent.putExtra(RANK_TAG, tag);*/
        //System.out.println("Rank :"+RANK_TAG);

        switch (id) {

            case ivExPo:
                examCurrentBadgeVal = userPre.getCurExamBadgeValue();
                if (examCurrentBadgeVal>0){
                    examCurrentBadgeVal = examCurrentBadgeVal -1;
                    userPre.setCurExamBadgeValue(examCurrentBadgeVal);
                }
                btnExmPo.setVisibility(View.GONE);
                Intent intent = new Intent(ExamPoTiHutActivity.this, ListOfClassPortionActivity.class);
                intent.putExtra(RANK_TAG, tag);
               // userPre.setExamHutPortionBadgeVal(0);
                //btnExmPo.setVisibility(View.GONE);
                startActivity(intent);
                break;
            case ivExTime:
                examCurrentBadgeVal = userPre.getCurExamBadgeValue();
                if (examCurrentBadgeVal>0){
                    examCurrentBadgeVal = examCurrentBadgeVal -1;
                    userPre.setCurExamBadgeValue(examCurrentBadgeVal);
                }
                btnExmTime.setVisibility(View.GONE);
                Intent inten = new Intent(ExamPoTiHutActivity.this, ListOfClassButActivity.class);
                inten.putExtra(RANK_TAG, tag);
               // userPre.setCurrentExamHutTimeTableBadgeVal(0);
              //  btnExmTime.setVisibility(View.GONE);
                startActivity(inten);
                break;


        }

    }


    @Override
    protected void onPause() {
        super.onPause();
        userPre.setCurrentActivity("EXM_HUT");
    }

    @Override
    protected void onResume() {
        super.onResume();
        userPre.setCurrentActivity("EXM_HUT");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.home) {

            NavUtils.navigateUpFromSameTask(this);

        }

        return super.onOptionsItemSelected(item);
    }
}
