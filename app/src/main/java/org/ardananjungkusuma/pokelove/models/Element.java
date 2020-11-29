package org.ardananjungkusuma.pokelove.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Element implements Parcelable {
    private String name,description, defense, offense, contestProperties, img;

    public Element(String name, String description, String defense, String offense, String contestProperties, String img) {
        this.name = name;
        this.description = description;
        this.defense = defense;
        this.offense = offense;
        this.contestProperties = contestProperties;
        this.img = img;
    }

    public Element() {
    }

    protected Element(Parcel in) {
        name = in.readString();
        description = in.readString();
        defense = in.readString();
        offense = in.readString();
        contestProperties = in.readString();
        img = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(defense);
        dest.writeString(offense);
        dest.writeString(contestProperties);
        dest.writeString(img);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Element> CREATOR = new Creator<Element>() {
        @Override
        public Element createFromParcel(Parcel in) {
            return new Element(in);
        }

        @Override
        public Element[] newArray(int size) {
            return new Element[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDefense() {
        return defense;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }

    public String getOffense() {
        return offense;
    }

    public void setOffense(String offense) {
        this.offense = offense;
    }

    public String getContestProperties() {
        return contestProperties;
    }

    public void setContestProperties(String contestProperties) {
        this.contestProperties = contestProperties;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
