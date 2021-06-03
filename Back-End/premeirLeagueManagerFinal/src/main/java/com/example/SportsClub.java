package com.example;

import java.io.Serializable;

public abstract class SportsClub implements Serializable {
    private String clubName;
    private String clbLocation;

    public SportsClub(String name, String location) {
        clubName = name;
        clbLocation = location;
    }

    public SportsClub() {

    }

    public String getClubName() {
        return clubName;
    }

    public FootballClub setClubName(String clubName) {
        this.clubName = clubName;
        return null;
    }

    public String getClubLocation() {
        return clbLocation;
    }

    public FootballClub setClubLocation(String clbLocation) {
        this.clbLocation = clbLocation;
        return null;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SportsClub)) return false;
        SportsClub that = (SportsClub) object;
        return getClubName().equals(that.getClubName()) &&
                getClubLocation().equals(that.getClubLocation());
    }

}
