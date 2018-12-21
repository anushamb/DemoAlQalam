
package com.frocerie.demoalqalam.audioquran.audioquranmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AudioQuranModel {

    @SerializedName("details")
    @Expose
    private List<AudioQuranDetail> details = null;

    public List<AudioQuranDetail> getDetails() {
        return details;
    }

    public void setDetails(List<AudioQuranDetail> details) {
        this.details = details;
    }

}
