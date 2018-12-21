package com.frocerie.demoalqalam.model;

/**
 * Created by avocet on 28/06/17.
 */

public class ImageModel {

    private String imageUrl;

    public ImageModel(String imageUrl) {

        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {

        String image = imageUrl;

        image = image.replace("https","http");

        return image;
    }
}
