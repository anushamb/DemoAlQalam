
package com.frocerie.demoalqalam.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeekDetail {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("class_div")
    @Expose
    private String classDiv;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassDiv() {
        return classDiv;
    }

    public void setClassDiv(String classDiv) {
        this.classDiv = classDiv;
    }

}
