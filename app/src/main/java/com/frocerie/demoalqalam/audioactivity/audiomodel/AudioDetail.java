
package com.frocerie.demoalqalam.audioactivity.audiomodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AudioDetail {

    @SerializedName("surah_name")
    @Expose
    private String surahName;
    @SerializedName("path")
    @Expose
    private String path;

    public String getSurahName() {
        return surahName;
    }

    public void setSurahName(String surahName) {
        this.surahName = surahName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
