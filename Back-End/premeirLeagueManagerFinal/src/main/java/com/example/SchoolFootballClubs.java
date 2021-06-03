package com.example;

import com.example.FootballClub;

public class SchoolFootballClubs extends FootballClub {

    private String schoolName;

    public SchoolFootballClubs(String name, String location) {
        super(name, location);
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
