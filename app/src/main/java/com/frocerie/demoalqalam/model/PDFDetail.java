
package com.frocerie.demoalqalam.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PDFDetail {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("pdf_path")
    @Expose
    private String pdfPath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPdfPath() {
        return pdfPath;
    }

    public void setPdfPath(String pdfPath) {
        this.pdfPath = pdfPath;
    }

}
