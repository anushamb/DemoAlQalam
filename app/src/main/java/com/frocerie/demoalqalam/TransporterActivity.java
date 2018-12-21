package com.frocerie.demoalqalam;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebView;
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

public class TransporterActivity extends AppCompatActivity {


    String url = "http://alqalamtrust.com/transports";

    WebView webView;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transporter);

        webView = (WebView) findViewById(R.id.webViewTrans);
        pdfJsonRequest();

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




    }

    private void pdfJsonRequest() {

        progressDialog  = new ProgressDialog(TransporterActivity.this);
        progressDialog.setMessage("Loding File.....");
        progressDialog.show();


        StringRequest str = new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        progressDialog.dismiss();

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("details");
                            JSONObject object = jsonArray.getJSONObject(0);

                            String path = object.getString("pdf_path");

                            webView.getSettings().setJavaScriptEnabled(true);
                            webView.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url="+path);

                           // webView.loadUrl("Loding"+path);


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

        RequestQueue requestQueue = Volley.newRequestQueue(TransporterActivity.this);
        requestQueue.add(str);


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();



        if(id == R.id.home){

            NavUtils.navigateUpFromSameTask(TransporterActivity.this);

        }

        return super.onOptionsItemSelected(item);
    }
}
