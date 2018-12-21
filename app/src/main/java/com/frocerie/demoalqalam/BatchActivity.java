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
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.frocerie.demoalqalam.batchphase.DayActivity;
import com.frocerie.demoalqalam.batchphase.FullDayActivity;
import com.frocerie.demoalqalam.batchphase.HifdActivity;
import com.frocerie.demoalqalam.batchphase.MagribActivity;
import com.frocerie.demoalqalam.batchphase.PartTimeActivity;
import com.frocerie.demoalqalam.batchphase.RegularMadrasActivity;

import static com.frocerie.demoalqalam.R.id.tvNum;

public class BatchActivity extends AppCompatActivity {


    ListView lv;
    String[] batchNum;
    String[] batchTitles;
    //Animation myAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batch);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // myAnimation = AnimationUtils.loadAnimation(BatchActivity.this,R.anim.text_animation);

        Resources res = getResources();

        batchNum = res.getStringArray(R.array.num);
        batchTitles = res.getStringArray(R.array.batch);

        lv = (ListView) findViewById(R.id.lvListView);

        ListAdapterView listAdapterView = new ListAdapterView(this, batchNum, batchTitles);
        lv.setAdapter(listAdapterView);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {

                    case 0:
                        //Toast.makeText(DayActivity.this,"Click",Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BatchActivity.this, HifdActivity.class);
                        startActivity(intent);
                        break;

                    case 1:
                        //Toast.makeText(DayActivity.this,"Click",Toast.LENGTH_SHORT).show();

                        Intent intent1 = new Intent(BatchActivity.this, RegularMadrasActivity.class);
                        startActivity(intent1);
                        break;

                    case 2:
                        //Toast.makeText(DayActivity.this,"Click",Toast.LENGTH_SHORT).show();

                        Intent intent2 = new Intent(BatchActivity.this, FullDayActivity.class);
                        startActivity(intent2);
                        break;

                    case 3:
                        //Toast.makeText(DayActivity.this,"Click",Toast.LENGTH_SHORT).show();

                        Intent intent3 = new Intent(BatchActivity.this, PartTimeActivity.class);
                        startActivity(intent3);
                        break;

                    case 4:
                        //Toast.makeText(DayActivity.this,"Click",Toast.LENGTH_SHORT).show();

                        Intent intent4 = new Intent(BatchActivity.this, DayActivity.class);
                        startActivity(intent4);
                        break;

                   /* case 5:
                        //Toast.makeText(DayActivity.this,"Click",Toast.LENGTH_SHORT).show();

                        Intent intent5 = new Intent(BatchActivity.this, ArabicActivity.class);
                        startActivity(intent5);
                        break;

                    case 6:
                        //Toast.makeText(DayActivity.this,"Click",Toast.LENGTH_SHORT).show();

                        Intent intent6 = new Intent(BatchActivity.this, QuranActivity.class);
                        startActivity(intent6);
                        break;

                    case 7:
                        //Toast.makeText(DayActivity.this,"Click",Toast.LENGTH_SHORT).show();

                        Intent intent7 = new Intent(BatchActivity.this, UrduActivity.class);
                        startActivity(intent7);
                        break;

                    case 8:
                        //Toast.makeText(DayActivity.this,"Click",Toast.LENGTH_SHORT).show();

                        Intent inte = new Intent(BatchActivity.this, TafseerActivity.class);
                        startActivity(inte);
                        break;

                    case 9:
                        //Toast.makeText(DayActivity.this,"Click",Toast.LENGTH_SHORT).show();

                        Intent in = new Intent(BatchActivity.this, WeeklyActivity.class);
                        startActivity(in);
                        break;

                    case 10:
                        //Toast.makeText(DayActivity.this,"Click",Toast.LENGTH_SHORT).show();

                        Intent intent8 = new Intent(BatchActivity.this, HadeesActivity.class);
                        startActivity(intent8);
                        break;*/

                    case 5:

                        //Toast.makeText(DayActivity.this,"Click",Toast.LENGTH_SHORT).show();

                        Intent inten = new Intent(BatchActivity.this, MagribActivity.class);
                        startActivity(inten);
                        break;


                }


            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(BatchActivity.this);

        }




        return super.onOptionsItemSelected(item);
    }


}

//Cearing CustomAdapter

class ListAdapterView extends ArrayAdapter<String> {

    Context context;
    String[] titleBatch;
    String[] titleNum;



    ListAdapterView(Context c,String[] num,String[] titles){

        super(c,R.layout.single_row, tvNum,num);
        this.context = c;
        this.titleBatch = titles;
        this.titleNum = num;

    }

    //This method iis used to set the in the textView defined in seprate XML file(single_row)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //we need to get the layout and populate in Java file
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.single_row,parent,false);

        TextView myNum = (TextView) row.findViewById(tvNum);
        myNum.setText(titleNum[position]);
        myNum.setAnimation(AnimationUtils.loadAnimation(context,R.anim.text_animation));

        TextView myTitle = (TextView) row.findViewById(R.id.tvBatch);
        myTitle.setText(titleBatch[position]);
        myTitle.setAnimation(AnimationUtils.loadAnimation(context,R.anim.text_animation));

        return row;
    }
}