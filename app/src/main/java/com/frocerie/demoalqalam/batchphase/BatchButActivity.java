package com.frocerie.demoalqalam.batchphase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.frocerie.demoalqalam.R;

public class BatchButActivity extends AppCompatActivity implements View.OnClickListener {

    Button ivReside,ivRegu,ivFull,ivPart,ivDay,ivMegr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batch_but_new);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ivReside = (Button) findViewById(R.id.ivReside);
        ivReside.setOnClickListener(this);


        ivRegu = (Button) findViewById(R.id.ivRegu);
        ivRegu.setOnClickListener(this);



        ivFull = (Button) findViewById(R.id.ivFull);
        ivFull.setOnClickListener(this);



        ivPart = (Button) findViewById(R.id.ivPart);
        ivPart.setOnClickListener(this);


        ivDay = (Button) findViewById(R.id.ivDay);
        ivDay.setOnClickListener(this);


        ivMegr = (Button) findViewById(R.id.ivMegr);
        ivMegr.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        switch (id){

            case R.id.ivReside :

                startActivity(new Intent(BatchButActivity.this,HifdActivity.class));
                break;
            case R.id.ivRegu :


                Intent intent1 = new Intent(BatchButActivity.this, RegularMadrasActivity.class);
                startActivity(intent1);
                break;

            case R.id.ivFull:


                Intent intent2 = new Intent(BatchButActivity.this, FullDayActivity.class);
                startActivity(intent2);
                break;



            case R.id.ivPart:
                Intent intent3 = new Intent(BatchButActivity.this, PartTimeActivity.class);
                startActivity(intent3);
                break;



            case R.id.ivDay:
                Intent intent4 = new Intent(BatchButActivity.this, DayActivity.class);
                startActivity(intent4);
                break;

            case R.id.ivMegr:
                Intent inten = new Intent(BatchButActivity.this, MagribActivity.class);
                startActivity(inten);
                break;




        }






    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(BatchButActivity.this);

        }




        return super.onOptionsItemSelected(item);
    }

}
