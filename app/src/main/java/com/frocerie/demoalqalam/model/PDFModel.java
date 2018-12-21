
package com.frocerie.demoalqalam.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PDFModel {

    @SerializedName("details")
    @Expose
    private List<PDFDetail> PDFDetails = null;

    public List<PDFDetail> getPDFDetails() {
        return PDFDetails;
    }

    public void setPDFDetails(List<PDFDetail> PDFDetails) {
        this.PDFDetails = PDFDetails;
    }

}
