package com.frocerie.demoalqalam.examhut;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.frocerie.demoalqalam.R;

import static com.frocerie.demoalqalam.examhut.ExamPoTiHutActivity.RANK_TAG;

public class ListOfClassButActivity extends AppCompatActivity implements View.OnClickListener {


    Button lkg, ukg, first, second, third, fourth, fifth, sixth, seventh, thajweedh, hifdh, batches;
    public static final String RANK_CLASS = "RANK_CLASS";

    private String rankTag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
  /*setContentView(R.layout.activity_list_of_button_new);*/

    setContentView(R.layout.activity_exam_hut_new_layout);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rankTag = getIntent().getStringExtra(RANK_TAG);
        //System.out.println("get :"+rankTag);


        setButton();
    }

    private void setButton() {


        lkg = (Button) findViewById(R.id.lkg);
        lkg.setOnClickListener(ListOfClassButActivity.this);
        lkg.setTag(rankTag+"/"+"LKG");


        ukg = (Button) findViewById(R.id.ukg);
        ukg.setOnClickListener(ListOfClassButActivity.this);
        ukg.setTag(rankTag+"/"+"UKG");


        first = (Button) findViewById(R.id.first);
        first.setOnClickListener(ListOfClassButActivity.this);
        first.setTag(rankTag+"/"+"1st_Std");


        second = (Button) findViewById(R.id.second);
        second.setOnClickListener(ListOfClassButActivity.this);
        second.setTag(rankTag+"/"+"2nd_Std");


        third = (Button) findViewById(R.id.third);
        third.setOnClickListener(ListOfClassButActivity.this);
        third.setTag(rankTag+"/"+"3rd_Std");


        fourth = (Button) findViewById(R.id.forth);
        fourth.setOnClickListener(ListOfClassButActivity.this);
        fourth.setTag(rankTag+"/"+"4th_Std");


        fifth = (Button) findViewById(R.id.fifth);
        fifth.setOnClickListener(ListOfClassButActivity.this);
        fifth.setTag(rankTag+"/"+"5th_Std");


        sixth = (Button) findViewById(R.id.sixth);
        sixth.setOnClickListener(ListOfClassButActivity.this);
        sixth.setTag(rankTag+"/"+"6th_Std");

        seventh = (Button) findViewById(R.id.seventh);
        seventh.setOnClickListener(ListOfClassButActivity.this);
        seventh.setTag(rankTag+"/"+"7th_Std");

        thajweedh = (Button) findViewById(R.id.thajweedh);
        thajweedh.setOnClickListener(ListOfClassButActivity.this);
        thajweedh.setTag(rankTag+"/"+"Tajweed");

        hifdh = (Button) findViewById(R.id.hifdh);
        hifdh.setOnClickListener(ListOfClassButActivity.this);
        hifdh.setTag("Hifd");


        //batches = (Button) findViewById(R.id.batches);
        //batches.setOnClickListener(ListOfClassButActivity.this);
        //batches.setTag("LKG");


    }

    @Override
    public void onClick(View view) {


        int id = view.getId();
        Intent intent = new Intent(ListOfClassButActivity.this, JsonRequestImage.class);
        String tag = view.getTag().toString();
       // System.out.println("Class"+tag);
        intent.putExtra(RANK_CLASS, tag);
      //  System.out.println("Class"+RANK_CLASS);

        switch (id) {

            case R.id.lkg:
            case R.id.ukg:
            case R.id.first:
            case R.id.second:
            case R.id.third:
            case R.id.forth:
            case R.id.fifth:
            case R.id.sixth:
            case R.id.seventh:
            case R.id.thajweedh:
            case R.id.hifdh:
            case R.id.batches:

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
