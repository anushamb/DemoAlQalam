
package com.frocerie.demoalqalam.weekimage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeekImageDetail {

    @SerializedName("img")
    @Expose
    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
