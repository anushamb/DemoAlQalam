package com.frocerie.demoalqalam.audioactivity;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.frocerie.demoalqalam.R;
import com.frocerie.demoalqalam.audioactivity.audiomodel.AudioDetail;

import java.util.ArrayList;

/**
 * Created by avocet on 24/07/17.
 */

public class AudioListAdapter extends RecyclerView.Adapter<AudioListAdapter.AudioViewHolder> {

    public ArrayList<AudioDetail> audioDetailArrayList = new ArrayList<>();

    private View.OnClickListener audioItemClickListener;


    public AudioListAdapter(ArrayList<AudioDetail> audioDetailArrayList,View.OnClickListener    audioItemClickListener){

        this.audioDetailArrayList = audioDetailArrayList;
        this.audioItemClickListener = audioItemClickListener;

    }


    @Override
    public AudioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_audio_list, parent, false);

        return new AudioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AudioViewHolder holder, int position) {

        if (audioDetailArrayList == null){
            return;
        }

        AudioDetail audioDetail = audioDetailArrayList.get(position);

        if (audioDetail == null){
            return;
        }
        if (holder instanceof AudioViewHolder){

            if (TextUtils.isEmpty(audioDetail.getSurahName())){
                return;
            }

            Log.d("testK","Audio22 :" + audioDetail.getSurahName() + "Path:" + audioDetail.getPath());
            holder.tvAudio.setText(audioDetail.getSurahName());
            holder.tvAudio.setTag(position);//audioDetail.getPath());
            //holder.audioMate.setTag(audioDetail.getPath());
            holder.audioMate.setTag(position);

            /*holder.tvAudio.setText(audioDetail.getSurahName());
            holder.tvAudio.setTag(audioDetail.getPath());
            holder.audioMate.setTag(audioDetail.getPath());*/

            if (audioItemClickListener != null){

                holder.tvAudio.setOnClickListener(audioItemClickListener);
                holder.audioMate.setOnClickListener(audioItemClickListener);
            }

        }

    }

    @Override
    public int getItemCount() {
        return audioDetailArrayList.size();
    }

    public class AudioViewHolder extends RecyclerView.ViewHolder{

        private final TextView tvAudio;

        private final ImageView audioMate;

        public AudioViewHolder(View view){

            super(view);

            tvAudio = (TextView) view.findViewById(R.id.tvAudio);
            audioMate = (ImageView) view.findViewById(R.id.audioMate);
        }

    }

    public void setAudioList(ArrayList<AudioDetail> audioDetails){

        if (audioDetails != null){

            this.audioDetailArrayList = audioDetails;

        }

        notifyDataSetChanged();
    }




}
