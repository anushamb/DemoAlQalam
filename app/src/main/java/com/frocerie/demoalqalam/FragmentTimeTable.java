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
public class FragmentTimeTable extends Fragment {


    String[] timeTable;

    ListView listV;
    View vi;
    MyTimeTableAdapter myTimeTableAdapter;



    public FragmentTimeTable() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       vi = inflater.inflate(R.layout.fragment_time_table,container,false);

        listV = (ListView) vi.findViewById(R.id.listViewTime);

        Resources re = getResources();
        timeTable = re.getStringArray(R.array.portion);

        myTimeTableAdapter = new MyTimeTableAdapter(getActivity(),timeTable,android.R.layout.simple_expandable_list_item_1);
        listV.setAdapter(myTimeTableAdapter);
        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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




        return vi;
    }

}



class MyTimeTableAdapter extends ArrayAdapter<String>{

    Context context;
    String[] titleTime;


    public MyTimeTableAdapter(Context c, String[] timeTable, int i){

        super(c,R.layout.single_text,R.id.tvText,timeTable);
        this.context = c;
        this.titleTime = timeTable;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View ro = inflater.inflate(R.layout.single_text,parent,false);


        TextView timeTable = (TextView) ro.findViewById(R.id.tvText);
        timeTable.setText(titleTime[position]);

        return  ro;



    }
}