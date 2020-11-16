package org.ardananjungkusuma.pokelove.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Pokemon implements Parcelable {
    private String name, desc, type1, type2, species, gender, height, weight, abilities;

    public Pokemon(String name, String desc, String type1, String type2, String species, String gender, String height, String weight, String abilities) {
        this.name = name;
        this.desc = desc;
        this.type1 = type1;
        this.type2 = type2;
        this.species = species;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.abilities = abilities;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.desc);
        dest.writeString(this.type1);
        dest.writeString(this.type2);
        dest.writeString(this.species);
        dest.writeString(this.gender);
        dest.writeString(this.height);
        dest.writeString(this.weight);
        dest.writeString(this.abilities);
    }

    protected Pokemon(Parcel in) {
        this.name = in.readString();
        this.desc = in.readString();
        this.type1 = in.readString();
        this.type2 = in.readString();
        this.species = in.readString();
        this.gender = in.readString();
        this.height = in.readString();
        this.weight = in.readString();
        this.abilities = in.readString();
    }

    public static final Parcelable.Creator<Pokemon> CREATOR = new Parcelable.Creator<Pokemon>() {
        @Override
        public Pokemon createFromParcel(Parcel source) {
            return new Pokemon(source);
        }

        @Override
        public Pokemon[] newArray(int size) {
            return new Pokemon[size];
        }
    };

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

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }
}
