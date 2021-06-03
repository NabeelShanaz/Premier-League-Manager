package com.example;
import java.io.Serializable;

public class Match implements Serializable {

    private String team1;
    private String team2;
    private int team1Score;
    private int team2Score;
    private Date date;
    private String  dateString;

    public Match() {

    }

    public int getTeam1Score() {
        return team1Score;
    }

    public void setTeam1Score(int team1Score) {
        this.team1Score = team1Score;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }


    public int getTeam2Score() {
        return team2Score;
    }

    public void setTeam2Score(int team2Score) {
        this.team2Score = team2Score;
    }

    public Date getDate() {
        return date;
    }

    public void setDateString(int month, int day, int year) {
        this.dateString = month+"-"+day+"-"+year;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDate(Date date) {
        setDateString(date.getMonth(),date.getDay(),date.getYear());
        this.date = date;
    }

}

