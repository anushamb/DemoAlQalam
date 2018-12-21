package com.frocerie.demoalqalam.toppers_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.frocerie.demoalqalam.ListOfRankActivity;
import com.frocerie.demoalqalam.R;

public class ExamToppersActivity extends AppCompatActivity implements View.OnClickListener {


    ImageView firstExam, secondExam, thirdExam;
    //public static final String RANK_ORDER = "RANK_ORDER";

    public static final String RANK_EXAM = "RANK_EXAM";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_toppers);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        clickIntia();


    }

    private void clickIntia() {

        firstExam = (ImageView) findViewById(R.id.firstExam);
        firstExam.setOnClickListener(ExamToppersActivity.this);
        firstExam.setTag("1st_term");

        secondExam = (ImageView) findViewById(R.id.secondExam);
        secondExam.setOnClickListener(ExamToppersActivity.this);
        secondExam.setTag("2nd_term");


        thirdExam = (ImageView) findViewById(R.id.thirdExam);
        thirdExam.setOnClickListener(ExamToppersActivity.this);
        thirdExam.setTag("3rd_term");





    }
/*
    private void intia() {

        firstExam = (ImageView) findViewById(R.id.firstExam);
        firstExam.setOnClickListener(ExamToppersActivity.this);
        firstExam.setTag("1st_term");


        secondExam = (ImageView) findViewById(R.id.secondExam);
        secondExam.setOnClickListener(ExamToppersActivity.this);
        secondExam.setTag("2nd_term");


        thirdExam = (ImageView) findViewById(R.id.thirdExam);
        thirdExam.setOnClickListener(ExamToppersActivity.this);
        thirdExam.setTag("3rd_term");

    }*/


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();



        if(id == R.id.home){

            NavUtils.navigateUpFromSameTask(this);

        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {


        int idTag = v.getId();
        Intent intent = new Intent(getApplicationContext(), ListOfRankActivity.class);
        String tagExam = v.getTag().toString();
        intent.putExtra(RANK_EXAM,tagExam);

        switch (idTag){

            case R.id.firstExam :
            case R.id.secondExam:
            case R.id.thirdExam:
                startActivity(intent);
                break;


        }


/*
        int id = v.getId(); 

        Intent intent = new Intent(getApplicationContext(),ListOfRankActivity.class);
        String tag = v.getTag().toString();
        intent.putExtra(RANK_EXAM,tag);

        switch (id){

            case R.id.first :
            case R.id.second :
            case R.id.third :
                startActivity(intent);

                break;

        }*/


    }
}
