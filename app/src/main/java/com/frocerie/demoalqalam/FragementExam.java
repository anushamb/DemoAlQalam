package com.frocerie.demoalqalam;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragementExam extends Fragment implements View.OnClickListener {

    //Button first, second, third;

    TextView  first, second, third;
    public static final String RANK_ORDER = "RANK_ORDER";
    View view;


    public FragementExam() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_exam, container, false);
        intialize();

        return view;
    }

    private void intialize() {

       /* first = (Button) view.findViewById(R.id.first);
        first.setOnClickListener(FragementExam.this);
        first.setTag("1st_term");*/

       /* second = (Button) view.findViewById(R.id.second);
        second.setOnClickListener(FragementExam.this);
        second.setTag("2nd_term");*/


 /*       third = (Button) view.findViewById(R.id.third);
        third.setOnClickListener(FragementExam.this);
        third.setTag("3rd_term");*/



      first = (TextView) view.findViewById(R.id.first);
        first.setOnClickListener(FragementExam.this);
        first.setTag("1st_term");
        second = (TextView) view.findViewById(R.id.second);
        second.setOnClickListener(FragementExam.this);
        second.setTag("2nd_term");


       third = (TextView) view.findViewById(R.id.third);
        third.setOnClickListener(FragementExam.this);
        third.setTag("3rd_term");


    }

    @Override
    public void onClick(View view) {



        int id = view.getId();
        Intent intent = new Intent(getActivity(), ListOfRankActivity.class);
        String tag = view.getTag().toString();
        intent.putExtra(RANK_ORDER, tag);

        switch (id) {

            case R.id.first:
            case R.id.second:
            case R.id.third:
                startActivity(intent);
                break;

        }


    }
}
