
package com.frocerie.demoalqalam.gall_youtube;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class YouTubeDetailsModel {

    @SerializedName("details")
    @Expose
    private List<YouTubeDetails> details = null;

    public List<YouTubeDetails> getDetails() {
        return details;
    }

    public void setDetails(List<YouTubeDetails> details) {
        this.details = details;
    }

}
