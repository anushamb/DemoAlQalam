package com.frocerie.demoalqalam.materialhadees;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.frocerie.demoalqalam.R;

import java.util.ArrayList;
import java.util.Arrays;

public class MateriHadeesActivity extends AppCompatActivity {


    ListView listViewHade;
    Intent intent;

    String[] dHadees;

    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_hadees);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        Resources res = getResources();
        dHadees = res.getStringArray(R.array.hadees_list);


        //listViewHade.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.dua_animation));


        listViewHade = (ListView) findViewById(R.id.listViewHade);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(getResources().getStringArray(R.array.hadees_list)));

        adapter = new ArrayAdapter<>(
                MateriHadeesActivity.this,
                android.R.layout.simple_list_item_1,
                dHadees);


        listViewHade.setAdapter(adapter);

        listViewHade.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i){


                    case 0 :


                        intent = new Intent( MateriHadeesActivity.this,SeekingHadeesActivity.class);
                        startActivity(intent);
                        break;

                    case 1 :

                        intent= new Intent( MateriHadeesActivity.this, FaceHadeesActivity.class);
                        startActivity(intent);
                        break;

                    case 2 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(DayActivity.this,"Click",Toast.LENGTH_SHORT).show();

                        intent = new Intent( MateriHadeesActivity.this,TootHadeesActivity.class);
                        startActivity(intent);
                        break;

                    case 3 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(DayActivity.this,"Click",Toast.LENGTH_SHORT).show();

                        intent = new Intent( MateriHadeesActivity.this,WayHadeesActivity.class);
                        startActivity(intent);
                        break;

                    case 4 :

                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent( MateriHadeesActivity.this,ForgHadeesActivity.class);
                        startActivity(intent);
                        break;

                    case 5 :

                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(DayActivity.this,"Click",Toast.LENGTH_SHORT).show();

                        intent = new Intent( MateriHadeesActivity.this,RightHadeesActivity.class);
                        startActivity(intent);
                        break;

                    case 6 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent( MateriHadeesActivity.this,DiniHadeesActivity.class);
                        startActivity(intent);
                        break;

                    case 7 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();
                        intent = new Intent( MateriHadeesActivity.this,ThreeHadeesActivityDua.class);
                        startActivity(intent);
                        break;

                    case 8:
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent( MateriHadeesActivity.this,ProhiHadeesActivity.class);
                        startActivity(intent);
                        break;

                    case 9 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();
                        intent = new Intent( MateriHadeesActivity.this,ExellHadeesActivity.class);
                        startActivity(intent);
                        break;

                    case 10 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent( MateriHadeesActivity.this,PlesuHadeesActivity.class);
                        startActivity(intent);
                        break;

                    case 11 :

                        // Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent( MateriHadeesActivity.this,BlooHadeesActivity.class);
                        startActivity(intent);
                        break;
                    case 12 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent( MateriHadeesActivity.this,FriendHadeesActivity.class);
                        startActivity(intent);
                        break;

                    case 13 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent= new Intent( MateriHadeesActivity.this, BeHadessActivity.class);
                        startActivity(intent);
                        break;

                    case 14 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent( MateriHadeesActivity.this,KindHadeesActivity.class);
                        startActivity(intent);
                        break;

                    case 15 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent( MateriHadeesActivity.this,TongHadeesActivity.class);
                        startActivity(intent);
                        break;

                    case 16 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent( MateriHadeesActivity.this,LyiHadessActvity.class);
                        startActivity(intent);
                        break;

                    case 17 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent( MateriHadeesActivity.this,CursinHadeesActvity.class);
                        startActivity(intent);
                        break;

                    case 18 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent( MateriHadeesActivity.this,BackHadeesActvity.class);
                        startActivity(intent);
                        break;

                    case 19 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent( MateriHadeesActivity.this,SusHadeesActivity.class);
                        startActivity(intent);
                        break;

                    case 20:
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent( MateriHadeesActivity.this,NeigHadeesActvity.class);
                        startActivity(intent);
                        break;

                    case  21 :

                        intent = new Intent( MateriHadeesActivity.this,BroHadeesActivity.class);
                        startActivity(intent);
                        break;


                    case 22 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();
                        intent = new Intent( MateriHadeesActivity.this,PriHadeesActivity.class);
                        startActivity(intent);
                        break;


                    case 23 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent( MateriHadeesActivity.this,ChaHadeesActvity.class));


                        break;

                    case 24 :

                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent( MateriHadeesActivity.this,FridHadeesActivity.class);
                        startActivity(intent);
                        break;
                    case 25:

                        intent = new Intent( MateriHadeesActivity.this,DonHadeesActvity.class);
                        startActivity(intent);
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        break;

                    case 26 :

                        intent = new Intent( MateriHadeesActivity.this,SinsHadeesActivity.class);
                        startActivity(intent);

                        break;

                    case 27:

                        intent = new Intent( MateriHadeesActivity.this,ArrogHadeesActivity.class);
                        startActivity(intent);


                        break;

                    case 28 :

                        startActivity(new Intent( MateriHadeesActivity.this,WhiteHadeesActivity.class));

                        break;

                    case 29:
                        // Toast.makeText(ListOfDua.this,"Coneect to Server and fetch Image",Toast.LENGTH_SHORT).show();

                        intent= new Intent( MateriHadeesActivity.this, MaFeHadeesActivity.class);
                        startActivity(intent);


                        break;

                    case 30 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent= new Intent( MateriHadeesActivity.this,ImitHadeesActivity.class);
                        startActivity(intent);

                        break;


                    case 31 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent( MateriHadeesActivity.this,GoodHadeesActivity.class);
                        startActivity(intent);

                        break;

                    case 32 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent( MateriHadeesActivity.this,DeareHadeeesActivity.class);
                        startActivity(intent);
                        break;



                    case 33 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent( MateriHadeesActivity.this,MothHadeesActivity.class);
                        startActivity(intent);
                        break;


                    case 34 :

                        // Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();

                        intent = new Intent( MateriHadeesActivity.this,FathHadeesActivity.class);
                        startActivity(intent);
                        break;

                    case 35 :
                        //Toast.makeText(ListOfDua.this,"Click get the Image from Server//ANGUISH", Toast.LENGTH_SHORT).show();


                        intent = new Intent( MateriHadeesActivity.this,RelaHadeesActivity.class);
                        startActivity(intent);
                        break;

                    case 36 :
                        //Toast.makeText(ListOfDua.this,"Click to connect server //REPENTANCE AND SEEKING FORGIVENESS",Toast.LENGTH_SHORT).show();

                        intent = new Intent( MateriHadeesActivity.this,TieHadeesActivity.class);
                        startActivity(intent);
                        break;















                }





            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();



        if(id == R.id.home){

            NavUtils.navigateUpFromSameTask(this);

        }

        return super.onOptionsItemSelected(item);
    }
}
