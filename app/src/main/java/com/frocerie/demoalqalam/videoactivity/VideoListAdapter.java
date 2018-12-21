package com.frocerie.demoalqalam.videoactivity;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.frocerie.demoalqalam.R;
import com.frocerie.demoalqalam.videoactivity.videomodel.VideoDetail;

import java.util.ArrayList;

/**
 * Created by avocet on 24/07/17.
 */

public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.MyViewHandler> {

    public ArrayList<VideoDetail> videoDetailArrayList = new ArrayList<>();
    private View.OnClickListener videoItemClickListener;


    public VideoListAdapter(ArrayList<VideoDetail> videoDetailArrayList, View.OnClickListener videoItemClickListener) {
        this.videoDetailArrayList = videoDetailArrayList;
        this.videoItemClickListener = videoItemClickListener;


    }

    @Override
    public MyViewHandler onCreateViewHolder (ViewGroup parent, int viewType){


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_video_list, parent, false);


        return new MyViewHandler(view);
    }

    @Override
    public void onBindViewHolder (MyViewHandler holder,int position){

        if (videoDetailArrayList == null) {
            return;
        }
        VideoDetail videoDetail = videoDetailArrayList.get(position);

        if (videoDetail == null) {
            return;
        }

        if (holder instanceof MyViewHandler) {

            if (TextUtils.isEmpty(videoDetail.getFileName())) {
                return;
            }

            holder.tvVideo.setText(videoDetail.getFileName());
            holder.tvVideo.setTag(position);
            holder.videoImage.setTag(position);
            //holder.tvVideo.setTag(videoDetail.getFilePath());
            //holder.videoImage.setTag(videoDetail.getFilePath());
            if (videoItemClickListener != null) {
                holder.tvVideo.setOnClickListener(videoItemClickListener);
                holder.videoImage.setOnClickListener(videoItemClickListener);
            }
        }

    }


    @Override
    public int getItemCount() {
        return videoDetailArrayList.size();
    }

    public class MyViewHandler extends RecyclerView.ViewHolder {

        private final TextView tvVideo;

        private final ImageView videoImage;


        public MyViewHandler(View itemView) {
            super(itemView);

            tvVideo = (TextView) itemView.findViewById(R.id.tvVideo);

            videoImage = (ImageView) itemView.findViewById(R.id.videoImage);

        }
    }


    public void setVideoList(ArrayList<VideoDetail> videoDetails) {

        if (videoDetails != null) {
            this.videoDetailArrayList = videoDetails;
        }

        notifyDataSetChanged();
    }

}
