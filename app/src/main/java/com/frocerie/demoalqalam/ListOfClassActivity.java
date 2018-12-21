package com.frocerie.demoalqalam;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.frocerie.demoalqalam.weeklyplan.ListOfSubClass;

public class ListOfClassActivity extends AppCompatActivity {


    ListView lvPlan;
    String[] weePlan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_class_activirty);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Resources re = getResources();

        weePlan = re.getStringArray(R.array.weekly_plan);

        lvPlan = (ListView) findViewById(R.id.lvPlanCl);

        WeeklyPlanAdapter weeklyPlanAdapter = new WeeklyPlanAdapter(ListOfClassActivity.this,weePlan);

        lvPlan.setAdapter(weeklyPlanAdapter);

        lvPlan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                System.out.println("Value of i ="+i);
                System.out.println("Value of index"+weePlan[i]);

                switch(i){

                    case 0:

                        startActivity(new Intent(ListOfClassActivity.this,ListOfSubClass.class));

                        //Toast.makeText(ListOfClassActivity.this,"Subclass fetched from server",Toast.LENGTH_SHORT).show();

                        break;

                    case 1:

                        Toast.makeText(ListOfClassActivity.this,"Subclass fetched from server",Toast.LENGTH_SHORT).show();
                        break;

                    case 2:

                        Toast.makeText(ListOfClassActivity.this,"Subclass fetched from server",Toast.LENGTH_SHORT).show();
                        break;


                    case 3:

                        Toast.makeText(ListOfClassActivity.this,"Subclass fetched from server",Toast.LENGTH_SHORT).show();
                        break;

                    case 4:

                        Toast.makeText(ListOfClassActivity.this,"Subclass fetched from server",Toast.LENGTH_SHORT).show();
                        break;

                    case 5:

                        Toast.makeText(ListOfClassActivity.this,"Subclass fetched from server",Toast.LENGTH_SHORT).show();
                        break;


                    case 6:

                        Toast.makeText(ListOfClassActivity.this,"Subclass fetched from server",Toast.LENGTH_SHORT).show();
                        break;

                    case 7:

                        Toast.makeText(ListOfClassActivity.this,"Subclass fetched from server",Toast.LENGTH_SHORT).show();
                        break;


                    case 8:
                        Toast.makeText(ListOfClassActivity.this,"Subclass fetched from server",Toast.LENGTH_SHORT).show();
                        break;


                    case 9:
                        Toast.makeText(ListOfClassActivity.this,"Subclass fetched from server",Toast.LENGTH_SHORT).show();
                        break;

                    case 10 :
                        Toast.makeText(ListOfClassActivity.this,"Subclass fetched from server",Toast.LENGTH_SHORT).show();
                        break;

                    case 11:
                        Toast.makeText(ListOfClassActivity.this,"Subclass fetched from server",Toast.LENGTH_SHORT).show();

                        break;




                }


            }
        });



    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();



        if(id == R.id.home){

            NavUtils.navigateUpFromSameTask(ListOfClassActivity.this);

        }

        return super.onOptionsItemSelected(item);
    }
}


class WeeklyPlanAdapter extends ArrayAdapter<String>{


    Context context;

    String[] titlePlan;


    WeeklyPlanAdapter(Context c,String[] planweek){

        super(c,R.layout.single_view,R.id.tvMonth,planweek);

        this.context = c;
        this.titlePlan = planweek;


    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

       View row = layoutInflater.inflate(R.layout.single_view,parent,false);

        TextView myPlan = (TextView) row.findViewById(R.id.tvMonth);
        myPlan.setText(titlePlan[position]);

        return  row;
    }
}

