package com.frocerie.demoalqalam;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.frocerie.demoalqalam.model.PDFDetail;
import com.frocerie.demoalqalam.model.PDFModel;
import com.frocerie.demoalqalam.responseHandler.ResponseHandler;
import com.frocerie.demoalqalam.utils.GeneralUtils;
import com.frocerie.demoalqalam.utils.ProgressUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTalensDay extends Fragment implements View.OnClickListener {

    View view;
    Button nasheed, qeerath, speech, craft, writting, sports;

    private final String url = "http://alqalamtrust.com/talentsday_toppers/";

    public FragmentTalensDay() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_talens_day, container, false);

        init();

        return view;
    }

    private void init() {


        nasheed = (Button) view.findViewById(R.id.nasheed);
        nasheed.setOnClickListener(FragmentTalensDay.this);
        nasheed.setTag("Nasheed");

        qeerath = (Button) view.findViewById(R.id.qeerath);
        qeerath.setOnClickListener(FragmentTalensDay.this);
        qeerath.setTag("Qeerat");

        speech = (Button) view.findViewById(R.id.speech);
        speech.setOnClickListener(FragmentTalensDay.this);
        speech.setTag("Speech");

        craft = (Button) view.findViewById(R.id.craft);
        craft.setOnClickListener(FragmentTalensDay.this);
        craft.setTag("Craft");

        writting = (Button) view.findViewById(R.id.writting);
        writting.setOnClickListener(FragmentTalensDay.this);
        writting.setTag("Writing");

        sports = (Button) view.findViewById(R.id.sports);
        sports.setOnClickListener(FragmentTalensDay.this);
        sports.setTag("Sports");


    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        String tag = view.getTag().toString();


        switch (id) {


            case R.id.nasheed:
            case R.id.qeerath:
            case R.id.speech:
            case R.id.craft:
            case R.id.writting:
            case R.id.sports:
                pdfRequestJson(tag);
                break;

        }


    }


    private void pdfRequestJson(String tag) {

        ProgressUtils.getInstance(getActivity()).show("Loading file..");

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url+tag, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                ProgressUtils.getInstance(getActivity()).cancel();

                if (TextUtils.isEmpty(response)) {

                    return;
                }

                PDFModel pdfModel = ResponseHandler.getPdfModel(response);

                if (pdfModel==null){

                    return;
                }

                if (pdfModel.getPDFDetails() == null && pdfModel.getPDFDetails().size()<=0){

                    return;
                }

                PDFDetail pdfDetail = pdfModel.getPDFDetails().get(0);
                if (pdfDetail == null){
                    return;
                }
            String path = pdfDetail.getPdfPath();
                if (TextUtils.isEmpty(path)){

                    return;
                }

                path="http://drive.google.com/viewerng/viewer?embedded=true&url="+path;

                GeneralUtils.launchUrlUsingChromeTab(getActivity(),path);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                ProgressUtils.getInstance(getActivity()).cancel();

            }
        });


    }

}
