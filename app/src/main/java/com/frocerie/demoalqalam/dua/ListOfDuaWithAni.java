package com.frocerie.demoalqalam.dua;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.frocerie.demoalqalam.R;
import com.frocerie.demoalqalam.TravelActivityDua;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class ListOfDuaWithAni extends AppCompatActivity {


    String[] listTitle;
    ListView listView;
    Intent intent;

    DuaAdapter duaAdapter;

    //ArrayAdapter<String> adapter;

    MaterialSearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_dua_with_ani);


        Resources res = getResources();
        listTitle = res.getStringArray(R.array.arry_lists);

        listView = (ListView) findViewById(R.id.listVdua);

        duaAdapter = new DuaAdapter(this,listTitle);
        listView.setAdapter(duaAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                switch (i){

                    case 0 :

                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        //Toast.makeText(DayActivity.this,"Click",Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDuaWithAni.this,AblutionActivityDua.class);
                        startActivity(intent);
                        break;

                    case 1 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(DayActivity.this,"Click",Toast.LENGTH_SHORT).show();

                        intent= new Intent(ListOfDuaWithAni.this, AllahDuaActivity.class);
                        startActivity(intent);
                        break;

                    case 2 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(DayActivity.this,"Click",Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDuaWithAni.this,AngerActivityDua.class);
                        startActivity(intent);
                        break;

                    case 3 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(DayActivity.this,"Click",Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDuaWithAni.this,AnimalActivity.class);
                        startActivity(intent);
                        break;

                    case 4 :

                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDuaWithAni.this,AnguishActivity.class);
                        startActivity(intent);
                        break;

                    case 5 :

                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(DayActivity.this,"Click",Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDuaWithAni.this,AssemblyActivityDua.class);
                        startActivity(intent);
                        break;

                    case 6 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDuaWithAni.this,ClothesActivityDua.class);
                        startActivity(intent);
                        break;

                    case 7 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();
                        intent = new Intent(ListOfDuaWithAni.this,CongraulationsActivityDua.class);
                        startActivity(intent);
                        break;

                    case 8:
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDuaWithAni.this,DeathActivityDua.class);
                        startActivity(intent);
                        break;

                    case 9 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();
                        intent = new Intent(ListOfDuaWithAni.this,DevilActivityDua.class);
                        startActivity(intent);
                        break;

                    case 10 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDuaWithAni.this,DifficultiesActivityDua.class);
                        startActivity(intent);
                        break;

                    case 11 :

                        // Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent(ListOfDuaWithAni.this,EatingActivityDua.class);
                        startActivity(intent);
                        break;
                    case 12 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent(ListOfDuaWithAni.this,EvilActivityDua.class);
                        startActivity(intent);
                        break;

                    case 13 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent= new Intent(ListOfDuaWithAni.this, EnemyActivityDua.class);
                        startActivity(intent);
                        break;

                    case 14 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDuaWithAni.this,FailureActivityDua.class);
                        startActivity(intent);
                        break;

                    case 15 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDuaWithAni.this,FaithActivityDua.class);
                        startActivity(intent);
                        break;

                    case 16 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDuaWithAni.this,FastActivityDua.class);
                        startActivity(intent);
                        break;

                    case 17 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDuaWithAni.this,FrightenedActivityDua.class);
                        startActivity(intent);
                        break;

                    case 18 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent(ListOfDuaWithAni.this,FirstDatesActivityDua.class);
                        startActivity(intent);
                        break;

                    case 19 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDuaWithAni.this,FearActivityDua.class);
                        startActivity(intent);
                        break;

                    case 20:
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent(ListOfDuaWithAni.this,GoodToActivityDua.class);
                        startActivity(intent);
                        break;

                    case  21 :

                        intent = new Intent(ListOfDuaWithAni.this,TellsYoActivityDua.class);
                        startActivity(intent);
                        break;


                    case 22 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();
                        intent = new Intent(ListOfDuaWithAni.this,GreetingsActivityDua.class);
                        startActivity(intent);
                        break;


                    case 23 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(ListOfDuaWithAni.this,GroomActivity.class));


                        break;

                    case 24 :

                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent(ListOfDuaWithAni.this,HajjActivityDua.class);
                        startActivity(intent);
                        break;
                    case 25:

                        intent = new Intent(ListOfDuaWithAni.this,HomeActivityDua.class);
                        startActivity(intent);
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        break;

                    case 26 :

                        intent = new Intent(ListOfDuaWithAni.this,MisfortuneActivityDua.class);
                        startActivity(intent);

                        break;

                    case 27:

                        intent = new Intent(ListOfDuaWithAni.this,IntercourseActivityDua.class);
                        startActivity(intent);


                        break;

                    case 28 :

                        startActivity(new Intent(ListOfDuaWithAni.this,IstikharahActivity.class));

                        break;

                    case 29:
                        // Toast.makeText(ListOfDua.this,"Coneect to Server and fetch Image",Toast.LENGTH_SHORT).show();

                        intent= new Intent(ListOfDuaWithAni.this, MarketActivityDua.class);
                        startActivity(intent);


                        break;

                    case 30 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent= new Intent(ListOfDuaWithAni.this,MoneyActivityDua.class);
                        startActivity(intent);

                        break;


                    case 31 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDuaWithAni.this,MasqueActivityDua.class);
                        startActivity(intent);

                        break;

                    case 32 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDuaWithAni.this,NewMoonActivityDua.class);
                        startActivity(intent);
                        break;



                    case 33 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent(ListOfDuaWithAni.this,PainActivityDua.class);
                        startActivity(intent);
                        break;


                    case 34 :

                        // Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDuaWithAni.this,RainActivityDua.class);
                        startActivity(intent);
                        break;

                    case 35 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent(ListOfDuaWithAni.this,RepenAndSeekActivity.class);
                        startActivity(intent);
                        break;

                    case 36 :
                        //Toast.makeText(ListOfDua.this,"Click to connect server //REPENTANCE AND SEEKING FORGIVENESS",Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDuaWithAni.this,RulerActivityDua.class);
                        startActivity(intent);
                        break;

                    case 37 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDuaWithAni.this,SickActivityDua.class);
                        startActivity(intent);
                        break;

                    case 38:
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDuaWithAni.this,SalahActivityDua.class);
                        startActivity(intent);

                        break;

                    case 39 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();
                        //Name of line


                        intent = new Intent(ListOfDuaWithAni.this,SinActivityDua.class);
                        startActivity(intent);
                        break;

                    case 40 :
                        // T//oast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDuaWithAni.this,SleepActivityDua.class);
                        startActivity(intent);
                        break;

                    case 41 :

                        // Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();
                        intent = new Intent(ListOfDuaWithAni.this,SneezingActivityDua.class);
                        startActivity(intent);

                        //nedd to add contens from here



                        break;

                    case 42:

                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDuaWithAni.this,SurprisedActivityDua.class);
                        startActivity(intent);

                        break;

                    case 43:

                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent(ListOfDuaWithAni.this,EnteringActivityDua.class);
                        startActivity(intent);
                        break;

                    case 44:

                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent(ListOfDuaWithAni.this,PleaseActivityDua.class);
                        startActivity(intent);
                        break;

                    case 45:

                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent(ListOfDuaWithAni.this,TravelActivityDua.class);
                        startActivity(intent);
                        break;

                    case 46:

                        //Toast.makeText(ListOfDua.this,"Click to connect server",Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDuaWithAni.this,GoodnessActivityDua.class);
                        startActivity(intent);
                        break;

                    case 47:

                        //Toast.makeText(ListOfDua.this,"Click to connect server",Toast.LENGTH_SHORT).show();

                        intent = new Intent(ListOfDuaWithAni.this,WitrActivityDua.class);
                        startActivity(intent);
                        break;

                    case 48:

                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent(ListOfDuaWithAni.this,WorryActivityDua.class);
                        startActivity(intent);
                        break;


                }




            }
        });


    }

    private void searchViewCode(){




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        /*MenuInflater inflater = getMenuInflater();
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


              // listTitle.getFilter().filter(newText);
             duaAdapter.getFilter().filter(newText);
                return true;
            }
        });
*/
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if(i == R.id.home){


            NavUtils.navigateUpFromSameTask(ListOfDuaWithAni.this);

        }




        return super.onOptionsItemSelected(item);
    }


    class  DuaAdapter extends ArrayAdapter<String>{

        Context context;
        String[] myTitles;


        DuaAdapter(Context c,String[] titels){

            super(c,R.layout.single_dua,R.id.textDua,titels);

            this.context = c;
            this.myTitles = titels;


        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View row = convertView;
            if(row == null){

                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = layoutInflater.inflate(R.layout.single_dua,parent,false);


            }

            //getting refernce to the textview
            TextView myTitle = (TextView) row.findViewById(R.id.textDua);


            myTitle.setText(myTitles[position]);
            myTitle.setAnimation(AnimationUtils.loadAnimation(context,R.anim.dua_animation));

            return row;
        }


    }

}
