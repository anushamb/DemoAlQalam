
package com.frocerie.demoalqalam.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeeklyListModel {

    @SerializedName("details")
    @Expose
    private List<WeekDetail> weekDetails = null;

    public List<WeekDetail> getWeekDetails() {
        return weekDetails;
    }

    public void setWeekDetails(List<WeekDetail> weekDetails) {
        this.weekDetails = weekDetails;
    }

}
