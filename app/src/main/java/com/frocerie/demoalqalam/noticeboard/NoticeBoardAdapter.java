package com.frocerie.demoalqalam.noticeboard;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.frocerie.demoalqalam.R;

import java.util.List;

/**
 * Created by avocet on 22/06/17.
 */

public class NoticeBoardAdapter extends RecyclerView.Adapter<NoticeBoardAdapter.ViewHolder>  {


    private List<ListItem> listItems;
    private Context context;




    public NoticeBoardAdapter(List<ListItem> listItems,Context context){

        this.listItems = listItems;
        this.context = context;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);



        return  new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        ListItem listItem = listItems.get(position);
        holder.textViewHead.setText(listItem.getHead());
        holder.textViewDate.setText(listItem.getDate());
        holder.textViewDesc.setText(listItem.getDesc());



    }


    @Override
    public int getItemCount() {
        return listItems.size();
    }


    public  class ViewHolder extends  RecyclerView.ViewHolder{


        public TextView textViewHead , textViewDesc;

        public  TextView textViewDate;


        public ViewHolder(View itemView) {
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);

            textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);

            textViewDate = (TextView) itemView.findViewById(R.id.textViewDate);




        }
    }




}
