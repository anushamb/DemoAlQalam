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
public class FearPeopleFragmnet extends Fragment {


    public FearPeopleFragmnet() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View vFear = inflater.inflate(R.layout.fragment_fear_people, container, false);
        return vFear;
    }

}
