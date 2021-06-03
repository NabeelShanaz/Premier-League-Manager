package com.example;

import com.example.FootballClub;

public class UniversityFootballClub extends FootballClub {

    private String uniName;

    public UniversityFootballClub(String name, String location) {
        super(name, location);
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }
}
