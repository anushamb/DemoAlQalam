
package com.frocerie.demoalqalam.audioactivity.audiomodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AudioDetailsModel {

    @SerializedName("details")
    @Expose
    private List<AudioDetail> details = null;

    public List<AudioDetail> getDetails() {
        return details;
    }

    public void setDetails(List<AudioDetail> details) {
        this.details = details;
    }

}
