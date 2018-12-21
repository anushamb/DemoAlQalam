package com.frocerie.demoalqalam;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.frocerie.demoalqalam.dua.AblutionActivityDua;
import com.frocerie.demoalqalam.dua.AllahDuaActivity;
import com.frocerie.demoalqalam.dua.AngerActivityDua;
import com.frocerie.demoalqalam.dua.AnguishActivity;
import com.frocerie.demoalqalam.dua.AnimalActivity;
import com.frocerie.demoalqalam.dua.AssemblyActivityDua;
import com.frocerie.demoalqalam.dua.ClothesActivityDua;
import com.frocerie.demoalqalam.dua.CongraulationsActivityDua;
import com.frocerie.demoalqalam.dua.DeathActivityDua;
import com.frocerie.demoalqalam.dua.DevilActivityDua;
import com.frocerie.demoalqalam.dua.DifficultiesActivityDua;
import com.frocerie.demoalqalam.dua.EatingActivityDua;
import com.frocerie.demoalqalam.dua.EnemyActivityDua;
import com.frocerie.demoalqalam.dua.EnteringActivityDua;
import com.frocerie.demoalqalam.dua.EvilActivityDua;
import com.frocerie.demoalqalam.dua.FailureActivityDua;
import com.frocerie.demoalqalam.dua.FaithActivityDua;
import com.frocerie.demoalqalam.dua.FastActivityDua;
import com.frocerie.demoalqalam.dua.FearActivityDua;
import com.frocerie.demoalqalam.dua.FirstDatesActivityDua;
import com.frocerie.demoalqalam.dua.FrightenedActivityDua;
import com.frocerie.demoalqalam.dua.GoodToActivityDua;
import com.frocerie.demoalqalam.dua.GoodnessActivityDua;
import com.frocerie.demoalqalam.dua.GreetingsActivityDua;
import com.frocerie.demoalqalam.dua.GroomActivity;
import com.frocerie.demoalqalam.dua.HajjActivityDua;
import com.frocerie.demoalqalam.dua.HomeActivityDua;
import com.frocerie.demoalqalam.dua.IntercourseActivityDua;
import com.frocerie.demoalqalam.dua.IstikharahActivity;
import com.frocerie.demoalqalam.dua.MarketActivityDua;
import com.frocerie.demoalqalam.dua.MasqueActivityDua;
import com.frocerie.demoalqalam.dua.MisfortuneActivityDua;
import com.frocerie.demoalqalam.dua.MoneyActivityDua;
import com.frocerie.demoalqalam.dua.NewMoonActivityDua;
import com.frocerie.demoalqalam.dua.PainActivityDua;
import com.frocerie.demoalqalam.dua.PleaseActivityDua;
import com.frocerie.demoalqalam.dua.RainActivityDua;
import com.frocerie.demoalqalam.dua.RepenAndSeekActivity;
import com.frocerie.demoalqalam.dua.RulerActivityDua;
import com.frocerie.demoalqalam.dua.SalahActivityDua;
import com.frocerie.demoalqalam.dua.SickActivityDua;
import com.frocerie.demoalqalam.dua.SinActivityDua;
import com.frocerie.demoalqalam.dua.SleepActivityDua;
import com.frocerie.demoalqalam.dua.SneezingActivityDua;
import com.frocerie.demoalqalam.dua.SurprisedActivityDua;
import com.frocerie.demoalqalam.dua.TellsYoActivityDua;
import com.frocerie.demoalqalam.dua.WitrActivityDua;
import com.frocerie.demoalqalam.dua.WorryActivityDua;

import java.util.ArrayList;
import java.util.Arrays;

public class ListOfDua extends AppCompatActivity {


    ListView lv;
    //SearchView sv;

    String[] dTitles;

