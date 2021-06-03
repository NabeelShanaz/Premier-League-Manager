package com.example.w1761079;

import com.example.FootballClub;
import com.example.PremierLeagueManage;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PLMapping {
    static List<FootballClub> list = new ArrayList<>();
    static  List<PremierLeagueManage> premeirLeagueManages = new ArrayList<>();

//    static {
//        list.add(new FootballClub("ColomboKing","colombo",1,1,1,1,1,1,1));
//        list.add(new FootballClub("ColomboKing","colombo",1,1,1,1,1,1,1));
//        list.add(new FootballClub("ColomboKing","colombo",1,1,1,1,1,1,1));
//        list.add(new FootballClub("ColomboKing","colombo",1,1,1,1,1,1,1));
//        list.add(new FootballClub("ColomboKing","colombo",1,1,1,1,1,1,1));
//        list.add(new FootballClub("ColomboKing","colombo",1,1,1,1,1,1,1));
//    }

    public List<FootballClub> getPremeirleagueData(){
        return this.list;
    }
}

