import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { footballClubDetails } from 'src/footballClubDetails';
import { matchDetails } from 'src/matchDetails';
import { matchDetailsInterface } from 'src/matchDetailsInterface';

@Injectable({
  providedIn: 'root'
})
export class LeagueManagerService {

  constructor(private http:HttpClient) { }

  public footballClubDetails(): Observable<footballClubDetails[]> {
    return  this.http.get<footballClubDetails[]>("http://localhost:8080/table");
  }

  public matchDetails(): Observable<matchDetailsInterface[]> {
    return  this.http.get<matchDetailsInterface[]>("http://localhost:8080/matchTable");
  }

  public randomMatchDetails(match) {
    return this.http.post("http://localhost:8080/randomMatch",match,{responseType:"text" as "json"});
    alert("ggg");
  }


  public clubInput(sportsClub) {
    return this.http.post("http://localhost:8080/clubs",sportsClub,{responseType:"text" as "json"});
    alert("ggg");
  }

  public deleteClub(clubDelete) {
    return this.http.post("http://localhost:8080/deleteClub",clubDelete,{responseType:"text" as "json"});
    alert("ggg");
  }

  public sortInput(sortingOption) {
    return this.http.post("http://localhost:8080/sortingOption",sortingOption,{responseType:"text" as "json"});
    alert("ggg");
  }

  public matchInput(match) {
    return this.http.post("http://localhost:8080/match",match,{responseType:"text" as "json"});
    alert("ggg");
  }

  
//////
  public dateInput(match) {
    return this.http.post("http://localhost:8080/matchDate",match,{responseType:"text" as "json"});
    alert("ggg");
  }


  public dateMatchDetails(): Observable<matchDetailsInterface[]> {
    return  this.http.get<matchDetailsInterface[]>("http://localhost:8080/dateMatches");
  }


  public pointSortInput(): Observable<footballClubDetails[]> {
    return  this.http.get<footballClubDetails[]>("http://localhost:8080/pointSorting");
  }

  public winsSortInput(): Observable<footballClubDetails[]> {
    return  this.http.get<footballClubDetails[]>("http://localhost:8080/winsSorting");
  }

  public goalsSortInput(): Observable<footballClubDetails[]> {
    return  this.http.get<footballClubDetails[]>("http://localhost:8080/goalsSorting");
  }

  public relegateClubs(): Observable<footballClubDetails[]> {
    return  this.http.get<footballClubDetails[]>("http://localhost:8080/relegateClubs");
  }

}
