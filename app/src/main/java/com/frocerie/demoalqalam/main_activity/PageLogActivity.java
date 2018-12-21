package com.frocerie.demoalqalam.main_activity;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.frocerie.demoalqalam.MaterialsActivity;
import com.frocerie.demoalqalam.R;
import com.frocerie.demoalqalam.ViewPageAdapter;
import com.frocerie.demoalqalam.examhut.ExamPoTiHutActivity;
import com.frocerie.demoalqalam.noticeboard.NoticeBoardActivity;
import com.frocerie.demoalqalam.service_pack.MyIntentService;
import com.frocerie.demoalqalam.service_pack.UserSharedPreference;
import com.frocerie.demoalqalam.toppers_activity.ToppersNewActivity;
import com.frocerie.demoalqalam.utils.GeneralUtils;
import com.frocerie.demoalqalam.weeklyplan.WeeklyLessonPlanActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;

public class PageLogActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager viewPager;
    ImageView notice, plan, exam, material, topper, transport;
    private String TAG = "PageLogActivity";
    ProgressDialog progressDialog;
    String url = "http://alqalamtrust.com/transports";

    //Updated code
    UserSharedPreference userSharedPreference;
    Context context;

    Button btnNotification, btnPlan, btnExamHut, btnMaterial, btnTopper, btnTransport;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_log);

        context = PageLogActivity.this;
        userSharedPreference = new UserSharedPreference(context);


        initUi();

        setBadgesVales();

        LocalBroadcastManager.getInstance(PageLogActivity.this).registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                setBadgesVales();
            }
        }, new IntentFilter(MyIntentService.ACTION_UPDATE_LOG_BROADCAST));


        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 6000, 6000);

        viewPager.setOnTouchListener(new View.OnTouchListener() {

            Timer timer2 = new Timer();

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        timer.cancel();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        timer.cancel();
                        timer2.cancel();
                        break;

                    case MotionEvent.ACTION_UP:
                        timer2 = new Timer();
                        timer2.scheduleAtFixedRate(new MyTimerTask(), 5000, 5000);
                        break;
                }

                return false;
            }
        });


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }


    @Override
    protected void onPause() {
        super.onPause();
        userSharedPreference.setCurrentActivity("PAGE_LOG");
    }

    @Override
    protected void onResume() {
        super.onResume();
        setBadgesVales();
        userSharedPreference.setCurrentActivity("PAGE_LOG");
    }


    private void setBadgesVales() {
        if (userSharedPreference.getNoticeBadgeValue() > 0) {
            btnNotification.setVisibility(View.VISIBLE);
            btnNotification.setText(String.valueOf(userSharedPreference.getNoticeBadgeValue()));
        } else
            btnNotification.setVisibility(View.GONE);

        if (userSharedPreference.getCurWeeklyBadgeValue() > 0) {
            btnPlan.setVisibility(View.VISIBLE);
            btnPlan.setText(String.valueOf(userSharedPreference.getCurWeeklyBadgeValue()));
        } else
            btnPlan.setVisibility(View.GONE);

          /*  int currentVale = userSharedPreference.getCurWeeklyBadgeValue();
            if (currentVale == currentVale){
                btnPlan.setText(0);
            }else{
                btnPlan.setText(String.valueOf(currentVale));
            }*/

        if (userSharedPreference.getCurExamBadgeValue() > 0) {
            btnExamHut.setVisibility(View.VISIBLE);
            btnExamHut.setText(String.valueOf(userSharedPreference.getCurExamBadgeValue()));
        } else
            btnExamHut.setVisibility(View.GONE);


/*
        if (userSharedPreference.getExamBadgeValue() > 0) {
            btnExamHut.setVisibility(View.VISIBLE);
            btnExamHut.setText(String.valueOf(userSharedPreference.getExamBadgeValue()));
        } else
            btnExamHut.setVisibility(View.GONE);*/

        if (userSharedPreference.getMatBadgeValue() > 0) {
            btnMaterial.setVisibility(View.VISIBLE);
            btnMaterial.setText(String.valueOf(userSharedPreference.getMatBadgeValue()));
        } else
            btnMaterial.setVisibility(View.GONE);



        if (userSharedPreference.getCurToppersBadgeValue() > 0) {
            btnTopper.setVisibility(View.VISIBLE);
            btnTopper.setText(String.valueOf(userSharedPreference.getCurToppersBadgeValue()));
        } else
            btnTopper.setVisibility(View.GONE);


      /*  if (userSharedPreference.getToppersBadgeValue() > 0) {
            btnTopper.setVisibility(View.VISIBLE);
            btnTopper.setText(String.valueOf(userSharedPreference.getToppersBadgeValue()));
        } else
            btnTopper.setVisibility(View.GONE);*/

        if (userSharedPreference.getTranspoBadgeValue() > 0) {
            btnTransport.setVisibility(View.VISIBLE);
            btnTransport.setText(String.valueOf(userSharedPreference.getTranspoBadgeValue()));
        } else
            btnTransport.setVisibility(View.GONE);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.home) {

            NavUtils.navigateUpFromSameTask(this);

        }

        return super.onOptionsItemSelected(item);
    }

    private void initUi() {

        viewPager = (ViewPager) findViewById(R.id.viewPage);

        notice = (ImageView) findViewById(R.id.notice);
        notice.setOnClickListener(this);


        plan = (ImageView) findViewById(R.id.plan);
        plan.setOnClickListener(this);


        exam = (ImageView) findViewById(R.id.hut);
        exam.setOnClickListener(this);

        material = (ImageView) findViewById(R.id.material);
        material.setOnClickListener(this);

        topper = (ImageView) findViewById(R.id.topper);
        topper.setOnClickListener(this);


        transport = (ImageView) findViewById(R.id.transport);
        transport.setOnClickListener(this);

        btnNotification = (Button) findViewById(R.id.btn_badge_notice);
        btnPlan = (Button) findViewById(R.id.btn_badge_plan);
        btnExamHut = (Button) findViewById(R.id.btn_badge_hut);
        btnMaterial = (Button) findViewById(R.id.btn_badge_material);
        btnTopper = (Button) findViewById(R.id.btn_badge_topper);
        btnTransport = (Button) findViewById(R.id.btn_badge_transport);


        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(this);
        viewPager.setAdapter(viewPageAdapter);


    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.notice:
                userSharedPreference.setNoticeBadgeVal(0);
                btnNotification.setVisibility(View.GONE);
                startActivity(new Intent(PageLogActivity.this, NoticeBoardActivity.class));
                break;


        /*    case R.id.plan:

                userSharedPreference.setWeeklyBadgeVal(0);
                btnPlan.setVisibility(View.GONE);

                startActivity(new Intent(PageLogActivity.this, WeeklyLessonPlanActivity.class));
                //startActivity(new Intent(PageLogActivity.this,ListOfClassActivity.class));
                break;*/

            case R.id.plan:
                //userSharedPreference.setCurWeeklyBadgeValue(0);
                //btnPlan.setVisibility(View.GONE);
                startActivity(new Intent(PageLogActivity.this, WeeklyLessonPlanActivity.class));
                //startActivity(new Intent(PageLogActivity.this,ListOfClassActivity.class));
                break;


            case R.id.hut:

                //userSharedPreference.setCurExamBadgeValue(0);
                //btnExamHut.setVisibility(View.GONE);
                startActivity(new Intent(PageLogActivity.this, ExamPoTiHutActivity.class));
                break;

            case R.id.material:

                userSharedPreference.setMatBadgeVal(0);
                btnMaterial.setVisibility(View.GONE);
                startActivity(new Intent(PageLogActivity.this, MaterialsActivity.class));
                break;


            case R.id.topper:

                //userSharedPreference.setCurToppersBadgeValue(0);
                //btnTopper.setVisibility(View.GONE);
                startActivity(new Intent(PageLogActivity.this, ToppersNewActivity.class));
                //startActivity(new Intent(PageLogActivity.this,ToppersActivity.class));
                break;


            case R.id.transport:
                //fetchingPdf();

                userSharedPreference.setTranspoBadgeVal(0);
                btnTransport.setVisibility(View.GONE);

                requestPDFData();

//                startActivity(new Intent(PageLogActivity.this,TransporterActivity.class));
                break;


        }
    }

    //private void fetchingPdf() {

    //}

    private void requestPDFData() {


        if (isNetWorkConnected()) {

            progressDialog = new ProgressDialog(PageLogActivity.this);
            progressDialog.setMessage("Loding File.....");
            progressDialog.show();


            StringRequest str = new StringRequest(Request.Method.GET,
                    url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            progressDialog.dismiss();

                            if (TextUtils.isEmpty(response)) {
                                return;
                            }

                            try {
                                JSONObject jsonObject = new JSONObject(response);

                                if (jsonObject == null || jsonObject.length() <= 0) {
                                    return;
                                }

                                JSONArray jsonArray = jsonObject.getJSONArray("details");

                                if (jsonArray == null || jsonArray.length() <= 0) {
                                    return;
                                }

                                JSONObject object = jsonArray.getJSONObject(0);

                                if (object == null) {
                                    return;
                                }


                                String path = object.getString("pdf_path");
                                if (TextUtils.isEmpty(path)) {
                                    return;
                                }


                                path = "http://drive.google.com/viewerng/viewer?embedded=true&url=" + path;

                                GeneralUtils.launchUrlUsingChromeTab(PageLogActivity.this, path);

//                            webView.getSettings().setJavaScriptEnabled(true);
//                            webView.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url="+path);

                                // webView.loadUrl("Loding"+path);


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

            RequestQueue requestQueue = Volley.newRequestQueue(PageLogActivity.this);
            requestQueue.add(str);
        } else {

            builderDialog(PageLogActivity.this).show();

        }
    }

    private AlertDialog.Builder builderDialog(PageLogActivity pageLogActivity) {


        AlertDialog.Builder builder = new AlertDialog.Builder(pageLogActivity);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You Need To Have Mobile Data or Wifi to accesss this. pess ok to Exit");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                startActivity(new Intent(PageLogActivity.this, PageLogActivity.class));

                //finish();
            }
        });

        return builder;
    }

    private boolean isNetWorkConnected() {

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activityNetworkInfo = connectivityManager.getActiveNetworkInfo();

        return activityNetworkInfo != null && activityNetworkInfo.isConnected();

    }

    public class MyTimerTask extends TimerTask {


        @Override
        public void run() {


            PageLogActivity.this.runOnUiThread(new Runnable() {

                @Override
                public void run() {


                    if (viewPager.getCurrentItem() == 0) {

                        viewPager.setCurrentItem(1);

                    } else if (viewPager.getCurrentItem() == 1) {

                        viewPager.setCurrentItem(2);

                    } else if (viewPager.getCurrentItem() == 2) {

                        viewPager.setCurrentItem(3);
                    } else

                        viewPager.setCurrentItem(0);
                }

            });


        }
    }


}
