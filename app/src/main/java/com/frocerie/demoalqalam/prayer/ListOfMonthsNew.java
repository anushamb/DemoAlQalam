package com.frocerie.demoalqalam.prayer;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.frocerie.demoalqalam.R;

public class ListOfMonthsNew extends AppCompatActivity {

    String[] listOfMonth;
    ListView listViewMonth;
    //Intent intent;

    ListOfNewAdapter listOfNewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_months_new);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Resources resources = getResources();
        listOfMonth = resources.getStringArray(R.array.list_of_months);

        listViewMonth = (ListView) findViewById(R.id.list_month_new);

        listOfNewAdapter = new ListOfNewAdapter(this,listOfMonth);

        listViewMonth.setAdapter(listOfNewAdapter);
        listViewMonth.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {

                    case 0:

                        startActivity(new Intent(ListOfMonthsNew.this, JanActivity.class));
                        break;

                    case 1:

                        startActivity(new Intent(ListOfMonthsNew.this, FebActivity.class));


                        //Toast.makeText(ListOfMonths.this,"Image",Toast.LENGTH_SHORT).show();
                        break;

                    case 2:
                        startActivity(new Intent(ListOfMonthsNew.this, MarActivity.class));

                        //Toast.makeText(ListOfMonths.this,"Mar",Toast.LENGTH_SHORT).show();
                        break;


                    case 3:

                        startActivity(new Intent(ListOfMonthsNew.this, MayActivity.class));

                        //Toast.makeText(ListOfMonths.this,"May",Toast.LENGTH_SHORT).show();
                        break;

                    case 4:
                        startActivity(new Intent(ListOfMonthsNew.this, JunActivity.class));

                        //Toast.makeText(ListOfMonths.this,"Jun",Toast.LENGTH_SHORT).show();
                        break;

                    case 5:

                        startActivity(new Intent(ListOfMonthsNew.this, JulActivity.class));

                        //Toast.makeText(ListOfMonths.this,"Jul",Toast.LENGTH_SHORT).show();
                        break;

                    case 6:
                        startActivity(new Intent(ListOfMonthsNew.this, AugActivity.class));

                        //Toast.makeText(ListOfMonths.this,"Aug",Toast.LENGTH_SHORT).show();
                        break;

                    case 7:

                        startActivity(new Intent(ListOfMonthsNew.this, SeptActivity.class));

                        // Toast.makeText(ListOfMonths.this,"Sept",Toast.LENGTH_SHORT).show();
                        break;
                    case 8:

                        startActivity(new Intent(ListOfMonthsNew.this, OctActivity.class));

                        //Toast.makeText(ListOfMonths.this,"Oct",Toast.LENGTH_SHORT).show();
                        break;
                    case 9:
                        //Toast.makeText(ListOfMonths.this,"Nov",Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(ListOfMonthsNew.this, NovActivity.class));
                        break;

                    case 10:

                        //Toast.makeText(ListOfMonths.this,"Dec",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ListOfMonthsNew.this, DecActivity.class));

                        break;


                }

            }
        });




    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(ListOfMonthsNew.this);

        }




        return super.onOptionsItemSelected(item);
    }


    class ListOfNewAdapter extends ArrayAdapter<String>{

        Context context;
        String[] titleMonth;


        public ListOfNewAdapter(Context context, String[] titleMonth ) {
            super(context, R.layout.single_view,R.id.tvMonth,titleMonth);

            this.context = context;
            this.titleMonth = titleMonth;

        }


        @Override
        public View getView(int position, View convertView,  ViewGroup parent) {

            View row = convertView;
            if (row == null){

                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = layoutInflater.inflate(R.layout.single_view,parent,false);

            }

            TextView myMonth = (TextView) row.findViewById(R.id.tvMonth);

            myMonth.setText(titleMonth[position]);

            myMonth.setAnimation(AnimationUtils.loadAnimation(context,R.anim.dua_animation));

            return row;
        }
    }



}
