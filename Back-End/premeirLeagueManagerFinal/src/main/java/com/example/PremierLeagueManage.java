package com.example;

import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PremierLeagueManage implements LeagueManager{

    public static ArrayList<FootballClub> premeirLeague = new ArrayList<FootballClub>();
    private static ArrayList<Match> matches = new ArrayList<Match>();
    private static ArrayList<Match> randMatch = new ArrayList<Match>();
    private static ArrayList<Match> dateMatches = new ArrayList<Match>();
    private static ArrayList<String> clubMatchCheck = new ArrayList<>();


    private static String input = "";


    @Override
    public void createFootballClb() {
        Scanner sc = new Scanner(System.in);

        FootballClub club = new FootballClub();

        if(premeirLeague.size() == 20) {                 // 20 is taken as the maximum number of clubs in the league
            System.out.println("Can't add more clubs to league");
            return;
        }


        String clbName;

        while (true) {                    //loop to check if entered club is already in league list
            System.out.println("Insert club Name: ");
            clbName = sc.nextLine().toUpperCase();
            for (FootballClub teams : premeirLeague) {
                if (teams.getClubName().equals(clbName)) {
                    System.out.println("This club is already in the league");
                    createFootballClb();
                    return;
                }
            }
            break;
        }

            club.setClubName(clbName);
            System.out.println("Insert club location: ");
            String location = sc.nextLine();
            club.setClubLocation(location);


            premeirLeague.add(club);
        System.out.println("CLUB ADDED TO LEAGUE SUCCESSFULLY!");
    }

    @Override
    public void deleteClub() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter club name : ");
        String clbName = sc.nextLine().toUpperCase();
        int arg = 0;
        for(FootballClub club : premeirLeague) {
            if(club.getClubName().equals(clbName)){
                premeirLeague.remove(club);
                System.out.println( club.getClubName() + " was removed from the league");
                arg = 1;
                break;
            }
        }

        if (arg != 1) {
            System.out.println("There was no such club");
        }

    }

    @Override
    public void displayStatistics() {

        for (FootballClub footballClub : premeirLeague) {
            System.out.println("-" + footballClub.getClubName() + "-");
            System.out.println("Number of wins: " + footballClub.getNoOfWins());
            System.out.println("Number of Draws: " + footballClub.getNoOfDraws());
            System.out.println("Number of Defeats: " + footballClub.getNoOfDefeats());
            System.out.println("Number of Goals: " + footballClub.getNoOfGoals());
            System.out.println("Number of Score: " + footballClub.getTotalScore());
            System.out.println("Number of Points: " + footballClub.getTotalPoints());
            System.out.println("Number of Matches: " + footballClub.getNoOfMatches());
        }

    }

    @Override
    public void displayTable() {

        premeirLeague.sort(new pointsComparator());

        for(FootballClub club : premeirLeague) {
            System.out.println(club.getClubName()+" || Points: "+ club.getTotalPoints()+ " | No. of goals: " + club.getNoOfGoals() + " | Goals scored: " + club.getTotalScore());
        }

    }

    @Override
    public void addMatch() {

        Scanner sc = new Scanner(System.in);

        java.util.Date dateFormat;
        Match match = new Match();

        while (true) {                                            /////check date format
            System.out.println("Enter date (mm-dd-yyyy): ");
            String dateLine = sc.nextLine();
            try {
                dateFormat = new SimpleDateFormat("mm-dd-yyyy").parse(dateLine);
            } catch (ParseException ex) {
                System.out.println("Wrong format, Enter as (mm-dd-yyyy)");
                return;
            }

            int[] daysInMonths = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };   // days in  month taken as a list

            String[] keyValue1 = dateLine.split("-");
            int dateS = Integer.parseInt(keyValue1[1]);
            int monthS = Integer.parseInt(keyValue1[0]);
            int yearS = Integer.parseInt(keyValue1[2]);

            if ( monthS <= 12 && !(monthS == 0)){
                if ( dateS <= daysInMonths[monthS] && !(dateS == 0)) {
                    System.out.println(dateS + " " + monthS + "  " + yearS);
                    Date date = new Date();
                    date.setDay(dateS);
                    date.setMonth(monthS);
                    date.setYear(yearS);
                    match.setDate(date);
                    break;
                } else {
                    System.out.println("Invalid date, re-enter");
                }
            } else {
                System.out.println("Invalid month, re-enter");
            }
        }


        FootballClub homeClub = null;
        FootballClub awayClub = null;
        int homeGoals = 0;
        int awayGoals = 0;
        Random random = new Random();

            while (true) {
                boolean arg1 = false;
                boolean arg2 = false;
                System.out.println("Enter HOME CLUB: ");
                String homeClubSc = sc.nextLine();
                System.out.println("Enter AWAY CLUB: ");
                String awayClubSc = sc.nextLine();
                for (FootballClub club: premeirLeague){          //to check if club exist in the league list
                    if (homeClubSc.equals(club.getClubName())) {
                        arg1 = true;
                    }
                    if (awayClubSc.equals(club.getClubName())) {
                        arg2 = true;
                    }
                }
                if (arg1 && arg2) {
                    clubMatchCheck.add(homeClubSc);
                    clubMatchCheck.add(awayClubSc);
                    break;
                } else {
                    if(!arg1) {
                        System.out.println("THE HOME CLUB YOU ENTERED IS NOT IN THE LEAGUE");
                    }
                    if(!arg2) {
                        System.out.println("THE AWAY CLUB YOU ENTERED IS NOT IN THE LEAGUE");
                    }
                }
            }

            for (FootballClub clubs : premeirLeague) {
                if (clubs.getClubName().equals(clubMatchCheck.get(0))) {
                    homeClub = clubs;
                }
                if (clubs.getClubName().equals(clubMatchCheck.get(1))) {
                    awayClub = clubs;
                }
            }

            clubMatchCheck.clear();
            homeGoals = random.nextInt(7);
            awayGoals = random.nextInt(7);

            if (homeGoals > awayGoals) {
                homeClub.setTotalPoints(homeClub.getTotalPoints() + 3);
                homeClub.setNoOfWins(homeClub.getNoOfWins() + 1);
                awayClub.setNoOfDefeats(awayClub.getNoOfDefeats() + 1);
            } else if (homeGoals < awayGoals) {
                awayClub.setTotalPoints(awayClub.getTotalPoints() + 3);
                awayClub.setNoOfWins(awayClub.getNoOfWins() + 1);
                homeClub.setNoOfDefeats(homeClub.getNoOfDefeats() + 1);
            } else {
                homeClub.setTotalPoints(homeClub.getTotalPoints() + 1);
                awayClub.setTotalPoints(awayClub.getTotalPoints() + 1);
                homeClub.setNoOfDraws(homeClub.getNoOfDraws() + 1);
                awayClub.setNoOfDraws(awayClub.getNoOfDraws() + 1);
            }

            match.setTeam1(homeClub.getClubName());
            match.setTeam2(awayClub.getClubName());
            match.setTeam1Score(homeGoals);
            match.setTeam2Score(awayGoals);
            matches.add(match);
            homeClub.setTotalScore(homeClub.getTotalScore() + homeGoals);
            awayClub.setTotalScore(awayClub.getTotalScore() + awayGoals);
            homeClub.setNoOfGoals(homeClub.getNoOfGoals() + awayGoals);
            awayClub.setNoOfGoals(awayClub.getNoOfGoals() + homeGoals);
            homeClub.setNoOfMatches(homeClub.getNoOfMatches() + 1);
            awayClub.setNoOfMatches(awayClub.getNoOfMatches() + 1);

            System.out.println(matches.toString());

    }

    @Override
    public void saveInfo() {

        String fileMatches = "matches.txt";
        String fileLeague = "PremierLeague.txt";
        try {
            ObjectOutputStream objectSaving = new ObjectOutputStream(new FileOutputStream(fileMatches));

            for (Match match : matches) {
                objectSaving.writeObject(match);
            }

            objectSaving.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectOutputStream objectSaving = new ObjectOutputStream(new FileOutputStream(fileLeague));
            for (FootballClub club : premeirLeague) {
                objectSaving.writeObject(club);
            }

            objectSaving.close();
        } catch (IOException e) {
            e.printStackTrace();

         }
    }

    @Override
    public void resumeInfo() throws IOException {

        File fileMatches = new File("matches.txt");
        File fileLeague = new File("matches.txt");
        if (fileMatches.length()!=0) {
            try {
                FileInputStream fileInputSt = new FileInputStream("matches.txt");
                ObjectInputStream objectInputSt = new ObjectInputStream(fileInputSt);

                for (; ; ) {
                    try {
                        matches.add((Match) objectInputSt.readObject());
                    } catch (EOFException e) {
                        break;
                    }
                }

                System.out.println("Previous data has been loaded successfully");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        if (fileLeague.length()!=0) {
            try {
                FileInputStream fileInputSt = new FileInputStream("PremierLeague.txt");
                ObjectInputStream objectInputSt = new ObjectInputStream(fileInputSt);

                for (; ; ) {
                    try {
                        premeirLeague.add((FootballClub) objectInputSt.readObject());
                    } catch (EOFException e) {
                        break;
                    }
                }

                System.out.println("Previous data has been loaded successfully");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }




    @Override
    public List<FootballClub> getPremeirleagueData(){
        for (FootballClub clubs : premeirLeague) {
            System.out.println(clubs.toString());
        }
        return premeirLeague;
    }

    @Override
    public List<Match> getPremeirleagueMatchData(){
        for (Match match : matches) {
            System.out.println(match.toString());
        }

        for (int i = 0; i <( matches.size()-1); i++) {         //sorting by the day
            for (int j = i + 1; j < matches.size(); j++) {
                if (matches.get(i).getDate().getDay() > matches.get(j).getDate().getDay()){
                    Match club = matches.get(i);
                    matches.set(i, matches.get(j));
                    matches.set(j, club);
                }
            }
        }

        for (int i = 0; i <( matches.size()-1); i++) {          // sorting by the month
            for (int j = i + 1; j < matches.size(); j++) {
                if (matches.get(i).getDate().getMonth() > matches.get(j).getDate().getMonth()){
                    Match club = matches.get(i);
                    matches.set(i, matches.get(j));
                    matches.set(j, club);
                }
            }
        }

        for (int i = 0; i <( matches.size()-1); i++) {          //sorting by the year
            for (int j = i + 1; j < matches.size(); j++) {
                if (matches.get(i).getDate().getYear() > matches.get(j).getDate().getYear()){
                    Match club = matches.get(i);
                    matches.set(i, matches.get(j));
                    matches.set(j, club);
                }
            }
        }

        return matches;
    }


    @Override
    public String addClub(FootballClub club){
        String clubName = club.getClubName().toUpperCase();
        String clubLocation = club.getClubLocation().toUpperCase();
        System.out.println(premeirLeague);
        String message = "";
        boolean check = true;

        if ( clubName.equals("")) {
            message = "COMPLETE ALL REQUIRED FIELDS";
            check = false;
        }
        if ( clubLocation.equals("")) {
            message = "COMPLETE ALL REQUIRED FIELDS";
            check = false;
        }

        for (FootballClub leagueClub: premeirLeague){
            if (clubName.equals(leagueClub.getClubName())){
                message = "THIS CLUB ALREADY EXIST";
                check = false;
                break;
            }
        }

        if (check) {
            message = "CLUB ADDED SUCCESSFULLY";
            club.setClubName(clubName);
            club.setClubLocation(clubLocation);
            premeirLeague.add(club);
            saveInfo();
        }
        System.out.println(message);
        return message;
    }

    @Override
    public String addMatch(Match match){

        String messageMatch = "";
        System.out.println(match.getDateString());
        if (match.getDateString() == null ) {
            return "COMPLETE ALL REQUIRED FIELDS";
        } else {

            boolean team1InMatch = false;
            boolean team2InMatch = false;
            for (FootballClub clubsIn : premeirLeague){
                if (match.getTeam1().equals(clubsIn.getClubName())) {
                    team1InMatch = true;
                }
                if (match.getTeam2().equals(clubsIn.getClubName())){
                    team2InMatch = true;
                }
            }

            if (!team1InMatch) {
                return "HOME CLUB YOU ENTERED IS NOT REGISTERED IN THE LEAGUE";
            }

            if (!team2InMatch) {
                return "AWAY CLUB YOU ENTERED IS NOT REGISTERED IN THE LEAGUE";
            }

            if (team1InMatch && team2InMatch) {

                addMatchMethod(match);
                saveInfo();
                return "MATCH ADDED TO THE LEAGUE SUCCESSFULLY!";
            }
        }

        return messageMatch;
    }


    public void addMatchMethod(Match match) {

        Match matchDetail = new Match();
        Date dateObjct = new Date();
        FootballClub footballClub = new FootballClub();

        System.out.println(match.getDateString());


        String[] date = match.getDateString().split("-");
        int day = Integer.parseInt(date[2]);
        int month = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[0]);

        dateObjct.setDay(day);
        dateObjct.setMonth(month);
        dateObjct.setYear(year);

        matchDetail.setDate(dateObjct);

        System.out.println(match.getDateString());
        String matchDate = match.getDateString();
        System.out.println(matchDate);

        clubMatchCheck.add(match.getTeam1());
        clubMatchCheck.add(match.getTeam2());

        System.out.println(clubMatchCheck);

        FootballClub homeClub = null;
        FootballClub awayClub = null;
        int homeGoals = 0;
        int awayGoals = 0;

        for (FootballClub clubs : premeirLeague) {
            System.out.println(clubs.getClubName());
            if (clubs.getClubName().equals(clubMatchCheck.get(0))) {
                homeClub = clubs;
                homeClub.setClubName(clubs.getClubName().toUpperCase());
                homeGoals = match.getTeam1Score();
            }
            if (clubs.getClubName().equals(clubMatchCheck.get(1))) {
                awayClub = clubs;
                awayClub.setClubName(clubs.getClubName().toUpperCase());
                awayGoals = match.getTeam2Score();
            }
        }

        clubMatchCheck.clear();

        if (homeGoals > awayGoals) {
            homeClub.setTotalPoints(homeClub.getTotalPoints() + 3);
            homeClub.setNoOfWins(homeClub.getNoOfWins() + 1);
            awayClub.setNoOfDefeats(awayClub.getNoOfDefeats() + 1);
        } else if (homeGoals < awayGoals) {
            awayClub.setTotalPoints(awayClub.getTotalPoints() + 3);
            awayClub.setNoOfWins(awayClub.getNoOfWins() + 1);
            homeClub.setNoOfDefeats(homeClub.getNoOfDefeats() + 1);
        } else {
            homeClub.setTotalPoints(homeClub.getTotalPoints() + 1);
            awayClub.setTotalPoints(awayClub.getTotalPoints() + 1);
            homeClub.setNoOfDraws(homeClub.getNoOfDraws() + 1);
            awayClub.setNoOfDraws(awayClub.getNoOfDraws() + 1);
        }
        matchDetail.setTeam1(homeClub.getClubName());
        matchDetail.setTeam2(awayClub.getClubName());
        matchDetail.setTeam1Score(homeGoals);
        matchDetail.setTeam2Score(awayGoals);
        matches.add(matchDetail);
        homeClub.setTotalScore(homeClub.getTotalScore() + homeGoals);
        awayClub.setTotalScore(awayClub.getTotalScore() + awayGoals);
        homeClub.setNoOfGoals(homeClub.getNoOfGoals() + awayGoals);
        awayClub.setNoOfGoals(awayClub.getNoOfGoals() + homeGoals);
        homeClub.setNoOfMatches(homeClub.getNoOfMatches() + 1);
        awayClub.setNoOfMatches(awayClub.getNoOfMatches() + 1);
        System.out.println(homeClub.getClubName());
        System.out.println(awayClub.getClubName());

        saveInfo();
    }


    @Override
    public String addRandomMatch(){

        String randMatchMessage = "";
        int integer = 0;
        Date date = new Date();
        Match match = new Match();
        Random random = new Random();
        String clbNameCheck = "";

        for (int i = 0; i < 2; i++) {
            Random randomPick = new Random();
            integer = randomPick.nextInt(premeirLeague.size());
            String clbName = premeirLeague.get(integer).getClubName();
            System.out.println(clbName);
            if (String.valueOf(clbName).equals(clbNameCheck)) {
                i--;
            } else {
                clbNameCheck = String.valueOf(clbName);
                clubMatchCheck.add(clbName);
            }
        }

        FootballClub homeClub = null;
        FootballClub awayClub = null;
        int homeGoals = 0;
        int awayGoals = 0;

        for (FootballClub clubs : premeirLeague) {
            if (clubs.getClubName().equals(clubMatchCheck.get(0))) {
                homeClub = clubs;
                homeClub.setClubName(clubs.getClubName());
            }
            if (clubs.getClubName().equals(clubMatchCheck.get(1))) {
                awayClub = clubs;
                awayClub.setClubName(clubs.getClubName());
            }
        }

        clubMatchCheck.clear();
        homeGoals = random.nextInt(7);
        awayGoals = random.nextInt(7);

            int[] daysInMonths = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
            int[] yearRange = {2015,2016,2017,2018,2019,2020};
            int monthPicker = random.nextInt(11) + 1;
            int yearPicker = random.nextInt(6);
            int dateInMonthRand = random.nextInt(daysInMonths[monthPicker]) + 1;

            int monthS = monthPicker;
            int dateS = random.nextInt(dateInMonthRand);
            int yearS = yearRange[yearPicker];

        date.setDay(dateS);
        date.setMonth(monthS);
        date.setYear(yearS);
        match.setDate(date);

        if (homeGoals > awayGoals) {
            homeClub.setTotalPoints(homeClub.getTotalPoints() + 3);
            homeClub.setNoOfWins(homeClub.getNoOfWins() + 1);
            awayClub.setNoOfDefeats(awayClub.getNoOfDefeats() + 1);
        } else if (homeGoals < awayGoals) {
            awayClub.setTotalPoints(awayClub.getTotalPoints() + 3);
            awayClub.setNoOfWins(awayClub.getNoOfWins() + 1);
            homeClub.setNoOfDefeats(homeClub.getNoOfDefeats() + 1);
        } else {
            homeClub.setTotalPoints(homeClub.getTotalPoints() + 1);
            awayClub.setTotalPoints(awayClub.getTotalPoints() + 1);
            homeClub.setNoOfDraws(homeClub.getNoOfDraws() + 1);
            awayClub.setNoOfDraws(awayClub.getNoOfDraws() + 1);
        }
        match.setTeam1(homeClub.getClubName());
        match.setTeam2(awayClub.getClubName());
        match.setTeam1Score(homeGoals);
        match.setTeam2Score(awayGoals);
        randMatch.clear();
        randMatch.add(match);
        matches.add(match);
        homeClub.setTotalScore(homeClub.getTotalScore() + homeGoals);
        awayClub.setTotalScore(awayClub.getTotalScore() + awayGoals);
        homeClub.setNoOfGoals(homeClub.getNoOfGoals() + awayGoals);
        awayClub.setNoOfGoals(awayClub.getNoOfGoals() + homeGoals);
        homeClub.setNoOfMatches(homeClub.getNoOfMatches() + 1);
        awayClub.setNoOfMatches(awayClub.getNoOfMatches() + 1);
        System.out.println(homeClub.getClubName());
        System.out.println(awayClub.getClubName());

        if (randMatch == null){
            randMatchMessage = "ERROR: NO MATCH ADDED";
        } else {
            randMatchMessage = "DATE: " + randMatch.get(0).getDateString() + ", HOME CLUB: { Name: " + randMatch.get(0).getTeam1() +
                    ", Goals: " + randMatch.get(0).getTeam1Score() + "} , AWAY CLUB: { Name: " + randMatch.get(0).getTeam2() +
                    ", Goals: " + randMatch.get(0).getTeam2Score() + "}";
        }
        System.out.println(randMatch);
        System.out.println(randMatchMessage);
        return randMatchMessage;
    }

    @Override
    public List<FootballClub> pointSorting(){
        System.out.println("points");

        for (int i = 0; i <( premeirLeague.size()-1); i++) {
            for (int j = i + 1; j < premeirLeague.size(); j++) {
                if (premeirLeague.get(i).getTotalPoints() < premeirLeague.get(j).getTotalPoints()){
                    FootballClub club = premeirLeague.get(i);
                    premeirLeague.set(i, premeirLeague.get(j));
                    premeirLeague.set(j, club);
                }
            }
        }
        return premeirLeague;
    }

    @Override
    public List<FootballClub> winsSorting(){

        System.out.println("wins");
        for (int i = 0; i <( premeirLeague.size()-1); i++) {
            for (int j = i + 1; j < premeirLeague.size(); j++) {
                if (premeirLeague.get(i).getNoOfWins() < premeirLeague.get(j).getNoOfWins()){
                    FootballClub club = premeirLeague.get(i);
                    premeirLeague.set(i, premeirLeague.get(j));
                    premeirLeague.set(j, club);
                }
            }
        }

        System.out.println(premeirLeague);
        return premeirLeague;
    }

    @Override
    public List<FootballClub> goalsSorting(){

        System.out.println("goals");

        for (int i = 0; i <( premeirLeague.size()-1); i++) {
            for (int j = i + 1; j < premeirLeague.size(); j++) {
                if (premeirLeague.get(i).getNoOfGoals() < premeirLeague.get(j).getNoOfGoals()){
                    FootballClub club = premeirLeague.get(i);
                    premeirLeague.set(i, premeirLeague.get(j));
                    premeirLeague.set(j, club);
                }
            }
        }

        System.out.println(premeirLeague);
        return premeirLeague;
    }


    @Override
    public Match dateFind(Match match){

        String[] date = match.getDateString().split("-");
        int day = Integer.parseInt(date[2]);
        int month = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[0]);
        System.out.println(year);

        dateMatches.clear();
        for (Match matches : matches) {
            if (month == matches.getDate().getMonth() && day == matches.getDate().getDay()
                    && year == matches.getDate().getYear()) {
                dateMatches.add(matches);
            }
        }
        System.out.println(premeirLeague);
        System.out.println(dateMatches);
        return match;
    }

    @Override
    public List<Match> getMatchDate(){
        for (Match matches : dateMatches) {
            System.out.println(matches.toString());
        }
        return dateMatches;
    }

    @Override
    public String relegateClubs(){

        String message = "";
        for (int i = 0; i <( premeirLeague.size()-1); i++) {
            for (int j = i + 1; j < premeirLeague.size(); j++) {
                if (premeirLeague.get(i).getTotalPoints() > premeirLeague.get(j).getTotalPoints()){
                    FootballClub club = premeirLeague.get(i);
                    premeirLeague.set(i, premeirLeague.get(j));
                    premeirLeague.set(j, club);
                }
            }
        }
        if (premeirLeague.size() > 3){
            for (int i = 0; i <3; i++){
                premeirLeague.remove(0);
            }
        } else {
            message = "CANNOT RELEGATE";
        }

        saveInfo();

        System.out.println(premeirLeague);
        return message;
    }

}
