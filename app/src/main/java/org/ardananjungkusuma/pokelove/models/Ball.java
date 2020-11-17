package org.ardananjungkusuma.pokelove.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Ball implements Parcelable {
    private String name, catchRateModifier,description, debutGen, additionalEffect, imgUrl;

    public Ball(String name, String catchRateModifier, String description, String debutGen, String additionalEffect, String imgUrl) {
        this.name = name;
        this.catchRateModifier = catchRateModifier;
        this.description = description;
        this.debutGen = debutGen;
        this.additionalEffect = additionalEffect;
        this.imgUrl = imgUrl;
    }

    public String getAdditionalEffect() {
        return additionalEffect;
    }

    public void setAdditionalEffect(String additionalEffect) {
        this.additionalEffect = additionalEffect;
    }

    public String getCatchRateModifier() {
        return catchRateModifier;
    }

    public void setCatchRateModifier(String catchRateModifier) {
        this.catchRateModifier = catchRateModifier;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

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

    public String getDebutGen() {
        return debutGen;
    }

    public void setDebutGen(String debutGen) {
        this.debutGen = debutGen;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.catchRateModifier);
        dest.writeString(this.description);
        dest.writeString(this.debutGen);
        dest.writeString(this.additionalEffect);
        dest.writeString(this.imgUrl);
    }

    protected Ball(Parcel in) {
        this.name = in.readString();
        this.catchRateModifier = in.readString();
        this.description = in.readString();
        this.debutGen = in.readString();
        this.additionalEffect = in.readString();
        this.imgUrl = in.readString();
    }

    public static final Creator<Ball> CREATOR = new Creator<Ball>() {
        @Override
        public Ball createFromParcel(Parcel source) {
            return new Ball(source);
        }

        @Override
        public Ball[] newArray(int size) {
            return new Ball[size];
        }
    };
}
