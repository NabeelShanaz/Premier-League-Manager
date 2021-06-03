package com.example;

import com.example.SportsClub;

import java.io.Serializable;

public class FootballClub extends SportsClub implements Serializable {

    private int noOfWins;
    private int noOfDraws;
    private int noOfDefeats;
    private int noOfGoals;
    private int totalScore;
    private int totalPoints;
    private int noOfMatches;

    public FootballClub (String name, String location ) {
        super(name,location);
    }

    public FootballClub() {

    }

    public FootballClub(String name, String location, int noOfWins, int noOfDraws, int noOfDefeats, int noOfGoals, int totalScore, int totalPoints, int noOfMatches) {
        super(name, location);
        this.noOfWins = noOfWins;
        this.noOfDraws = noOfDraws;
        this.noOfDefeats = noOfDefeats;
        this.noOfGoals = noOfGoals;
        this.totalScore = totalScore;
        this.totalPoints = totalPoints;
        this.noOfMatches = noOfMatches;
    }
    public int getNoOfWins() {
        return noOfWins;
    }

    public void setNoOfWins(int noOfWins) {
        this.noOfWins = noOfWins;
    }

    public int getNoOfDraws() {
        return noOfDraws;
    }

    public void setNoOfDraws(int noOfDraws) {
        this.noOfDraws = noOfDraws;
    }

    public int getNoOfDefeats() {
        return noOfDefeats;
    }

    public void setNoOfDefeats(int noOfDefeats) {
        this.noOfDefeats = noOfDefeats;
    }

    public int getNoOfGoals() {
        return noOfGoals;
    }

    public void setNoOfGoals(int noOfGoals) {
        this.noOfGoals = noOfGoals;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore =  totalScore;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getNoOfMatches() {
        return noOfMatches;
    }

    public void setNoOfMatches(int noOfMatches) {
        this.noOfMatches = noOfMatches;
    }

}
