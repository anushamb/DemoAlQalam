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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.frocerie.demoalqalam.main_activity.FrontPage;

import java.util.HashMap;
import java.util.Map;

public class FeedBackActivity extends AppCompatActivity implements View.OnClickListener {

    //TextView tvFeedback;
    String phonePattern = "^[+]?[0-9]{10,13}$";
    EditText etFeedBack, etNum;

    Button btSend;

    private String url_feedBack = "http://alqalamtrust.com/admin/feedback";

    //private  String mPassword,mFeedBack;
    private String mPhoneNum, mFeedBack;

    private String mPhone;

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        initial();
    }

    private void initial() {

        builder = new AlertDialog.Builder(FeedBackActivity.this);

        //etFeedBack holds the message filed.
        etFeedBack = (EditText) findViewById(R.id.etFeedBack);

        etNum = (EditText) findViewById(R.id.tvFeed);

        btSend = (Button) findViewById(R.id.btSend);
        btSend.setOnClickListener(this);

        //tvFeedBackholded the value of password.
        // tvFeedback = (TextView) findViewById(R.id.tvFeed);
        //Intent reciveIntent = getIntent();
        //String password = reciveIntent.getStringExtra("feedback");
        //tvFeedback.setText(password);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.home) {

            NavUtils.navigateUpFromSameTask(this);

        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view) {

        int id = view.getId();

        switch (id) {

            case R.id.btSend:
                sendRequest();
                break;


        }


    }

    private void sendRequest() {

        if (isNetworkAvailable()) {

            //Save the password and msg data into an String variables mPasword and mFeedback,
            //mPassword = tvFeedback.getText().toString();

            mPhoneNum = etNum.getText().toString();
            mFeedBack = etFeedBack.getText().toString();

            if (TextUtils.isEmpty(mPhone)) {
                etNum.setError("Please enetr PhoneNum");
                etFeedBack.setError("Plase enter Feedback Body");
                return;

            } else if (TextUtils.isEmpty(mFeedBack)) {
                etFeedBack.setError("Plase enter Feedback Body");
                return;

            }

            final ProgressDialog progressDialog = new ProgressDialog(FeedBackActivity.this);
            progressDialog.setMessage("Login is process......");
            progressDialog.show();

            //Logic to sending the data to the server.
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url_feedBack, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    progressDialog.dismiss();

                    if (response.contains("true")) {

                        //Now we are getting the reponse from the server..So set the AlertMsg..
                        builder.setTitle("Server Response");

                        builder.setMessage("Response:" + "FeedBack Message Sent Succesfuly");

                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                //Now setting the onClick option to the alert msg..when user click on it the FeedBack Msg will clear..
                                etFeedBack.setText("");

                            }
                        });

                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    } else {


                        Toast.makeText(FeedBackActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                    //Setting the AlertDiadlog Box....
                    //Showing the Dialog Msg...


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(FeedBackActivity.this, "Error.....", Toast.LENGTH_SHORT).show();
                    error.printStackTrace();

                }
            }) {
                //Sending data to the server within the String request for that we need to override the getParams() method.
                //getParams() has a return type as Map.


                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    //Create HasMap variable and specify the type of Key and Value pair,,here both are String values.

                    Map<String, String> params = new HashMap<String, String>();

                    //Putting the Information to the Map...The String value should same as the value which we stored in column...
                    params.put("mobile_number", mPhoneNum);
                    //params.put("password",mPassword);
                    params.put("feedback", mFeedBack);

                    //return the params value
                    return params;
                }
            };

            //Add StringRequest to the RequestQueue....
            FeedBackMySingleton.getInstance(FeedBackActivity.this).addToRequestQueue(stringRequest);


        }else{

            builderDialog(FeedBackActivity.this).show();

        }

    }

    private AlertDialog.Builder builderDialog(FeedBackActivity feedBackActivity) {
        AlertDialog.Builder build = new AlertDialog.Builder(feedBackActivity);
        build.setTitle("No Internet Connection");
        build.setMessage("You Need to have Mobile Data or WIFI to access .Prees OK to Exit");

        build.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                startActivity(new Intent(FeedBackActivity.this, FrontPage.class));


            }
        });
        return  build;

    }

    private boolean isNetworkAvailable() {

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnected();


    }

}















//To set the StringRequest to  Requestqueue we need MySingleTonClass : FeedBackSinglton..(Java Class)







    /*private void send() {

        new Send().execute();

    }*/

   /* private void getFeedBack() throws JSONException {

        mPassword = tvFeedback.getText().toString().trim();
        mFeedBack = etFeedBack.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url_feedBack, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(FeedBackActivity.this,response,Toast.LENGTH_SHORT).show();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(FeedBackActivity.this,error.toString(),Toast.LENGTH_SHORT).show();


            }
        }){
            






        };





    }
*/

   /*class Send extends AsyncTask<String,String,String>{


       @Override
       protected String doInBackground(String... urls) {










           return null;
       }
   }*/







