package com.frocerie.demoalqalam;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.frocerie.demoalqalam.adapter.ImageJanAdapter;
import com.frocerie.demoalqalam.model.ImageModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ClassPortionLkg extends AppCompatActivity {

    String url = "http://alqalamtrust.com/exam_hut";

    String url_portion = "http://alqalamtrust.com/exam_hut/portions";

    String url_lkg = "http://alqalamtrust.com/exam_hut/portions/UKG";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ImageModel> listImage;

   // String puString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_portion_lkg);


          //Bundle extra = getIntent().getExtras();

            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerImageLkg);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(ClassPortionLkg.this));

        //puString = extra.getString("LKG");
        //recyclerView.setTag(puString);

        listImage = new ArrayList<>();
        loadRecyclerViewData();


    }

    private void loadRecyclerViewData() {

        final ProgressDialog progressDialog = new ProgressDialog(ClassPortionLkg.this);
        progressDialog.setMessage("Loading Image");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url_lkg, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                progressDialog.dismiss();

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("details");
                    for(int i=0;i<array.length();i++){

                        JSONObject o = array.getJSONObject(i);
                        ImageModel imageItem = new ImageModel(o.getString("image"));

                        listImage.add(imageItem);

                      adapter =  new ImageJanAdapter(listImage,getApplicationContext());
                        recyclerView.setAdapter(adapter);


                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(ClassPortionLkg.this);
        requestQueue.add(stringRequest);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(ClassPortionLkg.this);
        }
        return super.onOptionsItemSelected(item);
    }
}
