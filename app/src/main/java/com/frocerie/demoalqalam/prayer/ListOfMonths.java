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

public class ListOfMonths extends AppCompatActivity {



    ListView lvMonth;

    String[] month;
    ListMonthAdapter listMonthAdapter;

    //ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_months);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Resources resources = getResources();

        month = resources.getStringArray(R.array.listofmonths);

        lvMonth = (ListView) findViewById(R.id.listmonth);

        listMonthAdapter  = new ListMonthAdapter(ListOfMonths.this,month);
        lvMonth.setAdapter(listMonthAdapter);


        //ArrayList<String> arrayList = new ArrayList<>();
        //arrayList.addAll(Arrays.asList(getResources().getStringArray(R.array.listofmonths)));

       // adapter = new ArrayAdapter<String>(ListOfMonths.this,
                //android.R.layout.simple_list_item_1,
               // arrayList);


        lvMonth.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i){

                    case 0 :

                        startActivity(new Intent(ListOfMonths.this,JanActivity.class));
                        break;

                    case 1 :

                        startActivity(new Intent(ListOfMonths.this,FebActivity.class));


                        //Toast.makeText(ListOfMonths.this,"Image",Toast.LENGTH_SHORT).show();
                        break;

                    case 2 :
                        startActivity(new Intent(ListOfMonths.this,MarActivity.class));

                        //Toast.makeText(ListOfMonths.this,"Mar",Toast.LENGTH_SHORT).show();
                        break;


                 /*   case 3 :

                        startActivity(new Intent(ListOfMonths.this,AprActivity.class));

                        //Toast.makeText(ListOfMonths.this,"Apr",Toast.LENGTH_SHORT).show();
                        break;*/

                    case 3 :

                        startActivity(new Intent(ListOfMonths.this,MayActivity.class));

                        //Toast.makeText(ListOfMonths.this,"May",Toast.LENGTH_SHORT).show();
                        break;

                    case 4 :
                        startActivity(new Intent(ListOfMonths.this,JunActivity.class));

                        //Toast.makeText(ListOfMonths.this,"Jun",Toast.LENGTH_SHORT).show();
                        break;

                    case 5 :

                        startActivity(new Intent(ListOfMonths.this,JulActivity.class));

                        //Toast.makeText(ListOfMonths.this,"Jul",Toast.LENGTH_SHORT).show();
                        break;

                    case 6 :
                        startActivity(new Intent(ListOfMonths.this,AugActivity.class));

                        //Toast.makeText(ListOfMonths.this,"Aug",Toast.LENGTH_SHORT).show();
                        break;

                    case 7 :

                        startActivity(new Intent(ListOfMonths.this,SeptActivity.class));

                       // Toast.makeText(ListOfMonths.this,"Sept",Toast.LENGTH_SHORT).show();
                        break;
                    case 8 :

                        startActivity(new Intent(ListOfMonths.this,OctActivity.class));

                        //Toast.makeText(ListOfMonths.this,"Oct",Toast.LENGTH_SHORT).show();
                        break;
                    case  9 :
                        //Toast.makeText(ListOfMonths.this,"Nov",Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(ListOfMonths.this,NovActivity.class));
                        break;

                    case 10:

                        //Toast.makeText(ListOfMonths.this,"Dec",Toast.LENGTH_SHORT).show();
                      startActivity(new Intent(ListOfMonths.this,DecActivity.class));

                        break;






                }
            }
        });

        //lvMonth.setAdapter(listMonthAdapter);


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(ListOfMonths.this);

        }




        return super.onOptionsItemSelected(item);
    }
}


class ListMonthAdapter extends ArrayAdapter<String>{


    Context context;;
    String[] titleMonth;

    ListMonthAdapter(Context c,String[] month){

        super(c,R.layout.single_view,R.id.tvMonth,month);
        this.context =c;
        this.titleMonth = month;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;

        if (row == null){

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_view,parent,false);



        }

        TextView myMonth = (TextView) row.findViewById(R.id.tvMonth);
        myMonth.setText(titleMonth[position]);
        myMonth.setAnimation(AnimationUtils.loadAnimation(context,R.anim.dua_animation));
        return  row;
    }
}