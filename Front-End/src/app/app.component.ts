import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { FootballClubFormComponent } from './football-club-form/football-club-form.component';
import { ActivatedRoute, Router } from '@angular/router';


export interface LeagueManagerTableItem {
    id: number;
    clubName: string;
    clubLocation: string;
    wins: number;
    draws: number;
    defeats: number;
    goals: number;
    score: number;
    points: number;
    matches: number;
  }
  
  const ELEMENT_DATA: LeagueManagerTableItem[] = [
    {id: 1, clubName: 'Hydrogen', clubLocation: 'colombo', wins: 4, draws: 6, defeats: 5, goals: 4, score: 6, points: 5, matches: 4},
    {id: 2, clubName: 'Hydrogen', clubLocation: 'colombo', wins: 4, draws: 6, defeats: 5, goals: 4, score: 6, points: 5, matches: 4},
    {id: 3, clubName: 'Hydrogen', clubLocation: 'colombo', wins: 4, draws: 6, defeats: 5, goals: 4, score: 6, points: 5, matches: 4},
    {id: 4, clubName: 'Hydrogen', clubLocation: 'colombo', wins: 4, draws: 6, defeats: 5, goals: 4, score: 6, points: 5, matches: 4},
    {id: 5, clubName: 'Hydrogen', clubLocation: 'colombo', wins: 4, draws: 6, defeats: 5, goals: 4, score: 6, points: 5, matches: 4},
    {id: 6, clubName: 'Hydrogen', clubLocation: 'colombo', wins: 4, draws: 6, defeats: 5, goals: 4, score: 6, points: 5, matches: 4},
    {id: 7, clubName: 'Hydrogen', clubLocation: 'colombo', wins: 4, draws: 6, defeats: 5, goals: 4, score: 6, points: 5, matches: 4},
    {id: 8, clubName: 'Hydrogen', clubLocation: 'colombo', wins: 4, draws: 6, defeats: 5, goals: 4, score: 6, points: 5, matches: 4},
    {id: 9, clubName: 'Hydrogen', clubLocation: 'colombo', wins: 4, draws: 6, defeats: 5, goals: 4, score: 6, points: 5, matches: 4},
    {id: 10, clubName: 'Hydrogen', clubLocation: 'colombo', wins: 4, draws: 6, defeats: 5, goals: 4, score: 6, points: 5, matches: 4},
    {id: 11, clubName: 'Hydrogen', clubLocation: 'colombo', wins: 4, draws: 6, defeats: 5, goals: 4, score: 6, points: 5, matches: 4},
    {id: 12, clubName: 'Hydrogen', clubLocation: 'colombo', wins: 4, draws: 6, defeats: 5, goals: 4, score: 6, points: 5, matches: 4},
  ];

@Component({
  selector: 'app-root', 
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'premeirLeagueManagerw1761079';
}
