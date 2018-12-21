package com.frocerie.demoalqalam;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPortion extends Fragment {


    String[] portion;
    ListView listView;
    View view;
    MyExamAdapter myExamAdapter;



    public FragmentPortion() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view = inflater.inflate(R.layout.fragment_portion,container,false);

        listView = (ListView) view.findViewById(R.id.listViewExam);

        Resources res = getResources();
        portion = res.getStringArray(R.array.portion);

        myExamAdapter = new MyExamAdapter(getActivity(),portion,android.R.layout.simple_expandable_list_item_1);

        listView.setAdapter(myExamAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i){

                    case 0:

                          //Intent intent = new Intent(getActivity(),ClassPortionLkg.class);
                          //intent.putExtra("LKG",i);
                           //startActivity(intent);

                        startActivity(new Intent(getActivity(),ClassPortionLkg.class));

                        //Toast.makeText(getActivity(),"Fetch Image From Server",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:

                        startActivity(new Intent(getActivity(),ClassPortionUkg.class));

                        //Toast.makeText(getActivity(),"Fetch Image From Server",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:

                        startActivity(new Intent(getActivity(),ClassPortionLkg.class));

                        //Toast.makeText(getActivity(),"Fetch Image From Server",Toast.LENGTH_SHORT).show();
                        break;
                    case  3:
                        startActivity(new Intent(getActivity(),ClassPortionLkg.class));

                        //Toast.makeText(getActivity(),"RFetch Image From Server",Toast.LENGTH_SHORT).show();
                        break;
                    case 4:

                        startActivity(new Intent(getActivity(),ClassPortionLkg.class));

                        //Toast.makeText(getActivity(),"Fetch Image From Server",Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        startActivity(new Intent(getActivity(),ClassPortionLkg.class));

                        //Toast.makeText(getActivity(),"Fetch Image From Server",Toast.LENGTH_SHORT).show();
                        break;
                    case 6:

                        startActivity(new Intent(getActivity(),ClassPortionLkg.class));
                        //Toast.makeText(getActivity(),"Fetch Image From Server",Toast.LENGTH_SHORT).show();
                        break;
                    case 7:

                        startActivity(new Intent(getActivity(),ClassPortionLkg.class));
                        //Toast.makeText(getActivity(),"Fetch Image From Server",Toast.LENGTH_SHORT).show();
                        break;
                    case 8:

                        startActivity(new Intent(getActivity(),ClassPortionLkg.class));
                        //Toast.makeText(getActivity(),"Fetch Image From Server",Toast.LENGTH_SHORT).show();
                        break;
                    case 9:
                        startActivity(new Intent(getActivity(),ClassPortionLkg.class));

                        //Toast.makeText(getActivity(),"Fetch Image From Server",Toast.LENGTH_SHORT).show();
                        break;
                    case 10:
                        startActivity(new Intent(getActivity(),ClassPortionLkg.class));
                        //Toast.makeText(getActivity(),"Fetch Image From Server",Toast.LENGTH_SHORT).show();
                        break;
                    case 11:

                        startActivity(new Intent(getActivity(),ClassPortionLkg.class));
                        //Toast.makeText(getActivity(),"Fetch Image From Server",Toast.LENGTH_SHORT).show();
                        break;


                }


            }
        });





        return view;
    }

}
 class MyExamAdapter extends ArrayAdapter<String>{


     Context context;
     String[] titlePortion;

     public  MyExamAdapter(Context c,String[] portion,int i){

         super(c,R.layout.single_text,portion);
         this.context = c;
         this.titlePortion = portion;

     }


     @NonNull
     @Override
     public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


         LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

         View row = inflater.inflate(R.layout.single_text,parent,false);

         TextView portiopn = (TextView) row.findViewById(R.id.tvText);
         portiopn.setText(titlePortion[position]);

         return  row;




     }
 }