package org.ardananjungkusuma.pokelove.models;

public class Info {
    private String name, desc;
    private int imageResource;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public Info(String name, String desc, int imageResource) {
        this.name = name;
        this.desc = desc;
        this.imageResource = imageResource;
    }
}
