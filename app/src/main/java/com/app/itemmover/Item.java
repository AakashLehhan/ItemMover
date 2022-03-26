package com.app.itemmover;

import android.widget.ImageView;

public class Item {
    private Integer imageID;
    private String imageName;

    public Item(Integer imageID, String imageName) {
        this.imageID = imageID;
        this.imageName = imageName;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }

    public Integer getImageID() {
        return imageID;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageName() {
        return imageName;
    }
}
