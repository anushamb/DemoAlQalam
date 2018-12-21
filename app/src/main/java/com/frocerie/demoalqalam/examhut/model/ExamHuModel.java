
package com.frocerie.demoalqalam.examhut.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExamHuModel {

    @SerializedName("details")
    @Expose
    private List<ExamHutDetail> details = null;

    public List<ExamHutDetail> getDetails() {
        return details;
    }

    public void setDetails(List<ExamHutDetail> details) {
        this.details = details;
    }

}
