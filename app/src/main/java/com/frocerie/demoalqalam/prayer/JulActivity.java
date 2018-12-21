package com.frocerie.demoalqalam.prayer;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;

import com.frocerie.demoalqalam.R;
import com.frocerie.demoalqalam.imagemodel.TouchImageView;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class JulActivity extends AppCompatActivity implements VolleyResponse {


    private String url = "http://alqalamtrust.com/prayer_time/jul";

    ImageView touchImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jul);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        RequestClass.callgetMethod(url,this);
        touchImageView = (ImageView) findViewById(R.id.ivJulTouch);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(JulActivity.this);

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
