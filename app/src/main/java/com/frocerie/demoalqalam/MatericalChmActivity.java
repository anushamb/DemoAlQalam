package com.frocerie.demoalqalam;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.barteksc.pdfviewer.PDFView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MatericalChmActivity extends AppCompatActivity {


    String url = "http://alqalamtrust.com/transports";
    PDFView chmView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materical_chm);

        chmView = (PDFView) findViewById(R.id.chmView);

        chmJsonRequest();

    }

    private void chmJsonRequest() {


        progressDialog  = new ProgressDialog(MatericalChmActivity.this);
        progressDialog.setMessage("Loding File.....");
        progressDialog.show();


        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObect = new JSONObject(response);
                            JSONArray jsonArray = jsonObect.getJSONArray("details");
                            JSONObject objectJson = jsonArray.getJSONObject(0);


                            String pdfPath = objectJson.getString("pdf_path");

                            System.out.println("path ="+pdfPath);



                            chmView.fromUri(Uri.parse(pdfPath)).load();




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

        RequestQueue requestQueue = Volley.newRequestQueue(MatericalChmActivity.this);
        requestQueue.add(stringRequest);





    }
}
