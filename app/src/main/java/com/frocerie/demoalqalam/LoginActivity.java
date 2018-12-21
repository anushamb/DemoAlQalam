package com.frocerie.demoalqalam;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.frocerie.demoalqalam.main_activity.FrontPage;
import com.frocerie.demoalqalam.main_activity.PageLogActivity;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements TextWatcher, CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    final String TAG = LoginActivity.class.getSimpleName();

    private CheckBox rem_userpass;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private EditText etUserNmae, etPassword;
    private Button btLogin, btFeed;

    String userName;
    String password;


    private static final String PREF_NAME = "prefs";
    private static final String KEY_REMEMBER = "remember";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASS = "password";


    //String url = "https://frocerie.com/alqalamMobileApp/login";

    String url = "http://alqalamtrust.com/login";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        etUserNmae = (EditText) findViewById(R.id.etusername);
        etPassword = (EditText) findViewById(R.id.etpassword);

        rem_userpass = (CheckBox) findViewById(R.id.checkBox);

        btLogin = (Button) findViewById(R.id.btlogin);
        btLogin.setOnClickListener(this);

       /* btFeed = (Button) findViewById(R.id.btFeedBack);
        btFeed.setOnClickListener(this);*/

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        if (sharedPreferences.getBoolean(KEY_REMEMBER, false)) {

            rem_userpass.setChecked(true);


        } else {

            rem_userpass.setChecked(false);
        }


        etUserNmae.setText(sharedPreferences.getString(KEY_USERNAME, ""));

        etPassword.setText(sharedPreferences.getString(KEY_PASS, ""));


        etUserNmae.addTextChangedListener(LoginActivity.this);
        etPassword.addTextChangedListener(LoginActivity.this);
        rem_userpass.setOnCheckedChangeListener(LoginActivity.this);


        /*btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int idi = view.getId();

                *//*Intent sendIntent = new Intent(LoginActivity.this,FeedBackActivity.class);
                sendIntent.putExtra("textdata",etPassword.getText());
                startActivity(sendIntent);*//*


                switch (idi) {

                    case R.id.btlogin:
                        doing();
                        break;

                    case R.id.btFeedBack :
                        feedback();
                        break;

                }
            }

            private void doing() {

                 userName = etUserNmae.getText().toString();
                 password = etPassword.getText().toString();


                if (TextUtils.isEmpty(userName)) {

                    etUserNmae.setError("Please enter UserName");
                    etPassword.setError("Please enter password");

                    return;
                } else if (TextUtils.isEmpty(password)) {

                    etPassword.setError("Please enter password");
                    return;

                }
                //else
                //{

                final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
                progressDialog.setMessage("Login is process......");
                progressDialog.show();

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {

                            progressDialog.dismiss();

                            //.e(TAG,"Error");

                            Log.d(TAG, response);

                            if (response.contains("true")) {


                                Intent intent = new Intent(LoginActivity.this, PageLogActivity.class);
                                startActivity(intent);

                            } else {


                                Toast.makeText(getApplicationContext(), "Wrong Username and Password", Toast.LENGTH_SHORT).show();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            if (error==null){
                                return;
                            }
//                            Log.e("Volley Error....",error.getMessage());
                            progressDialog.dismiss();
                            Toast.makeText(LoginActivity.this," "+error.getMessage(),Toast.LENGTH_SHORT).show();

                            //Toast.makeText(getApplicationContext(), "Error while reading data", Toast.LENGTH_SHORT).show();

                        }
                    }) {

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {

                            Map<String, String> params = new HashMap<>();

                            params.put("username", etUserNmae.getText().toString());
                            params.put("password", etPassword.getText().toString());

                            return params;

                        }
                    };

                    //MySingletonLog.getInstance(LoginActivity.this).getRequestQueue();

                     MySingletonLog.getInstance(LoginActivity.this).addToRequestQueue(stringRequest);

                   // MySingleton.getmInstance(getApplicationContext()).addToRequestQueue(stringRequest);



                //}
            }

            private void feedback(){

                Intent sendIntent = new Intent(LoginActivity.this,FeedBackActivity.class);
                sendIntent.putExtra("textdata",etPassword.getText());
                startActivity(sendIntent);


            }


        });*/

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
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        managePrefs();

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        managePrefs();

    }


    private void managePrefs() {

        if (rem_userpass.isChecked()) {

            editor.putString(KEY_USERNAME, etUserNmae.getText().toString().trim());
            editor.putString(KEY_PASS, etPassword.getText().toString().trim());
            editor.putBoolean(KEY_REMEMBER, true);
            editor.apply();

        } else {


            editor.putBoolean(KEY_REMEMBER, false);
            editor.remove(KEY_USERNAME);
            editor.remove(KEY_PASS);
            editor.apply();

        }

    }


    @Override
    public void onClick(View view) {

        int idi = view.getId();

        switch (idi) {

            case R.id.btlogin:


                doing();

                break;

      /*          if (isNetworkAvailable()){
                    doing();

                }else{

                    builderDialogMsg(LoginActivity.this);



                }*/




            /*case R.id.btFeedBack :
                feedback();
                break;*/

        }


    }

   /* private void feedback() {


        Intent sendIntent = new Intent(LoginActivity.this,FeedBackActivity.class);
        sendIntent.putExtra("feedback",etPassword.getText().toString());
        startActivity(sendIntent);


    }*/

    private void doing() {

       /* if (isNetworkAvailable()){*/

        userName = etUserNmae.getText().toString();
        password = etPassword.getText().toString();


        if (TextUtils.isEmpty(userName)) {

            etUserNmae.setError("Please enter UserName");
            etPassword.setError("Please enter password");

            return;
        } else if (TextUtils.isEmpty(password)) {

            etPassword.setError("Please enter password");
            return;

        }
        //else
        //{

   /*     if (isNetworkAvailable()){*/


        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setMessage("Login is process......");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                progressDialog.dismiss();

                //.e(TAG,"Error");

                Log.d(TAG, response);

                if (response.contains("true")) {


                    Intent intent = new Intent(LoginActivity.this, PageLogActivity.class);
                    startActivity(intent);

                } else {


                    Toast.makeText(getApplicationContext(), "Wrong Username and Password", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                if (error == null) {
                    return;
                }
//                            Log.e("Volley Error....",error.getMessage());
                progressDialog.dismiss();

                Toast.makeText(LoginActivity.this,"No Internet Connection Please check Your Mobile Data or WIFI to access Login Page",Toast.LENGTH_SHORT).show();
                //Toast.makeText(LoginActivity.this, " " + error.getMessage(), Toast.LENGTH_SHORT).show();

                /*AlertDialog.Builder buld = new AlertDialog.Builder(LoginActivity.this);
                buld.setTitle("No Internet Connection");
                buld.setMessage("You Need to have mobile data or wifi to access Press OK to Exit");
                buld.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        startActivity(new Intent(LoginActivity.this,LoginActivity.class));

                    }
                });
*/

                //Toast.makeText(getApplicationContext(), "Error while reading data", Toast.LENGTH_SHORT).show();

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();

                params.put("username", etUserNmae.getText().toString());
                params.put("password", etPassword.getText().toString());

                return params;

            }
        };

        //MySingletonLog.getInstance(LoginActivity.this).getRequestQueue();

        MySingletonLog.getInstance(LoginActivity.this).addToRequestQueue(stringRequest);

        // MySingleton.getmInstance(getApplicationContext()).addToRequestQueue(stringRequest);


        //}

 /*   }else{

        builderDialogMsg(LoginActivity.this);

    }*/
    }

    private AlertDialog.Builder builderDialogMsg(LoginActivity loginActivity) {

        AlertDialog.Builder builder = new AlertDialog.Builder(loginActivity);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You Need To Have Mobile Data or WIFI To Access This,, Press OK to Exit");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                startActivity(new Intent(LoginActivity.this, FrontPage.class));
            }
        });
        return builder;
    }


    private boolean isNetworkAvailable() {

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nwInfo = cm.getActiveNetworkInfo();

        return nwInfo != null && nwInfo.isConnected();
    }
    }




   /* @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){

            case R.id.btLogin:
                doLogin();
                break;

        }
    }

    private void doLogin() {

        String userName = etUserNmae.getText().toString();
        String password = etPassword.getText().toString();


        if(TextUtils.isEmpty(userName)){

            etUserNmae.setError("Please enter UserName");
            etPassword.setError("Please enter password");

            return;
        } else if(TextUtils.isEmpty(password)){

            etPassword.setError("Please enter password");
            return;

        }

        else{

            Intent intent = new Intent(LoginActivity.this,PageLogActivity.class);
            startActivity(intent);
        }
}*/






