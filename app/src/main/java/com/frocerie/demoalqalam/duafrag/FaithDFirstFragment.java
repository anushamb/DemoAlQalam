package com.frocerie.demoalqalam.duafrag;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.frocerie.demoalqalam.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FaithDFirstFragment extends Fragment {


    public FaithDFirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_faith_dfirst, container, false);
        return v;
    }

}
