package com.frocerie.demoalqalam.speechinfo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.frocerie.demoalqalam.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by avocet on 12/06/17.
 */

public class SpeechInfoAdapter extends RecyclerView.Adapter<SpeechInfoAdapter.ViewHolder> {

    private ArrayList<ListSpeechInfoItemModel> arrayList = new ArrayList<ListSpeechInfoItemModel>();

    private View.OnClickListener speechItemClickListener;


    //private List<ListSpeechInfoItemModel> listItem;
    private Context context;
     public static final String RANK_ORDER = "RANK_ORDER";

    public SpeechInfoAdapter(ArrayList<ListSpeechInfoItemModel> listItem,View.OnClickListener onClickListener, Context context) {


        this.arrayList = listItem;
        this.context = context;

        this.speechItemClickListener = onClickListener;


    }



    /*public SpeechInfoAdapter(ArrayList<ListSpeechInfoItemModel> listItem, Context context) {


        this.arrayList = listItem;
        this.context = context;


    }
*/

    @Override
    public SpeechInfoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.speech_item,parent,false);
        //View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.spech_list_item,parent,false);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.speech_info_item, parent, false);
        //return new ViewHolder(v,context,arrayList);

        return new ViewHolder(v);


    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {


        if (arrayList == null){
            return;
        }

        //to get the specific position of the listItem
        final ListSpeechInfoItemModel listItemModel = arrayList.get(position);


        if (listItemModel == null){
            return;
        }


        if (holder instanceof ViewHolder){

            if (TextUtils.isEmpty(listItemModel.getHead())){
                return;
            }
            holder.textViewHead.setText(listItemModel.getHead());
            holder.textViewDesc.setText(listItemModel.getDesc());

            Picasso.with(context)
                    .load(listItemModel.getImageUrl())
                    .into(holder.imageView);


            holder.imageView.setTag(listItemModel.getImageUrl());
            holder.imageView.setOnClickListener(speechItemClickListener);


        }

    }

        //setting the header and description to the TextView


        //To load image we are using Picasso library file


        //code for clicking the lineralayout

    /*    holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // int i = view.getId();

                //switch (i){

                //case 0 :
                Toast.makeText(context, "Image Zoomout Activity", Toast.LENGTH_SHORT).show();

                //Intent intent = new Intent(context,ImageZoomActivity.class);
                //intent.putExtra("image",);
                //context.startActivity(intent);


                //break;


                //}


            }
        });
*/

      /*  holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context,"You clicked" + listItemModel.getHead(),Toast.LENGTH_LONG).show();

            }
        });*/

      /* holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context,"You clicked" + listItemModel.getHead(),Toast.LENGTH_LONG).show();

            }
        });*/




    @Override
    public int getItemCount() {
        //return the size of the list

        return arrayList.size();
    }


   public class ViewHolder extends RecyclerView.ViewHolder {


        public TextView textViewHead;
        public TextView textViewDesc;
        public ImageView imageView;
        // public LinearLayout linearLayout;
        //public ConstraintLayout constraintLayout;


        public ViewHolder(View itemView) {
            super(itemView);

            //textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
            //textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            //imageView = (ImageView) itemView.findViewById(R.id.imageView);

            textViewHead = (TextView) itemView.findViewById(R.id.tvspechhead);
            textViewDesc = (TextView) itemView.findViewById(R.id.tvSpeecDate);
            imageView = (ImageView) itemView.findViewById(R.id.ivSpeech);

            //constraintLayout = (ConstraintLayout) itemView.findViewById(R.id.spech_layout);

            //linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);


        }
    }

    //Implementing the onClickListener in viewholder class......

    /*public class SpeechViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public TextView textViewHead;
        public TextView textViewDesc;
        public ImageView imageView;
        Context ctx;
        ArrayList<ListSpeechInfoItemModel> speechInfoItem = new ArrayList<ListSpeechInfoItemModel>();

        // public LinearLayout linearLayout;
        //public ConstraintLayout constraintLayout;*/


     /*   public SpeechViewHolder(View itemView,Context ctx,ArrayList<ListSpeechInfoItemModel> speechInfoItem ) {
            super(itemView);

            this.speechInfoItem = speechInfoItem;
            this.ctx = ctx;


            //we need to register the click option on cradview
            itemView.setOnClickListener(this);


            //textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
            //textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            //imageView = (ImageView) itemView.findViewById(R.id.imageView);

            textViewHead = (TextView) itemView.findViewById(R.id.tvspechhead);
            textViewDesc = (TextView) itemView.findViewById(R.id.tvSpeecDate);
            imageView = (ImageView) itemView.findViewById(R.id.ivSpeech);

            //constraintLayout = (ConstraintLayout) itemView.findViewById(R.id.spech_layout);

            // linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);


        }

        @Override
        public void onClick(View view) {

            //Getting the position of the particular clicked cardView
            int position = getAdapterPosition();

            //Get the particular Object from the ArrayList..(ModelClass we need)
            ListSpeechInfoItemModel speechInfoModel = this.speechInfoItem.get(position);

            //Now we have to start new Activity....
            Intent intent = new Intent(this.ctx,SpeechInfoImageActivity.class);

            //Before starting the new activity we need add the Information to the Intenet....
            //we will get the data or Imge from calling the getter method of the Model class..
           intent.putExtra("img_speech",speechInfoModel.getImageUrl().toString());
           // intent.putExtras(speechInfoModel.getImageUrl().toString());
            //intent.putExtra("head_speech",speechInfoModel.getHead());
            //intent.putExtra("date_speech",speechInfoModel.getDesc());
            this.ctx.startActivity(intent);

        }
    }*/


}
