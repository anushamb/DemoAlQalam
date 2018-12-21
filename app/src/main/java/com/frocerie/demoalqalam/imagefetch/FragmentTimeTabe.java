package com.frocerie.demoalqalam.imagefetch;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.frocerie.demoalqalam.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTimeTabe extends Fragment {

    String[] timeTable ;

   // String[] timeTable = {"LKG","UKG","1st_Std"};
    private RecyclerView mRecyclerView;
    private SongAdapter adapter;
   View v;

    public FragmentTimeTabe() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       v = inflater.inflate(R.layout.fragment_timetab, container, false);

        setAdapter();

       Resources resources = getResources();
        timeTable = resources.getStringArray(R.array.portion);

        return v;


    }

    private void setAdapter() {

        mRecyclerView = (RecyclerView) v.findViewById(R.id.rcyclerTimetab);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        adapter = new SongAdapter(timeTable,getContext());
        mRecyclerView.setAdapter(adapter);


    }

}
