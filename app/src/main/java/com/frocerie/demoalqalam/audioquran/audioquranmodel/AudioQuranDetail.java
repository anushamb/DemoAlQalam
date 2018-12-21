
package com.frocerie.demoalqalam.audioquran.audioquranmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AudioQuranDetail {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("file_path")
    @Expose
    private String filePath;
    @SerializedName("file_name")
    @Expose
    private String fileName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
