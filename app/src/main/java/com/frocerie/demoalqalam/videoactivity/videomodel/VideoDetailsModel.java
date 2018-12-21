package com.frocerie.demoalqalam.videoactivity.videomodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by avocet on 24/07/17.
 */

public class VideoDetailsModel {




    @SerializedName("details")
    @Expose
    private List<VideoDetail> details = null;

    public List<VideoDetail> getDetails() {
        return details;
    }

    public void setDetails(List<VideoDetail> details) {
        this.details = details;
    }

}
