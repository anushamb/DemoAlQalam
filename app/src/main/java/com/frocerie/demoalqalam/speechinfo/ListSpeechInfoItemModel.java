package com.frocerie.demoalqalam.speechinfo;

/**
 * Created by avocet on 12/06/17.
 */

public class ListSpeechInfoItemModel {

    private  String head;
    private  String desc;
    private  String imageUrl;

   // String uri = "https://alqalamtrust.com/image/speech_info/app_al_qalam-211.jpg ";


  public   ListSpeechInfoItemModel(String head,String desc,String imageUrl){

        this.head = head;
      this.desc = desc;
      this.imageUrl = imageUrl;



    }




    public String getHead() {

        System.out.println(head);
        return head;
    }

    public String getDesc() {
        return desc;
    }

    public String getImageUrl() {

        String img = imageUrl.replace("https","http");

 return img;
       // return imageUrl;
    }
}
