package com.frocerie.demoalqalam.main_activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.frocerie.demoalqalam.AboutEx;
import com.frocerie.demoalqalam.FeedBackActivity;
import com.frocerie.demoalqalam.LoginActivity;
import com.frocerie.demoalqalam.R;
import com.frocerie.demoalqalam.batchphase.BatchButActivity;
import com.frocerie.demoalqalam.dua.ListOfDuaWithAni;
import com.frocerie.demoalqalam.gall_youtube.GallYouTubeActivity;
import com.frocerie.demoalqalam.prayer.ListOfMonthsNew;
import com.frocerie.demoalqalam.service_pack.MyIntentService;
import com.frocerie.demoalqalam.service_pack.UserSharedPreference;
import com.frocerie.demoalqalam.speechinfo.SpechInfoActivity;

import java.util.Timer;
import java.util.TimerTask;

import static com.frocerie.demoalqalam.R.id.nav_account;


public class FrontPage extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    ViewPager viewPager;
    ImageView dua, time, gall, speech, batch, about;


    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    NavigationView navigationView;

    //updation codes...

    Context mContext;
    public static final int ALARM_REQ_CODE = 123;
    UserSharedPreference userPrefs;
    Button btnTimeBadge, btnGalBadge, btnSpeechBadge;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

        mContext = FrontPage.this;
        userPrefs = new UserSharedPreference(mContext);
        scheduleAlarm();


        initUi();

        initInstances();

        setBadgeValues();

        LocalBroadcastManager.getInstance(FrontPage.this).registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                setBadgeValues();
            }
        },new IntentFilter(MyIntentService.ACTION_UPDATE_BROADCAST));

        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 6000, 6000);
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            Timer timer1 = new Timer();

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        timer.cancel();
                        timer1.cancel();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        timer.cancel();
                        timer1.cancel();
                        break;
                    case MotionEvent.ACTION_UP:
                        timer1 = new Timer();
                        timer1.scheduleAtFixedRate(new MyTimerTask(), 4000, 4000);
                        break;
                }
                return false;
            }
        });

    }

    //Method to check Internet connection is there or not -> isConnected()

  /*  public boolean isConnected(Context context){

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()){

            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if ((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting()))return true;
            else return false;

        }else
            return false;


    }*/

    //Method to show alert dialog in application

/*    public AlertDialog.Builder builderDialog(Context c){

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You Need To Have Mobile Data or Wifi to accesss this. pess ok to Exit");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                //startActivity(new Intent(NetworkCheckActivity.this,Navigationexample.class));

                finish();
            }
        });

        return builder;

    }*/




    private void initInstances() {

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close);
        mDrawerLayout.setDrawerListener(mToggle);
        // mDrawerLayout.addDrawerListener(mToggle);
        //mToggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.navigation_drawer);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {


                int id = item.getItemId();
                Intent i;
                switch (id) {

                    case nav_account:


                        i = new Intent(FrontPage.this, FrontPage.class);
                        startActivity(i);
                      //navigationView.setBackgroundResource(R.color.colorWhite);
                        break;

                    case R.id.nav_feedback:
                        i = new Intent(FrontPage.this, FeedBackActivity.class);
                        startActivity(i);
                        break;


                    case R.id.nav_aboutus:
                        i = new Intent(FrontPage.this, AboutEx.class);
                        startActivity(i);
                        break;

                    case R.id.nav_login:
                        i = new Intent(FrontPage.this, LoginActivity.class);
                        startActivity(i);
                        break;

                    case R.id.nav_share:
                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey check out AlQalam android app at:\n https://play.google.com/store/apps/details?id=com.frocerie.demoalqalam");
                        sendIntent.setType("text/plain");
                        startActivity(sendIntent);

                        //i = new Intent(FrontPage.this, FeedBackActivity.class);
                        //startActivity(i);
                        break;

                }

//item.setVisible(true);
                //item.setEnabled(true);
                return true;
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        userPrefs.setCurrentActivity("FRONT_PAGE");
    }

    @Override
    protected void onResume() {
        super.onResume();
        userPrefs.setCurrentActivity("FRONT_PAGE");
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mToggle.syncState();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mToggle.onConfigurationChanged(newConfig);
    }

