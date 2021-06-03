package com.example.w1761079;

import com.example.PremierLeagueManage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Scanner;

import static com.example.Main.premeirLeagueManage;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws IOException, ClassCastException {
        premeirLeagueManage.resumeInfo();
        SpringApplication.run(DemoApplication.class, args);
        menu();
    }

    public static void menu() throws IOException, ClassCastException {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("           =========  Menu  =========            ");
            System.out.println("Enter 'C' to add a new created football club to the premier league.");
            System.out.println("Enter 'D' to delete (relegate) an existing club from the premier league.");
            System.out.println("Enter 'P' to display the various statistics for a selected club.");
            System.out.println("Enter 'T' to display the Premier League Table");
            System.out.println("Enter 'A' to add a played match details");
            System.out.println("Enter 'S' to save the information that user entered in a file");
            System.out.println("Enter 'R' to continue with the existing information");
            System.out.println("Enter 'G' to open application");
            System.out.println("Enter 'Q' to quite the program");
            String opt = sc.next().toLowerCase();
            switch (opt) {
                case "c":
                    premeirLeagueManage.createFootballClb();
                    break;
                case "d":
                    premeirLeagueManage.deleteClub();
                    break;
                case "p":
                    premeirLeagueManage.displayStatistics();
                    break;
                case "t":
                    premeirLeagueManage.displayTable();
                    break;
                case "a":
                    premeirLeagueManage.addMatch();
                    break;
                case "s":
                    premeirLeagueManage.saveInfo();
                    break;
                case "r":
                    premeirLeagueManage.resumeInfo();
                    break;
                case "g":
                    Runtime rt = Runtime.getRuntime();
                    String url = "http://localhost:4200/AddClubForm";
                    rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
                    break;
                case "q":
                    System.exit(0);
                    break;

            }
        }
    }

}
