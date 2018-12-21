
package com.frocerie.demoalqalam.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeekListSubModel {

    @SerializedName("details")
    @Expose
    private ArrayList<WeekPlanDetails> details = null;

    public ArrayList<WeekPlanDetails> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<WeekPlanDetails> details) {
        this.details = details;
    }

}
