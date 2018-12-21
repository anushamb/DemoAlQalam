package com.frocerie.demoalqalam.noticeboard;

/**
 * Created by avocet on 22/06/17.
 */

public class ListItem {


    private  String head;
    private String desc;

    private  String date;

    //private  String imageUrl;


    public ListItem(String head, String date,String desc) {
        this.head = head;
        this.desc = desc;
        this.date = date;
        //this.imageUrl = imageUrl;
    }


    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }


   // public String getImageUrl() {
       // return imageUrl;
    //}


    public String getDate() {
        return date;
    }
}
