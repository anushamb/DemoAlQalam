package com.frocerie.demoalqalam.prayer;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.frocerie.demoalqalam.R;
import com.frocerie.demoalqalam.imagemodel.TouchImageView;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class AprActivity extends AppCompatActivity implements VolleyResponse {

    ImageView touchImageView;

    String url= "http://alqalamtrust.com/prayer_time/apr";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apr2);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        touchImageView = (ImageView) findViewById(R.id.ivMarTouch);


        RequestClass.callgetMethod(url,this);

        touchImageView.setVisibility(View.VISIBLE);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(AprActivity.this);

        }




        return super.onOptionsItemSelected(item);
    }

    @Override
    public void success(JSONObject object) {
        try {
            System.out.println(object.getString("details")+"JasonResponse");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            Picasso.with(getApplicationContext())
                    .load(object.getString("details").replace("https","http"))
                    .into(touchImageView);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void error(String Message) {

    }
}
