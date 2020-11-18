package org.ardananjungkusuma.pokelove.models;

public class SnorlaxGame {
    private int tap,img;
    private String status;

    public SnorlaxGame(int tap, int img, String status) {
        this.tap = tap;
        this.img = img;
        this.status = status;
    }

    public int getTap() {
        return tap;
    }

    public void setTap(int tap) {
        this.tap = tap;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
