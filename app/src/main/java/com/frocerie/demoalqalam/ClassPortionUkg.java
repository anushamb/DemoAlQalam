package com.frocerie.demoalqalam;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ClassPortionUkg extends AppCompatActivity {

    String url = "http://alqalamtrust.com/exam_hut";

    String url_portion = "http://alqalamtrust.com/exam_hut/portions";

    String url_lkg = "http://alqalamtrust.com/exam_hut/portions/UKG";

    ImageView imageView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_portion_ukg);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView = (ImageView) findViewById(R.id.imageViewUkg);
        imgaeLoader();


    }

    private void imgaeLoader() {

        final ProgressDialog progressDialog = new ProgressDialog(ClassPortionUkg.this);
        progressDialog.setMessage("Loading Image");
        progressDialog.show();

        StringRequest str = new StringRequest(Request.Method.GET, url_lkg, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("details");
                    JSONObject object = jsonArray.getJSONObject(0);

                    String path = object.getString("image");

                    imageView.setImageResource(Integer.parseInt(path));



                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                progressDialog.dismiss();
                Toast.makeText(ClassPortionUkg.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


        RequestQueue requestqueue = Volley.newRequestQueue(ClassPortionUkg.this);
        requestqueue.add(str);




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(ClassPortionUkg.this);
        }
        return super.onOptionsItemSelected(item);
    }
}
