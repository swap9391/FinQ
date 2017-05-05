package com.exa.finq.model;

import android.graphics.Bitmap;

/**
 * Created by root on 5/5/17.
 */

public class ImageItem {
    private Integer image;
    private String title;

    public ImageItem(Integer image, String title) {
        super();
        this.image = image;
        this.title = title;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}