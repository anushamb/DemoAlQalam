package com.frocerie.demoalqalam.gall_youtube;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.frocerie.demoalqalam.R;

import java.util.ArrayList;

/**
 * Created by avocet on 26/07/17.
 */

public class YouTubeListAdapter extends RecyclerView.Adapter<YouTubeListAdapter.YouTubeViewHadler> {

    public ArrayList<YouTubeDetails> youTubeDetailsArrayList = new ArrayList<>();
    private View.OnClickListener youTubeItemClickListener;

    public YouTubeListAdapter(ArrayList<YouTubeDetails> youTubeDetailsArrayList,View.OnClickListener youTubeItemClickListener){

        this.youTubeDetailsArrayList = youTubeDetailsArrayList;
        this.youTubeItemClickListener = youTubeItemClickListener;
    }


    @Override
    public YouTubeViewHadler onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_video_list,parent,false);


        return new YouTubeViewHadler(view);
    }

    @Override
    public void onBindViewHolder(YouTubeViewHadler holder, int position) {

        if (youTubeDetailsArrayList == null){

            return;
        }

        YouTubeDetails youTubeDetails = youTubeDetailsArrayList.get(position);

        if (youTubeDetails == null){
            return;
        }
       if (holder instanceof YouTubeViewHadler){

           if (TextUtils.isEmpty(youTubeDetails.getTitle())){
               return;
           }

           holder.tvVideo.setText(youTubeDetails.getTitle());
           holder.tvVideo.setTag(position);
           holder.videoImage.setTag(position);
           //holder.tvVideo.setTag(youTubeDetails.getLink());
          // holder.videoImage.setTag(youTubeDetails.getLink());
           if (youTubeItemClickListener != null){
               holder.tvVideo.setOnClickListener(youTubeItemClickListener);
               holder.videoImage.setOnClickListener(youTubeItemClickListener);
           }


       }



    }

    @Override
    public int getItemCount() {
        return youTubeDetailsArrayList.size();
    }

    public class YouTubeViewHadler extends RecyclerView.ViewHolder{

        private final TextView tvVideo;

        private final ImageView videoImage;

        public YouTubeViewHadler(View itemView) {
            super(itemView);

            tvVideo = (TextView) itemView.findViewById(R.id.tvVideo);
            videoImage = (ImageView) itemView.findViewById(R.id.videoImage);

        }
    }


    public void setYouTubeList(ArrayList<YouTubeDetails> youTubeDetailses){


        if (youTubeDetailses != null){

            this.youTubeDetailsArrayList = youTubeDetailses;


        }

        notifyDataSetChanged();
    }
}
