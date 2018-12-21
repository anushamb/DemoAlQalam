package com.frocerie.demoalqalam.examhut.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.frocerie.demoalqalam.R;
import com.frocerie.demoalqalam.examhut.JsonRequestImage;
import com.frocerie.demoalqalam.service_pack.UserSharedPreference;

import static com.frocerie.demoalqalam.examhut.ExamPoTiHutActivity.RANK_TAG;

public class ListOfClassPortionActivity extends AppCompatActivity implements View.OnClickListener {

    Button lkg, ukg, first, second, third, fourth, fifth, sixth, seventh, thajweedh, hifdh, batches;
    public static final String RANK_CLASS = "RANK_CLASS";

    private String rankTag;

    UserSharedPreference ups;
    Context cnt;


    Button btnPortionLkg,btnPortioukg,btnPortionFirst,btnPortionSecond,btnPortionThird,btnPortionForth,btnPortionFifth;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_class_portion);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rankTag = getIntent().getStringExtra(RANK_TAG);

        setButton();
    }

    private void setButton() {


        lkg = (Button) findViewById(R.id.portion_lkg);
        lkg.setOnClickListener(ListOfClassPortionActivity.this);
        lkg.setTag(rankTag+"/"+"LKG");


        ukg = (Button) findViewById(R.id.portion_ukg);
        ukg.setOnClickListener(ListOfClassPortionActivity.this);
        ukg.setTag(rankTag+"/"+"UKG");


        first = (Button) findViewById(R.id.portion_first);
        first.setOnClickListener(ListOfClassPortionActivity.this);
        first.setTag(rankTag+"/"+"1st_Std");


        second = (Button) findViewById(R.id.portion_second);
        second.setOnClickListener(ListOfClassPortionActivity.this);
        second.setTag(rankTag+"/"+"2nd_Std");


        third = (Button) findViewById(R.id.portion_third);
        third.setOnClickListener(ListOfClassPortionActivity.this);
        third.setTag(rankTag+"/"+"3rd_Std");


        fourth = (Button) findViewById(R.id.portion_forth);
        fourth.setOnClickListener(ListOfClassPortionActivity.this);
        fourth.setTag(rankTag+"/"+"4th_Std");


        fifth = (Button) findViewById(R.id.portion_fifth);
        fifth.setOnClickListener(ListOfClassPortionActivity.this);
        fifth.setTag(rankTag+"/"+"5th_Std");


        sixth = (Button) findViewById(R.id.portion_sixth);
        sixth.setOnClickListener(ListOfClassPortionActivity.this);
        sixth.setTag(rankTag+"/"+"6th_Std");

        seventh = (Button) findViewById(R.id.portion_seventh);
        seventh.setOnClickListener(ListOfClassPortionActivity.this);
        seventh.setTag(rankTag+"/"+"7th_Std");

        thajweedh = (Button) findViewById(R.id.portion_thajweedh);
        thajweedh.setOnClickListener(ListOfClassPortionActivity.this);
        thajweedh.setTag(rankTag+"/"+"Tajweed");

        hifdh = (Button) findViewById(R.id.portion_hifdh);
        hifdh.setOnClickListener(ListOfClassPortionActivity.this);
        hifdh.setTag("Hifd");


        //batches = (Button) findViewById(R.id.batches);
        //batches.setOnClickListener(ListOfClassButActivity.this);
        //batches.setTag("LKG");


    }


    @Override
    public void onClick(View view) {


        int id = view.getId();
        Intent intent = new Intent(ListOfClassPortionActivity.this, JsonRequestImage.class);
        String tag = view.getTag().toString();
        // System.out.println("Class"+tag);
        intent.putExtra(RANK_CLASS, tag);
        //  System.out.println("Class"+RANK_CLASS);

        switch (id) {

            case R.id.portion_lkg:
            case R.id.portion_ukg:
            case R.id.portion_first:
            case R.id.portion_second:
            case R.id.portion_third:
            case R.id.portion_forth:
            case R.id.portion_fifth:
            case R.id.portion_sixth:
            case R.id.portion_seventh:
            case R.id.portion_thajweedh:
            case R.id.portion_hifdh:
           /* case R.id.portion_hifdh:*/

                startActivity(intent);
                break;


        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();



        if(id == R.id.home){

            NavUtils.navigateUpFromSameTask(this);

        }

        return super.onOptionsItemSelected(item);
    }





}
