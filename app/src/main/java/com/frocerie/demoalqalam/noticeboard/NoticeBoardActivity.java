package com.frocerie.demoalqalam.noticeboard;

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
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.frocerie.demoalqalam.R;
import com.frocerie.demoalqalam.main_activity.PageLogActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NoticeBoardActivity extends AppCompatActivity {


    private static final String URL_DATA = "http://alqalamtrust.com/notice_board";

    private RecyclerView recyclerView;
    private  RecyclerView.Adapter adapter;

    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_board);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewNotice);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(NoticeBoardActivity.this));

        listItems = new ArrayList<>();

        loadRecyclerViewData();




    }

    private void loadRecyclerViewData() {

        if (isNetworkAvailable()) {

            final ProgressDialog progressDialog = new ProgressDialog(NoticeBoardActivity.this);
            progressDialog.setMessage("Loading Data.....");
            progressDialog.show();


            StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            progressDialog.dismiss();

                            if (TextUtils.isEmpty(response)){
                                return;
                            }


                            //Writing the code for Json

                            try {

                                JSONObject jsonObject = new JSONObject(response);

                                if (jsonObject == null || jsonObject.length()<=0){
                                    return;
                                }

                                JSONArray array = jsonObject.getJSONArray("details");

                                if (array.length()<=0){
                                    return;
                                }


                                for (int i = 0; i < array.length(); i++) {

                                    JSONObject o = array.getJSONObject(i);

                                    //Removing this line will getting data in ListView.....
                                    /*if (o.length()<=0||o.isNull("null")){
                                        return;
                                    }*/

                                    if (o.length()<=0){
                                        return;
                                    }
                                    ListItem item = new ListItem(
                                            o.getString("notice_subject"),
                                            o.getString("date"),
                                            o.getString("notice_info")


                                    );


                                    listItems.add(item);

                                }

                                adapter = new NoticeBoardAdapter(listItems, getApplicationContext());//depends on MyAdapter constructor
                                recyclerView.setAdapter(adapter);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(NoticeBoardActivity.this);
            requestQueue.add(stringRequest);


        }else{

            builderDialog(NoticeBoardActivity.this).show();
        }




    }

    private AlertDialog.Builder builderDialog(NoticeBoardActivity noticeBoardActivity) {

        AlertDialog.Builder builder = new AlertDialog.Builder(noticeBoardActivity);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You Need To Have Mobile Data or Wifi to accesss this. pess ok to Exit");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                startActivity(new Intent(NoticeBoardActivity.this,PageLogActivity.class));

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

        int id = item.getItemId();



        if(id == R.id.home){

            NavUtils.navigateUpFromSameTask(NoticeBoardActivity.this);

        }

        return super.onOptionsItemSelected(item);
    }
}
