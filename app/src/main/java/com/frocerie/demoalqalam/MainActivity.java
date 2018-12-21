package com.frocerie.demoalqalam;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.frocerie.demoalqalam.main_activity.FrontPage;

public class MainActivity extends AppCompatActivity implements Runnable {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_main);


        Handler h = new Handler();
        h.postDelayed(this, 3000);

    }

    @Override
    public void run() {
        startActivity(new Intent(this, FrontPage.class));
        finish();

    }
    }

// getSupportActionBar().show();

       /*Thread thread = new Thread() {

            @Override
            public void run() {

                try {

                    sleep(3000);



                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {

                    Intent intent = new Intent(MainActivity.this,FrontPage.class);
                    startActivity(intent);
                }

            }
        };

        thread.start();



        //Handler handler= new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,FrontPage.class);
                startActivity(intent);
                finish();
            }
       // },3000);


    }*/



   /* @Override
    protected void onPause() {
        super.onPause();
        finish();;
    }

}*/