    ArrayAdapter<String> adapter;
    Intent intent;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_dua);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Resources res = getResources();
        dTitles = res.getStringArray(R.array.arry_lists);

        lv = (ListView) findViewById(R.id.listview);
        //sv = (SearchView) findViewById(R.id.searchView);


        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(getResources().getStringArray(R.array.arry_lists)));

        adapter = new ArrayAdapter<>(
                ListOfDua.this,
                android.R.layout.simple_list_item_1,
                dTitles);

        //adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dTitles);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i){

                    case 0 :

                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        //Toast.makeText(DayActivity.this,"Click",Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDua.this,AblutionActivityDua.class);
                        startActivity(intent);
                        break;

                    case 1 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(DayActivity.this,"Click",Toast.LENGTH_SHORT).show();

                        intent= new Intent(ListOfDua.this, AllahDuaActivity.class);
                        startActivity(intent);
                        break;

                    case 2 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(DayActivity.this,"Click",Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDua.this,AngerActivityDua.class);
                        startActivity(intent);
                        break;

                    case 3 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(DayActivity.this,"Click",Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDua.this,AnimalActivity.class);
                        startActivity(intent);
                        break;

                    case 4 :

                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDua.this,AnguishActivity.class);
                        startActivity(intent);
                        break;

                    case 5 :

                       //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(DayActivity.this,"Click",Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDua.this,AssemblyActivityDua.class);
                        startActivity(intent);
                        break;

                    case 6 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDua.this,ClothesActivityDua.class);
                        startActivity(intent);
                        break;

                    case 7 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();
                        intent = new Intent(ListOfDua.this,CongraulationsActivityDua.class);
                        startActivity(intent);
                        break;

                    case 8:
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDua.this,DeathActivityDua.class);
                        startActivity(intent);
                        break;

                    case 9 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();
                        intent = new Intent(ListOfDua.this,DevilActivityDua.class);
                        startActivity(intent);
                        break;

                    case 10 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDua.this,DifficultiesActivityDua.class);
                        startActivity(intent);
                        break;

                    case 11 :

                       // Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent(ListOfDua.this,EatingActivityDua.class);
                        startActivity(intent);
                        break;
                    case 12 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent(ListOfDua.this,EvilActivityDua.class);
                        startActivity(intent);
                        break;

                    case 13 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent= new Intent(ListOfDua.this, EnemyActivityDua.class);
                        startActivity(intent);
                        break;

                    case 14 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDua.this,FailureActivityDua.class);
                        startActivity(intent);
                        break;

                    case 15 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDua.this,FaithActivityDua.class);
                        startActivity(intent);
                        break;

                    case 16 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDua.this,FastActivityDua.class);
                        startActivity(intent);
                        break;

                    case 17 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDua.this,FrightenedActivityDua.class);
                        startActivity(intent);
                        break;

                    case 18 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent(ListOfDua.this,FirstDatesActivityDua.class);
                        startActivity(intent);
                        break;

                    case 19 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDua.this,FearActivityDua.class);
                        startActivity(intent);
                        break;

                    case 20:
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent(ListOfDua.this,GoodToActivityDua.class);
                        startActivity(intent);
                        break;

                    case  21 :

                        intent = new Intent(ListOfDua.this,TellsYoActivityDua.class);
                        startActivity(intent);
                        break;


                    case 22 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();
                        intent = new Intent(ListOfDua.this,GreetingsActivityDua.class);
                        startActivity(intent);
                        break;


                    case 23 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(ListOfDua.this,GroomActivity.class));


                        break;

                    case 24 :

                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent(ListOfDua.this,HajjActivityDua.class);
                        startActivity(intent);
                        break;
                    case 25:

                        intent = new Intent(ListOfDua.this,HomeActivityDua.class);
                         startActivity(intent);
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        break;

                    case 26 :

                        intent = new Intent(ListOfDua.this,MisfortuneActivityDua.class);
                        startActivity(intent);

                        break;

                    case 27:

                        intent = new Intent(ListOfDua.this,IntercourseActivityDua.class);
                         startActivity(intent);


                        break;

                    case 28 :

                        startActivity(new Intent(ListOfDua.this,IstikharahActivity.class));

                        break;

                    case 29:
                       // Toast.makeText(ListOfDua.this,"Coneect to Server and fetch Image",Toast.LENGTH_SHORT).show();

                        intent= new Intent(ListOfDua.this, MarketActivityDua.class);
                        startActivity(intent);


                        break;

                    case 30 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent= new Intent(ListOfDua.this,MoneyActivityDua.class);
                        startActivity(intent);

                    break;


                    case 31 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDua.this,MasqueActivityDua.class);
                        startActivity(intent);

                        break;

                    case 32 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDua.this,NewMoonActivityDua.class);
                        startActivity(intent);
                        break;



                    case 33 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent(ListOfDua.this,PainActivityDua.class);
                        startActivity(intent);
                        break;


                    case 34 :

                       // Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDua.this,RainActivityDua.class);
                        startActivity(intent);
                        break;

                    case 35 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent(ListOfDua.this,RepenAndSeekActivity.class);
                        startActivity(intent);
                        break;

                    case 36 :
                        //Toast.makeText(ListOfDua.this,"Click to connect server //REPENTANCE AND SEEKING FORGIVENESS",Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDua.this,RulerActivityDua.class);
                        startActivity(intent);
                        break;

                    case 37 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                          intent = new Intent(ListOfDua.this,SickActivityDua.class);
                        startActivity(intent);
                        break;

                    case 38:
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDua.this,SalahActivityDua.class);
                        startActivity(intent);

                        break;

                    case 39 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();
                        //Name of line


                        intent = new Intent(ListOfDua.this,SinActivityDua.class);
                        startActivity(intent);
                        break;

                    case 40 :
                       // T//oast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDua.this,SleepActivityDua.class);
                        startActivity(intent);
                        break;

                    case 41 :

                       // Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();
                        intent = new Intent(ListOfDua.this,SneezingActivityDua.class);
                        startActivity(intent);


                        break;

                    case 42:

                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDua.this,SurprisedActivityDua.class);
                        startActivity(intent);

                        break;

                    case 43:

                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent(ListOfDua.this,EnteringActivityDua.class);
                        startActivity(intent);
                        break;

                    case 44:

                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent(ListOfDua.this,PleaseActivityDua.class);
                        startActivity(intent);
                        break;

                    case 45:

                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent(ListOfDua.this,TravelActivityDua.class);
                        startActivity(intent);
                        break;

                    case 46:

                        //Toast.makeText(ListOfDua.this,"Click to connect server",Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDua.this,GoodnessActivityDua.class);
                        startActivity(intent);
                        break;

                    case 47:

                        //Toast.makeText(ListOfDua.this,"Click to connect server",Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDua.this,WitrActivityDua.class);
                        startActivity(intent);
                        break;

                    case 48:

                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent(ListOfDua.this,WorryActivityDua.class);
                        startActivity(intent);
                        break;


                }




            }
        });

        /*sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);

                return false;
            }
        });*/

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search,menu);

        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(ListOfDua.this);

        }




        return super.onOptionsItemSelected(item);
    }
}



