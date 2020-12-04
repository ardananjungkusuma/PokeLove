package org.ardananjungkusuma.pokelove.models;

import java.util.List;

public class Pokemon {
    private int id,candy_count;
    private String num, name,img,height,weight,candy,egg,spawn_time;
    private double spawn_chance;
    private double avg_spawns;
    private List<String> type;
    private List<String> weaknesses;
    private List<Double> multipliers;
    private List<Evolution> next_evolution;
    private List<Evolution> prev_evolution;


    public Pokemon() {
    }

    public Pokemon(int id, int candy_count, String num, String name, String img, String height, String weight, String candy, String egg, String spawn_time, double spawn_chance, double avg_spawns, List<String> type, List<String> weaknesses, List<Double> multipliers, List<Evolution> next_evolution, List<Evolution> prev_evolution) {
        this.id = id;
        this.candy_count = candy_count;
        this.num = num;
        this.name = name;
        this.img = img;
        this.height = height;
        this.weight = weight;
        this.candy = candy;
        this.egg = egg;
        this.spawn_time = spawn_time;
        this.spawn_chance = spawn_chance;
        this.avg_spawns = avg_spawns;
        this.type = type;
        this.weaknesses = weaknesses;
        this.multipliers = multipliers;
        this.next_evolution = next_evolution;
        this.prev_evolution = prev_evolution;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCandy_count() {
        return candy_count;
    }

    public void setCandy_count(int candy_count) {
        this.candy_count = candy_count;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public String getCandy() {
        return candy;
    }

    public void setCandy(String candy) {
        this.candy = candy;
    }

    public String getEgg() {
        return egg;
    }

    public void setEgg(String egg) {
        this.egg = egg;
    }

    public String getSpawn_time() {
        return spawn_time;
    }

    public void setSpawn_time(String spawn_time) {
        this.spawn_time = spawn_time;
    }

    public double getSpawn_chance() {
        return spawn_chance;
    }

    public void setSpawn_chance(double spawn_chance) {
        this.spawn_chance = spawn_chance;
    }

    public double getAvg_spawns() {
        return avg_spawns;
    }

    public void setAvg_spawns(double avg_spawns) {
        this.avg_spawns = avg_spawns;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public List<String> getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(List<String> weaknesses) {
        this.weaknesses = weaknesses;
    }

    public List<Double> getMultipliers() {
        return multipliers;
    }

    public void setMultipliers(List<Double> multipliers) {
        this.multipliers = multipliers;
    }

    public List<Evolution> getNext_evolution() {
        return next_evolution;
    }

    public void setNext_evolution(List<Evolution> next_evolution) {
        this.next_evolution = next_evolution;
    }

    public List<Evolution> getPrev_evolution() {
        return prev_evolution;
    }

    public void setPrev_evolution(List<Evolution> prev_evolution) {
        this.prev_evolution = prev_evolution;
    }
}
