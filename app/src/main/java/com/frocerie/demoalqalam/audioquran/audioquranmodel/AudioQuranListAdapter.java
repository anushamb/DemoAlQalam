package com.frocerie.demoalqalam.audioquran.audioquranmodel;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.frocerie.demoalqalam.R;

import java.util.ArrayList;

/**
 * Created by avocet on 24/07/17.
 */

public class AudioQuranListAdapter  extends RecyclerView.Adapter<AudioQuranListAdapter.AudioQuranViewHandler>{


    public ArrayList<AudioQuranDetail> audioQuranDetailArrayList = new ArrayList<>();

    private View.OnClickListener audioItemClickListener;


    public AudioQuranListAdapter(ArrayList<AudioQuranDetail> audioQuranDetailArrayList,View.OnClickListener audioItemClickListener){

        this.audioQuranDetailArrayList = audioQuranDetailArrayList;
        this.audioItemClickListener = audioItemClickListener;
    }

    @Override
    public AudioQuranViewHandler onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_audio_list,parent,false);

        return new AudioQuranViewHandler(v) ;
    }

    @Override
    public void onBindViewHolder(AudioQuranViewHandler holder, int position) {
       if (audioQuranDetailArrayList == null){
           return;
       }

       AudioQuranDetail audioQuranDetail = audioQuranDetailArrayList.get(position);

        if (audioQuranDetail == null){
            return;
        }
        if (holder instanceof  AudioQuranViewHandler){

            if (TextUtils.isEmpty(audioQuranDetail.getFileName())){
                return;
            }

            Log.d("testK","Audio22 :"+audioQuranDetail.getFileName() + "Path:" + audioQuranDetail.getFilePath());
            holder.tvAudioQuran.setText(audioQuranDetail.getFileName());
            holder.tvAudioQuran.setTag(position);//audioQuranDetail.getPath()
            holder.audioMate.setTag(position);




           /* holder.tvAudioQuran.setText(audioQuranDetail.getFileName());
            //holder.tvAudioQuran.setTag(audioQuranDetail.getFileName());
            holder.tvAudioQuran.setTag(audioQuranDetail.getFilePath());*/
            if (audioItemClickListener != null){

                holder.tvAudioQuran.setOnClickListener(audioItemClickListener);
                holder.audioMate.setOnClickListener(audioItemClickListener);
            }
        }
    }

    @Override
    public int getItemCount() {
        return audioQuranDetailArrayList.size();
    }

    public class AudioQuranViewHandler extends RecyclerView.ViewHolder{

        private final TextView tvAudioQuran;

        private final ImageView audioMate;



        public AudioQuranViewHandler(View itemView) {
            super(itemView);

            tvAudioQuran = (TextView) itemView.findViewById(R.id.tvAudio);

            audioMate = (ImageView) itemView.findViewById(R.id.audioMate);

        }
    }

    public void setAudioQuranList(ArrayList<AudioQuranDetail> audioQuranDetailArrayList){

        if (audioQuranDetailArrayList != null){
            this.audioQuranDetailArrayList = audioQuranDetailArrayList;
        }

        notifyDataSetChanged();
    }



}
