package com.example;

import java.io.IOException;
import java.util.List;

public interface LeagueManager{

    void createFootballClb();
    void deleteClub();
    void displayStatistics();
    void displayTable();
    void addMatch();
    void saveInfo();
    void resumeInfo() throws IOException;

    List<FootballClub> getPremeirleagueData();

    List<Match> getPremeirleagueMatchData();

    String addClub(FootballClub club);

    String addMatch(Match match);

    String addRandomMatch();

    List<FootballClub> pointSorting();

    List<FootballClub> winsSorting();

    List<FootballClub> goalsSorting();

    Match dateFind(Match match);

    List<Match> getMatchDate();

    String relegateClubs();

}
