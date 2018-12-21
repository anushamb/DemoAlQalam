package com.frocerie.demoalqalam.weeklyplan;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.frocerie.demoalqalam.R;

import java.util.List;

/**
 * Created by avocet on 28/06/17.
 */

public class ListOfSubClassAdapter  extends RecyclerView.Adapter<ListOfSubClassAdapter.ViewHolder>{

   private  List<SubClassModel> listSub;

    private Context contextl;


    public ListOfSubClassAdapter(List<SubClassModel> listSub, Context contextl) {
        this.listSub = listSub;
        this.contextl = contextl;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //method is called when the Instace of the ViewHolder is created

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sub_class,parent,false);

        return new ViewHolder(v);



    }




    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //method will bind the data to the ViewHolder,,,we will show the actule data to the RecyclerView

        SubClassModel subItem = listSub.get(position);

        holder.tvSubClass.setText(subItem.getSubClass());

        //holder.lVSubClass.setText()





    }




    @Override
    public int getItemCount() {
        return listSub.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvSubClass;
       //public ListView lVSubClass;



        public ViewHolder(View itemView) {


            super(itemView);

            tvSubClass = (TextView) itemView.findViewById(R.id.tvSubClass);

           // lVSubClass = (ListView) itemView.findViewById(R.id.lVSubClass);
        }
    }
}
