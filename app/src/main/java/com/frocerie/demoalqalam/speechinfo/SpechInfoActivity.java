package com.frocerie.demoalqalam.speechinfo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.frocerie.demoalqalam.R;
import com.frocerie.demoalqalam.main_activity.FrontPage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SpechInfoActivity extends AppCompatActivity {

    //private static final String ur ="http://alqalamtrust.com";

    //private static final String uri = "https://alqalamtrust.com/image/speech_info/app_al_qalam-211.jpg";

    private static final String URL_DATa = "http://alqalamtrust.com/speech_info";

    private String speechInfo;
    private String TAG_Week ="SpechInfoActivity.class";

    //private  static final String URL_DATa = "http://alqalamtrust.com/notice_board";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    // private List<ListSpeechInfoItemModel> listItem;

    private ArrayList<ListSpeechInfoItemModel> arrayListItem;


    private View.OnClickListener speechitemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

                     try{

                         //String taggPath = speechInfo+"/"+view.getTag().toString();
                         String taggPath =view.getTag().toString();
                         Log.e(TAG_Week,"tagged path"+taggPath);

                         Intent intent = new Intent(SpechInfoActivity.this,SpeechInfoImageActivity.class);
                         intent.putExtra(SpeechInfoImageActivity.TAGGED_SPEECH,taggPath);
                         startActivity(intent);


                     }catch (Throwable e){
                         e.printStackTrace();
                     }



        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spech_info);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setRecyclerView();
    }


    private void setRecyclerView() {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(SpechInfoActivity.this));


        arrayListItem = new ArrayList<>();

        loadRecyclerViewData();
    }

    private void loadRecyclerViewData() {

        /*final ProgressDialog progressDialog = new ProgressDialog(SpechInfoActivity.this);
        progressDialog.setMessage("Loading Data......");
        progressDialog.show();*/


        if (isNetworkAvailable()){

            final ProgressDialog progressDialog = new ProgressDialog(SpechInfoActivity.this);
            progressDialog.setMessage("Loading Data......");
            progressDialog.show();

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                URL_DATa,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        progressDialog.dismiss();

                        //added if condition

                          if (TextUtils.isEmpty(response)){

                              return;
                          }


                        try {

                            JSONObject jsonObject = new JSONObject(response);

                            //added condition
                            if (jsonObject == null){

                                return;
                            }


                            JSONArray array = jsonObject.getJSONArray("details");

                            //added condition
                            if (array.length()<=0 || array == null){
                                return;
                            }

                            for (int i = 0; i < array.length(); i++) {

                                JSONObject o = array.getJSONObject(i);

                                //Added Condition for the Json Object
                                if (o.length() <= 0 || o == null){
                                    return;
                                }


                                //Logic to add the data and images coming from the sever to the Textview and imageView

                                ListSpeechInfoItemModel item = new ListSpeechInfoItemModel(
                                        o.getString("speech_infos"),
                                        o.getString("date"),
                                        o.getString("image")
                                );

                                //adding all the data to the ArrayList...
                                arrayListItem.add(item);

                            }

                            //Intializing the adapter for the recyclerView
                            //adapter = new SpeechInfoAdapter(arrayListItem, getApplicationContext());

                            //FisrMethos:: adapter = new SpeechInfoAdapter(arrayListItem,SpechInfoActivity.this);

                            adapter = new SpeechInfoAdapter(arrayListItem, speechitemClickListener, SpechInfoActivity.this);

                            //To improve the performance of the recyclerview we use recyclerView.setHasFixedSize(true);
                            recyclerView.setHasFixedSize(true);
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                progressDialog.dismiss();

                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(SpechInfoActivity.this);
        requestQueue.add(stringRequest);

    }else{
            //Toast.makeText(SpechInfoActivity.this,"Please Check  Internet Connection",Toast.LENGTH_SHORT).show();
            builderDialog(SpechInfoActivity.this).show();
        }
    }

    private AlertDialog.Builder builderDialog(SpechInfoActivity spechInfoActivity) {

        AlertDialog.Builder builder = new AlertDialog.Builder(spechInfoActivity);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You Need To Have Mobile Data or Wifi to accesss this. pess ok to Exit");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                startActivity(new Intent(SpechInfoActivity.this,FrontPage.class));

                //finish();
            }
        });

        return builder;



    }

    private boolean isNetworkAvailable() {

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activityNetworkInfo = connectivityManager.getActiveNetworkInfo();

        return activityNetworkInfo != null && activityNetworkInfo.isConnected();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if (i == R.id.home) {


            NavUtils.navigateUpFromSameTask(SpechInfoActivity.this);

        }


        return super.onOptionsItemSelected(item);
    }


}
