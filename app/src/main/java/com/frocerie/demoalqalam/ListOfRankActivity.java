package com.frocerie.demoalqalam;

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
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.frocerie.demoalqalam.model.PDFDetail;
import com.frocerie.demoalqalam.model.PDFModel;
import com.frocerie.demoalqalam.responseHandler.ResponseHandler;
import com.frocerie.demoalqalam.toppers_activity.ToppersNewActivity;
import com.frocerie.demoalqalam.utils.GeneralUtils;

import static com.frocerie.demoalqalam.toppers_activity.ExamToppersActivity.RANK_EXAM;

public class ListOfRankActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;

    ImageView first,second,third;

    //Button first,second,third;

    private String rankOrder;

    ProgressDialog progressDialog;


    private  String url = "http://alqalamtrust.com/exam_toppers/" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_rank);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rankOrder=getIntent().getStringExtra(RANK_EXAM);

        imageView = (ImageView) findViewById(R.id.imageView);


        first = (ImageView) findViewById(R.id.btFirst);
        first.setOnClickListener(ListOfRankActivity.this);
        first.setTag("1st_rank");

        second = (ImageView) findViewById(R.id.btSecond);
        second.setOnClickListener(ListOfRankActivity.this);
        second.setTag("2nd_rank");

        third = (ImageView) findViewById(R.id.btThird);
        third.setOnClickListener(ListOfRankActivity.this);
        third.setTag("3rd_rank");

     /*   first = (Button) findViewById(R.id.btFirst);
        first.setOnClickListener(ListOfRankActivity.this);
        first.setTag("1st_rank");

        second = (Button) findViewById(R.id.btSecond);
        second.setOnClickListener(ListOfRankActivity.this);
        second.setTag("2nd_rank");

        third = (Button) findViewById(R.id.btThird);
        third.setOnClickListener(ListOfRankActivity.this);
        third.setTag("3rd_rank");*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();



        if(id == R.id.home){

            NavUtils.navigateUpFromSameTask(ListOfRankActivity.this);

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {


        int id = view.getId();
        //Intent intent = new Intent(ListOfRankActivity.this,);
        String tag = view.getTag().toString();
        //intent.putExtra(RANK_ORDER, tag);

        switch (id) {

            case R.id.btFirst:
            case R.id.btSecond:
            case R.id.btThird:
                requestJsonPDf(tag);

                break;

        }


    }

    private void requestJsonPDf(String tag) {

        if (isNetworkAvailable()) {

            progressDialog = new ProgressDialog(ListOfRankActivity.this);
            progressDialog.setMessage("Loding File.....");
            progressDialog.show();


            StringRequest str = new StringRequest(Request.Method.GET,
                    url + rankOrder + "/" + tag,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            progressDialog.dismiss();

                            try {
                                if (TextUtils.isEmpty(response)) {
                                    return;
                                }

                                PDFModel pdfModel = ResponseHandler.getPdfModel(response);

                                if (pdfModel == null) {
                                    return;
                                }

                                if (pdfModel.getPDFDetails() == null || pdfModel.getPDFDetails().size() == 0) {
                                    return;
                                }

                                PDFDetail pdfDetail = pdfModel.getPDFDetails().get(0);

                                if (pdfDetail == null) {
                                    return;
                                }

                                String path = pdfDetail.getPdfPath();

                                if (TextUtils.isEmpty(path)) {
                                    return;
                                }

                            /*JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("details");
                            if (jsonArray.length()<=0) {
                                return;
                            }
                            JSONObject object = jsonArray.getJSONObject(0);

                            String path = object.getString("pdf_path");*/

                                path = "http://drive.google.com/viewerng/viewer?embedded=true&url=" + path;

                                GeneralUtils.launchUrlUsingChromeTab(ListOfRankActivity.this, path);


                            } catch (Throwable e) {
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

            RequestQueue requestQueue = Volley.newRequestQueue(ListOfRankActivity.this);
            requestQueue.add(str);
        }else{

            builderDialog(ListOfRankActivity.this).show();

        }
    }

    private AlertDialog.Builder builderDialog(ListOfRankActivity listOfRankActivity) {


        AlertDialog.Builder builder = new AlertDialog.Builder(listOfRankActivity);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You Need To Have Mobile Data or Wifi to accesss this. pess ok to Exit");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                startActivity(new Intent(ListOfRankActivity.this,ToppersNewActivity.class));

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


}
