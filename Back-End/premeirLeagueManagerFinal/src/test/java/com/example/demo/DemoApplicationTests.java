package com.example.demo;

import com.example.Date;
import com.example.FootballClub;
import com.example.Match;
import com.example.PremierLeagueManage;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;


class DemoApplicationTests {
    PremierLeagueManage premierLeague = new PremierLeagueManage();
    FootballClub football = new FootballClub();
    Match match = new Match();

    @Test
    void addClubTestOnlyName() {
        football.setClubName("testClub");
        football.setClubLocation("");
        Assert.assertEquals("COMPLETE ALL REQUIRED FIELDS",premierLeague.addClub(football));
    }

    @Test
    void addClubTestOnlyLocation() {
        football.setClubName("");
        football.setClubLocation("COLOMBO");
        Assert.assertEquals("COMPLETE ALL REQUIRED FIELDS",premierLeague.addClub(football));
    }



    @Test
    void leagueTableTest(){
        List<FootballClub> tempCheck = new ArrayList<>();
        tempCheck.add(new FootballClub("REALMADRID", "MADRID", 8, 4, 5, 6, 7, 8, 5));
        premierLeague.addClub(new FootballClub("REALMADRID", "MADRID",0, 0, 0, 0, 0, 0, 0));
        Assert.assertEquals(tempCheck,premierLeague.getPremeirleagueData());
    }



}
