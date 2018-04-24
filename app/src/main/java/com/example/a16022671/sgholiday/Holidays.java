package com.example.a16022671.sgholiday;

public class Holidays {
    private String name;
    private String date;
    private String category;
    private int image;

    public Holidays(String name, String date, String category,int image) {
        this.name = name;
        this.date = date;
        this.category = category;
        this.image = image;
    }
    public int getImage(){
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }
}