/* .................   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        getMenuInflater().inflate(R.menu.navigation_menu, menu);
        return true;
    }*/

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        return false;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {



        final int menuItemId = item.getItemId();
        switch (menuItemId) {
            case android.R.id.home:
                if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
                break;
            default:
                break;
        }
        return true;
    }

      /* .......... if (mToggle.onOptionsItemSelected(item)) {

            return true;

        }*/

     /*  ............ int id = item.getItemId();

        switch (id).......... {

            case R.id.loginIcon:

                startActivity(new Intent(this, LoginActivity.class));

                break;*/

            /*case R.id.share :

                //Toast.makeText(this,"Cose to share option",Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plan");
                String shareBody = "Your body here";
                String shareSub = "TYour Subject here";
                myIntent.putExtra(Intent.EXTRA_SUBJECT,shareBody);
                myIntent.putExtra(Intent.EXTRA_TEXT,shareSub);
                startActivity(Intent.createChooser(myIntent,"Share Using"));

                break;*/

        //.......}


        //if(id==R.id.loginIcon){

        //startActivity(new Intent(this,LoginActivity.class));


        // }

        //.......return super.onOptionsItemSelected(item);
   //...... }


    private void initUi() {


        viewPager = (ViewPager) findViewById(R.id.viewPager);


        ViewPageAdapterFront viewPageAdapter = new ViewPageAdapterFront(this);
        viewPager.setAdapter(viewPageAdapter);



        dua = (ImageView) findViewById(R.id.dua);
        dua.setOnClickListener(this);

        time = (ImageView) findViewById(R.id.time);
        time.setOnClickListener(this);

        gall = (ImageView) findViewById(R.id.gall);
        gall.setOnClickListener(this);

        speech = (ImageView) findViewById(R.id.speech);
        speech.setOnClickListener(this);

        batch = (ImageView) findViewById(R.id.batch);
        batch.setOnClickListener(this);

        about = (ImageView) findViewById(R.id.about);
        about.setOnClickListener(this);


        btnTimeBadge = (Button) findViewById(R.id.btn_badge_pt);
        btnTimeBadge.setVisibility(View.GONE);
        btnGalBadge = (Button) findViewById(R.id.btn_badge_gal);
        btnGalBadge.setVisibility(View.GONE);
        btnSpeechBadge = (Button) findViewById(R.id.btn_badge_speech);
        btnSpeechBadge.setVisibility(View.GONE);

    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        switch (id) {
            case R.id.dua:

                startActivity(new Intent(this, ListOfDuaWithAni.class));
                break;


            case R.id.time:
                userPrefs.setTimeBadgeValue(0); //Also you can set this method in next activity
                btnTimeBadge.setVisibility(View.GONE); //Also you can set this method in next activity
                startActivity(new Intent(this, ListOfMonthsNew.class));
                //startActivity(new Intent(this,ListOfMonths.class));
                break;


            case R.id.gall:

                userPrefs.setGalleryBadgeValue(0); //Also you can set this method in next activity
                btnGalBadge.setVisibility(View.GONE);//Also you can set this method in next activity
                startActivity(new Intent(this, GallYouTubeActivity.class));
                break;


            case R.id.speech:

                userPrefs.setSpeechBadgeValue(0);//Also you can set this method in next activity
                btnSpeechBadge.setVisibility(View.GONE);//Also you can set this method in next activity

                startActivity(new Intent(this, SpechInfoActivity.class));
                break;

            case R.id.batch:
                startActivity(new Intent(this, BatchButActivity.class));
                break;


            case R.id.about:
                startActivity(new Intent(this, AboutEx.class));
                break;


        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        return true;


        //return false;
    }

    public class MyTimerTask extends TimerTask {


        @Override
        public void run() {


            FrontPage.this.runOnUiThread(new Runnable() {

                @Override
                public void run() {


                    if (viewPager.getCurrentItem() == 0) {
                        //MyTimerTask.this.cancel();
                        viewPager.setCurrentItem(1);

                    } else if (viewPager.getCurrentItem() == 1) {

                        viewPager.setCurrentItem(2);

                    } else if (viewPager.getCurrentItem() == 2) {

                        viewPager.setCurrentItem(3);

                    } else if (viewPager.getCurrentItem() == 3) {

                        viewPager.setCurrentItem(4);

                    } else if (viewPager.getCurrentItem() == 4) {

                        viewPager.setCurrentItem(5);

                    } else if (viewPager.getCurrentItem() == 5) {

                        viewPager.setCurrentItem(6);
                    } else if (viewPager.getCurrentItem() == 6) {

                        viewPager.setCurrentItem(7);
                    } else if (viewPager.getCurrentItem() == 7) {

                        viewPager.setCurrentItem(8);
                    } else {

                        viewPager.setCurrentItem(0);


                    }


                }

            });


        }
    }



    public void setBadgeValues() {
        if(userPrefs.getTimeBadgeValue() > 0) {
            btnTimeBadge.setVisibility(View.VISIBLE);
            btnTimeBadge.setText(String.valueOf(userPrefs.getTimeBadgeValue()));
        } else
            btnTimeBadge.setVisibility(View.GONE);

        if(userPrefs.getGalleryBadgeValue() > 0) {
            btnGalBadge.setVisibility(View.VISIBLE);
            btnGalBadge.setText(String.valueOf(userPrefs.getGalleryBadgeValue()));
        } else
            btnGalBadge.setVisibility(View.GONE);

        if(userPrefs.getSpeechBadgeValue() > 0) {
            btnSpeechBadge.setVisibility(View.VISIBLE);
            btnSpeechBadge.setText(String.valueOf(userPrefs.getSpeechBadgeValue()));
        } else
            btnSpeechBadge.setVisibility(View.GONE);
    }


    // Setup a recurring alarm every 60 seconds
    public void scheduleAlarm() {

        Intent intent = new Intent(mContext, MyIntentService.class);
        // Create a PendingIntent to be triggered when the alarm goes off
         final PendingIntent pIntent = PendingIntent.getService(FrontPage.this, ALARM_REQ_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        // Setup periodic alarm every 10 seconds
        long firstMillis = System.currentTimeMillis(); // alarm is set right away
        AlarmManager alarm = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
        alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, firstMillis, 60000, pIntent);
    }

}