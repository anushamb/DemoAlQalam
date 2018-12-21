
package com.frocerie.demoalqalam.weekimage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeekImageModel {

    @SerializedName("details")
    @Expose
    private List<WeekImageDetail> details = null;

    public List<WeekImageDetail> getDetails() {
        return details;
    }

    public void setDetails(List<WeekImageDetail> details) {
        this.details = details;
    }

}
