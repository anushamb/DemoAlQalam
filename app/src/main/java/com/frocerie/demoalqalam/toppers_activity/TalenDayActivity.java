package com.frocerie.demoalqalam.toppers_activity;

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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.frocerie.demoalqalam.R;
import com.frocerie.demoalqalam.model.PDFDetail;
import com.frocerie.demoalqalam.model.PDFModel;
import com.frocerie.demoalqalam.responseHandler.ResponseHandler;
import com.frocerie.demoalqalam.utils.GeneralUtils;
import com.frocerie.demoalqalam.utils.ProgressUtils;

public class TalenDayActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView craftTalen,qeerathTalen,speechTalen,nasheedTalen,writtingTalen,sportsTalen;
    private final String url = "http://alqalamtrust.com/talentsday_toppers/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talen_day);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        intitImage();


    }

    private void intitImage() {

        craftTalen = (ImageView) findViewById(R.id.craftTalen);
        craftTalen.setOnClickListener(TalenDayActivity.this);
        craftTalen.setTag("Craft");

        qeerathTalen = (ImageView) findViewById(R.id.qeerathTalen);
        qeerathTalen.setOnClickListener(TalenDayActivity.this);
        qeerathTalen.setTag("Qeerat");


        speechTalen = (ImageView) findViewById(R.id.speechTalen);
        speechTalen.setOnClickListener(TalenDayActivity.this);
        speechTalen.setTag("Speech");

        nasheedTalen = (ImageView) findViewById(R.id.nasheedTalen);
        nasheedTalen.setOnClickListener(TalenDayActivity.this);
        nasheedTalen.setTag("Nasheed");

        writtingTalen = (ImageView) findViewById(R.id.writtingTalen);
        writtingTalen.setOnClickListener(TalenDayActivity.this);
        writtingTalen.setTag("Writing");

        sportsTalen = (ImageView) findViewById(R.id.sportsTalen);
        sportsTalen.setOnClickListener(TalenDayActivity.this);
        sportsTalen.setTag("Sports");


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();



        if(id == R.id.home){

            NavUtils.navigateUpFromSameTask(this);

        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view) {

        int idTale = view.getId();

        String tagTel = view.getTag().toString();

        switch (idTale){

            case R.id.craftTalen:
            case R.id.qeerathTalen:
            case R.id.speechTalen:
            case R.id.nasheedTalen:
            case R.id.writtingTalen:
            case R.id.sportsTalen:
                pdfRequestJson(tagTel);
                break;



        }




    }


    private void pdfRequestJson(String tag) {

        if (isNetworkAvailable()) {

            ProgressUtils.getInstance(TalenDayActivity.this).show("Loading file..");

            StringRequest stringRequest = new StringRequest(Request.Method.GET, url + tag, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    ProgressUtils.getInstance(TalenDayActivity.this).cancel();

                    if (TextUtils.isEmpty(response)) {

                        return;}

                    PDFModel pdfModel = ResponseHandler.getPdfModel(response);

                    if (pdfModel == null) {

                        return;
                    }

                /*    if (pdfModel.getPDFDetails() == null && pdfModel.getPDFDetails().size() <= 0) {*/

                    if (pdfModel.getPDFDetails() == null || pdfModel.getPDFDetails().size() <= 0) {

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

                    path = "http://drive.google.com/viewerng/viewer?embedded=true&url=" + path;

                    GeneralUtils.launchUrlUsingChromeTab(TalenDayActivity.this, path);


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {


                    ProgressUtils.getInstance(TalenDayActivity.this).cancel();

                }
            });


            RequestQueue requestQueue = Volley.newRequestQueue(TalenDayActivity.this);
            requestQueue.add(stringRequest);
        }else{
            builderDialog(TalenDayActivity.this).show();

        }

    }

    private AlertDialog.Builder builderDialog(TalenDayActivity talenDayActivity) {


        AlertDialog.Builder builder = new AlertDialog.Builder(talenDayActivity);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You Need To Have Mobile Data or Wifi to accesss this. pess ok to Exit");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                startActivity(new Intent(TalenDayActivity.this,ToppersNewActivity.class));

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
