package com.frocerie.demoalqalam.examhut;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.frocerie.demoalqalam.R;
import com.frocerie.demoalqalam.examhut.model.ExamHuModel;
import com.frocerie.demoalqalam.examhut.model.ExamHutDetail;
import com.squareup.picasso.Picasso;

import static com.frocerie.demoalqalam.examhut.ListOfClassButActivity.RANK_CLASS;

public class JsonRequestImage extends AppCompatActivity {

    //private String url ="http://alqalamtrust.com/exam_hut/portions/";


    private String url ="http://alqalamtrust.com/exam_hut/";

    ImageView imageView;

   // TouchImageView touchImageView;

    //private ImageView imageView;

    private String rankClass;

    ProgressDialog progressDialog;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_request_image);

       // getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rankClass = getIntent().getStringExtra(RANK_CLASS);

        //imageView = (ImageView) findViewById(R.id.ivImageJson);

        imageView = (ImageView) findViewById(R.id.ivImageJson);

        imageView.setVisibility(View.VISIBLE);


        //touchImageView = (TouchImageView) findViewById(R.id.ivImageJson);

        requestImageJson();
    }

    private void requestImageJson() {

        if (isConnectionAvailable()) {


            progressDialog = new ProgressDialog(JsonRequestImage.this);
            progressDialog.setMessage("Loding Image.....");
            progressDialog.show();

            StringRequest str = new StringRequest(Request.Method.GET, url + rankClass, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    progressDialog.dismiss();

                    try {

                        if (TextUtils.isEmpty(response)) {
                            return;
                        }
                        ExamHuModel examModel = ResponseHand.getExamModel(response);
                        if (examModel == null) {
                            return;
                        }

                        if (examModel.getDetails() == null || examModel.getDetails().size() == 0) {
                            return;
                        }

                        ExamHutDetail examDetail = examModel.getDetails().get(0);
                        if (examDetail == null) {
                            return;
                        }

                        String path = examDetail.getImage();

                        if (TextUtils.isEmpty(path)) {
                            return;
                        }

                        Picasso.with(JsonRequestImage.this)
                                .load(path.replace("https", "http"))
                                .into(imageView);

                        //.into(imageView);


                    } catch (Throwable e) {
                        e.printStackTrace();
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    progressDialog.dismiss();

                }
            });


            RequestQueue requestQueue = Volley.newRequestQueue(JsonRequestImage.this);
            requestQueue.add(str);

        }else{


            builderDialog(JsonRequestImage.this).show();
        }






    }

    private AlertDialog.Builder builderDialog(JsonRequestImage jsonRequestImage) {


        AlertDialog.Builder builder = new AlertDialog.Builder(jsonRequestImage);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You Need To Have Mobile Data or Wifi to accesss this. Press OK to Exit");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                startActivity(new Intent(JsonRequestImage.this,ListOfClassButActivity.class));

                //finish();
            }
        });

        return builder;

    }

    private boolean isConnectionAvailable() {

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activityNetworkInfo = connectivityManager.getActiveNetworkInfo();

        return activityNetworkInfo != null && activityNetworkInfo.isConnected();


    }


 /*   @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();



        if(id == R.id.home){

            NavUtils.navigateUpFromSameTask(this);

        }

        return super.onOptionsItemSelected(item);
    }*/
}
