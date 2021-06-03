package com.example;

import com.example.FootballClub;

import java.util.Comparator;

class pointsComparator implements Comparator<FootballClub> {

    public int compare(FootballClub num1, FootballClub num2) {

        if(num1.getTotalPoints() > num2.getTotalPoints()){
            return -1;
        }
        else {
            if (num1.getTotalPoints() < num2.getTotalPoints()){
                return 1;
            }
            else {

                int goalDiff1 = num1.getTotalScore() - num1.getNoOfGoals();
                int goalDiff2 = num2.getTotalScore() - num2.getNoOfGoals();

                if (goalDiff1 > goalDiff2){
                    return -1;
                }
                else if (goalDiff1 < goalDiff2) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
        }
    }
}
