package com.frocerie.demoalqalam.weeklyplan;

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
import com.frocerie.demoalqalam.adapter.WeekListAdapter;
import com.frocerie.demoalqalam.main_activity.PageLogActivity;
import com.frocerie.demoalqalam.model.WeekListSubModel;
import com.frocerie.demoalqalam.model.WeekPlanDetails;
import com.frocerie.demoalqalam.responseHandler.ResponseHandler;
import com.frocerie.demoalqalam.utils.ProgressUtils;

import java.util.ArrayList;
import java.util.List;

import static com.frocerie.demoalqalam.weeklyplan.WeeklyLessonPlanActivity.RANK_WEEK;

public class ListOfSubClass extends AppCompatActivity {

    private final String url_week = "http://alqalamtrust.com/lession_plan";

    //private final String url_mainlkg = url_lkg + "/" + "LKG";

    public   String rankWeek;

    private RecyclerView recyclerView;
    private WeekListAdapter weekListAdapter;
    private ArrayList<WeekPlanDetails> weekDetailArrayList = new ArrayList<>();
    private List<SubClassModel> listSubItem;

    private String TAG="ListOfSubClass.class";
    private View.OnClickListener weekItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            try {
                String taggedId = rankWeek+"/"+view.getTag().toString();
                Log.e(TAG,"tagged id "+taggedId);

                Intent intent=new Intent(ListOfSubClass.this,WeeklyPlanImageFetch.class);
                intent.putExtra(WeeklyPlanImageFetch.TAGGED_KEY,taggedId);
                startActivity(intent);

            } catch (Throwable e) {
                e.printStackTrace();
            }


        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_sub_class);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        rankWeek = getIntent().getStringExtra(RANK_WEEK);
        System.out.println("vlaue :"+rankWeek);

        if (savedInstanceState == null){

            //savedInstanceState = (Bundle) rankWeek;

            this.rankWeek = getIntent().getStringExtra(RANK_WEEK);

            //rankWeek = getIntent().getStringExtra(RANK_WEEK);

            System.out.println("SavedValu :" +savedInstanceState );

        }else{
             return;

        }



       /* //every item of the recyclerView has fix size
        recyclerView.setHasFixedSize(true);

        //need to set the LayoutManager of the recyclerview
        recyclerView.setLayoutManager(new LinearLayoutManager(ListOfSubClass.this));

        listSubItem = new ArrayList<>();
*/
        setupAdapter();

        loadSubClass();


    }

    private void setupAdapter() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerClassSub);
        weekListAdapter = new WeekListAdapter(weekDetailArrayList, weekItemClickListener);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(weekListAdapter);
        recyclerView.setLayoutManager(mLayoutManager);


    }

    private void loadSubClass() {
        if (isNetworkAvailable()) {

            ProgressUtils.getInstance(this).show("Loding SubClasses....");


            //final ProgressDialog progressDialog = new ProgressDialog(ListOfSubClass.this);
            //progressDialog.setMessage("Loading data.......");
            //progressDialog.show();

            StringRequest stringRequest = new StringRequest(Request.Method.GET, url_week + "/" + rankWeek,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {


                            try {

                                ProgressUtils.getInstance(ListOfSubClass.this).cancel();


                                if (TextUtils.isEmpty(response)) {

                                    return;
                                }

                                WeekListSubModel weekListSubModel = ResponseHandler.weeklyListSubModel(response);

                                if (weekListSubModel == null) {
                                    return;
                                }

                                if (weekListSubModel.getDetails() == null || weekListSubModel.getDetails().size() <= 0) {
                                    return;
                                }

                                weekListAdapter.setWeeKList(weekListSubModel.getDetails());

/*
                            JSONObject jsonOject = new JSONObject(response);
                            JSONArray array = jsonOject.getJSONArray("details");

                            for(int i=0;i<array.length();i++){

                                JSONObject o = array.getJSONObject(i);
                                SubClassModel item = new SubClassModel(
                                        o.getString("class_div"),
                                        o.getString("id")

                                );

                            listSubItem.add(item);


                            }

                            adapter = new ListOfSubClassAdapter(listSubItem,getApplicationContext());
                            recyclerView.setAdapter(adapter);*/


                            } catch (Throwable e) {
                                e.printStackTrace();
                            }


                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    ProgressUtils.getInstance(ListOfSubClass.this).cancel();
                    Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

            RequestQueue requQueue = Volley.newRequestQueue(ListOfSubClass.this);
            requQueue.add(stringRequest);

        }else{

            builderDialog(ListOfSubClass.this).show();
        }
    }

    private AlertDialog.Builder builderDialog(ListOfSubClass listOfSubClass) {


        AlertDialog.Builder builder = new AlertDialog.Builder(listOfSubClass);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You Need To Have Mobile Data or Wifi to accesss this. pess ok to Exit");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                startActivity(new Intent(ListOfSubClass.this,PageLogActivity.class));

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


        if (id == R.id.home) {

            NavUtils.navigateUpFromSameTask(ListOfSubClass.this);

        }

        return super.onOptionsItemSelected(item);
    }
}
