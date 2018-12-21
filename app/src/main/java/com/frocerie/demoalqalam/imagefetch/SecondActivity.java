package com.frocerie.demoalqalam.imagefetch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.frocerie.demoalqalam.R;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class SecondActivity extends AppCompatActivity {

    private ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        imageView = (ImageView) findViewById(R.id.image_view);
        Intent intent = getIntent();
        String url = VolleyRequestClass.BaseUrl+intent.getStringExtra("className").substring(0,3);
        VolleyRequestClass.callGetMethod(url,this);
    }



    public void success(JSONObject object){

        try{

            System.out.println(object.getString("details")+"JasonResponse");

        } catch (JSONException e) {
            e.printStackTrace();
        }
       try{

           Picasso.with(this)
                   .load(object.getString("details").replace("https","http"))
                   .into(imageView);
       } catch (JSONException e) {
           e.printStackTrace();
       }
    }


 public void error(String Message){

 }





}
