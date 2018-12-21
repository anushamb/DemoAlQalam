package com.frocerie.demoalqalam.speechinfo;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.android.volley.toolbox.StringRequest;
import com.frocerie.demoalqalam.R;
import com.frocerie.demoalqalam.imagemodel.TouchImageView;
import com.squareup.picasso.Picasso;

public class SpeechInfoImageActivity extends AppCompatActivity {

    //ImageView ivSpeImage;
    //TextView tvSpecHead,tvSpeDate;

    TouchImageView  ivSpeImage;


    public static final String TAGGED_SPEECH = "TAGGED_SPEECH";
    private String TAG_IMG = "SpeechInfoImageActivity";

    StringRequest tag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_info_image);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //tag = getIntent().getStringArrayExtra(TAGGED_SPEECH);



        intialize();


    }

    private void intialize() {

        ivSpeImage = (TouchImageView) findViewById(R.id.ivSpeImage);
        //tvSpecHead = (TextView) findViewById(R.id.tvSpecHead);
        //tvSpeDate = (TextView) findViewById(R.id.tvSpeDate);

         setExtraForViews();
    }


    private void setExtraForViews() {



        Picasso.with(getApplicationContext())
                .load(getIntent().getStringExtra(TAGGED_SPEECH))
                .into(ivSpeImage);
        //ivSpeImage.setImageResource(Integer.parseInt(getIntent().getStringExtra(TAGGED_SPEECH)));(Getting Crash)

        //getting the image from the Adapter class and adding it into the newly created Activity(Images,Head,Date)
        //ivSpeImage.setImageResource(getIntent().get("img_speech");

        //ivSpeImage.setImageResource(getIntent().getStringExtra("img_speech"));

        //tvSpecHead.setText(getIntent().getStringExtra("head_speech"));
        //tvSpeDate.setText(getIntent().getStringExtra("date_speech"));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if (i == R.id.home) {


            NavUtils.navigateUpFromSameTask(SpeechInfoImageActivity.this);

        }


        return super.onOptionsItemSelected(item);
    }

}
