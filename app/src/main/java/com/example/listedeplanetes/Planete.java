package com.example.listedeplanetes;

public class Planete {
    private String Name;
    private String Distance;
    private int Image;

    public Planete(String name, String distance, int image) {
        Name = name;
        Distance = distance;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDistance() {
        return Distance;
    }

    public void setDistance(String distance) {
        Distance = distance;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
