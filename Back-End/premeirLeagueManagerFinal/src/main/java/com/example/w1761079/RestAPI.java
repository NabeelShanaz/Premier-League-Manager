package com.example.w1761079;

import com.example.FootballClub;
import com.example.Match;
import com.example.PremierLeagueManage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
public class RestAPI {
    private PLMapping plmapp = new PLMapping();
    public static PremierLeagueManage plm = new PremierLeagueManage();


    @GetMapping("/table")
    public List<FootballClub> getRequest(){
        return plm.getPremeirleagueData();
    }

    @GetMapping("/matchTable")
    public List<Match> getMatchRequest(){
        return plm.getPremeirleagueMatchData();
    }

    @PostMapping("/clubs")
    public String addClub(@RequestBody FootballClub club){
        plm.getPremeirleagueData();
        return plm.addClub(club);
    }

    @PostMapping("/deleteClub")
    public String deleteClub(@RequestBody String clubNameDelete){

        String deleteMessage = "";
        for(FootballClub club : plm.getPremeirleagueData()) {
            if(club.getClubName().equals(clubNameDelete)){
                plm.getPremeirleagueData().remove(club);
                System.out.println( club.getClubName() + " was removed from the league");
                deleteMessage = clubNameDelete + " WAS DELETED FROM THE LEAGUE CLUBS";
                break;
            }
        }
        return deleteMessage;
    }


    @PostMapping("/match")
    public String addMatch(@RequestBody Match match){

        return plm.addMatch(match);
    }

    @PostMapping("/randomMatch")
    public String addRandomMatch(@RequestBody Match match) {
        return plm.addRandomMatch();
    }


    @GetMapping("/pointSorting")
    public List<FootballClub> pointSorting(){
        plm.pointSorting();
        return plm.pointSorting();
    }

    @GetMapping("/winsSorting")
    public List<FootballClub> winsSorting(){
        plm.winsSorting();
        return plm.winsSorting();
    }

    @GetMapping("/goalsSorting")
    public List<FootballClub> goalsSorting(){
        plm.goalsSorting();
        return plm.goalsSorting();
    }

    /////////////////////////date
    @GetMapping("/dateMatches")
    public List<Match> getMatchDate(){
        Match match = new Match();
        System.out.println("getDate");
        System.out.println(match.getDateString());
        System.out.println(match.getDate());
        return plm.getMatchDate();
    }

    @PostMapping("/matchDate")
    public Match dateFind(@RequestBody Match match){
        plm.dateFind(match);
        plm.displayStatistics();
        return match;
    }

    @GetMapping("/relegateClubs")
    public String relegateClubs(){
        return plm.relegateClubs();
    }


}
