package com.frocerie.demoalqalam.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.frocerie.demoalqalam.R;
import com.frocerie.demoalqalam.model.WeekPlanDetails;

import java.util.ArrayList;

/**
 * Created by avocet on 05/07/17.
 */

public class WeekListAdapter extends RecyclerView.Adapter<WeekListAdapter.WeekViewHolder> {

    private ArrayList<WeekPlanDetails> weekArrayList = new ArrayList<>();
    private View.OnClickListener weekItemClickListener;

    public WeekListAdapter(ArrayList<WeekPlanDetails> weekList, View.OnClickListener onClickListener){

        this.weekArrayList=weekList;
        this.weekItemClickListener=onClickListener;

    }


    @Override
    public WeekListAdapter.WeekViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_week_item, parent, false);
        return new WeekViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeekViewHolder holder, int position) {
        if (weekArrayList==null){
            return;
        }

        WeekPlanDetails weekPlanDetails=weekArrayList.get(position);

        if (weekPlanDetails==null){
            return;
        }

        if (holder instanceof WeekViewHolder) {

            if (TextUtils.isEmpty(weekPlanDetails.getClassDiv())){
                return;
            }
            holder.tvWeek.setText(weekPlanDetails.getClassDiv());
            holder.tvWeek.setTag(weekPlanDetails.getClassDiv());
            //holder.tvWeek.setTag(weekPlanDetails.getId());
            if (weekItemClickListener!=null) {
                holder.tvWeek.setOnClickListener(weekItemClickListener);
            }
        }
    }


    @Override
    public int getItemCount() {
        return weekArrayList.size();
    }


    class WeekViewHolder extends RecyclerView.ViewHolder {


        private final TextView tvWeek;

        public WeekViewHolder(View itemView) {
            super(itemView);

            tvWeek = (TextView) itemView.findViewById(R.id.tvWeek);


        }
    }

    public void setWeeKList(ArrayList<WeekPlanDetails> weekPlanDetails){
        if (weekPlanDetails!=null){
            this.weekArrayList=weekPlanDetails;
        }
        this.notifyDataSetChanged();
    }
}
