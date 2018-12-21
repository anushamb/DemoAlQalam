package com.frocerie.demoalqalam.imagefetch;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.frocerie.demoalqalam.R;

/**
 * Created by avocet on 06/07/17.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.CustomViewHolder> {

    private String[] classArray;
    private Context context;

    public SongAdapter(String[] className,Context context){

        classArray =className;
        this.context = context;


    }



    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_month_list,parent,false);

        CustomViewHolder viewHolder = new CustomViewHolder(itemView);
        return viewHolder;



    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {

        holder.textView.setText(classArray[position].toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent newIntent = new Intent(context,SecondActivity.class);
                newIntent.putExtra("className",classArray[position].toString());
               context.startActivity(newIntent);

            }
        });




    }

    @Override
    public int getItemCount() {
        return classArray.length;
    }

    public class CustomViewHolder extends  RecyclerView.ViewHolder{

        public TextView textView;




        public CustomViewHolder(View itemView) {
            super(itemView);

            View view = itemView;
            this.textView = (TextView) itemView.findViewById(R.id.month_name);


        }
    }
}
