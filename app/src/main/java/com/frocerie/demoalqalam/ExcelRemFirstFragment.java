package com.frocerie.demoalqalam;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExcelRemFirstFragment extends Fragment {


    public ExcelRemFirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vproot = inflater.inflate(R.layout.fragment_excel_rem_first, container, false);
        return vproot;
    }

}
