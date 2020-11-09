package com.example.domain;

public class Movie {
    public int id; 
    public String name;
    public int year;
    public int rating;
    public Movie(String name, int year, int rating) {
        this.name = name;
        this.year = year;
        this.rating = rating;
    }
    public Movie(int id,String name, int year, int rating) {
        this.id=id;
        this.name = name;
        this.year = year;
        this.rating = rating;
    }

}
