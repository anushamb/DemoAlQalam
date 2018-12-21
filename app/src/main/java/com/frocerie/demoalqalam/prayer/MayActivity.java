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

public class MayActivity extends AppCompatActivity implements VolleyResponse {


    private static final String url_main = "http://alqalamtrust.com/prayer_time/";

    private static final String url = url_main + "/" + "may";

    /*private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ImageModel> listItem;
    */

    ImageView touchImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_may);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        touchImageView = (ImageView) findViewById(R.id.ivMayTouch);
        RequestClass.callgetMethod(url,this);
        touchImageView.setVisibility(View.VISIBLE);



        /*recyclerView = (RecyclerView) findViewById(R.id.recyclerImageMay);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MayActivity.this));

        listItem = new ArrayList<>();

        loadImageViewData();*/
    }

    /*private void loadImageViewData() {


        final ProgressDialog progressDialog = new ProgressDialog(MayActivity.this);
        progressDialog.setMessage("Loading Data....");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        progressDialog.dismiss();

                        try{

                            JSONObject imgObj = new JSONObject(response);
                            ImageModel item = new ImageModel(imgObj.getString("details"));

                            listItem.add(item);


                            adapter = new ImageJanAdapter(listItem,getApplicationContext());

                            recyclerView.setAdapter(adapter);

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
        }
        );

        RequestQueue requestQueue = Volley.newRequestQueue(MayActivity.this);
        requestQueue.add(stringRequest);


    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(MayActivity.this);

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
