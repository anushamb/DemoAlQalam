package com.frocerie.demoalqalam.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.frocerie.demoalqalam.R;
import com.frocerie.demoalqalam.imagemodel.TouchImageView;
import com.frocerie.demoalqalam.model.ImageModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by avocet on 28/06/17.
 */

 public class ImageJanAdapter extends RecyclerView.Adapter<ImageJanAdapter.ViewHolder> {

  private List<ImageModel> listItem;
    private Context context;


    public ImageJanAdapter(List<ImageModel> listItem, Context context) {
        this.listItem = listItem;
        this.context = context;
    }

    @Override
    public ImageJanAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item,parent,false);



        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageJanAdapter.ViewHolder holder, int position) {

        final ImageModel imageModel = listItem.get(position);

        Picasso.with(context)
                .load(imageModel.getImageUrl())
               // .into(holder.touchImageView);
                .into(holder.imageView);


        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context,"You Clicked" + imageModel.getImageUrl(),Toast.LENGTH_SHORT).show();

            }
        });



    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TouchImageView touchImageView;

        public ImageView imageView;
        public LinearLayout linearLayout;


        public ViewHolder(View itemView) {
            super(itemView);

            //touchImageView = (TouchImageView) itemView.findViewById(R.id.imageViewMonth);

            imageView = (ImageView) itemView.findViewById(R.id.imageViewMonth);

            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayoutMonth);




        }
    }






}
