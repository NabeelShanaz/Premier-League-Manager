import { CdkTable } from '@angular/cdk/table';
import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatSort } from '@angular/material/sort';
import { MatTable, MatTableDataSource } from '@angular/material/table';
import { footballClubDetails } from 'src/footballClubDetails';
import { matchDetails } from 'src/matchDetails';
import { matchDetailsInterface } from 'src/matchDetailsInterface';
import { LeagueManagerService } from '../league-manager.service';

let ELEMENT_DATA : matchDetails[];

@Component({
  selector: 'app-matches-table',
  templateUrl: './matches-table.component.html',
  styleUrls: ['./matches-table.component.css']
})
export class MatchesTableComponent implements OnInit {
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
 
  displayedColumns = ['dateString', 'team1', 'team1Score', 'team2', 'team2Score'];
  dataSource = new MatTableDataSource<matchDetailsInterface>(ELEMENT_DATA);
  
  match : matchDetails = new matchDetails("","",0,"",0);
  message:any;
  messageRand: any;

  constructor (private service:LeagueManagerService, private _snackBar: MatSnackBar) {
  }

  ngOnInit() { 
    this.getAllDetails()
  }

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  public getAllDetails() {
    let resp=this.service.matchDetails();
    resp.subscribe(report=>this.dataSource.data=report as matchDetailsInterface[]);
    
  }

  public showMatches() {
    let resp=this.service.dateInput(this.match)
    resp.subscribe((data)=>this.message=data);
    console.log("vada");
  }

  public getDateMatch() {
    let resp=this.service.dateMatchDetails();
    setTimeout(() => {
      resp.subscribe(report=>this.dataSource.data=report as matchDetailsInterface[]);
    }, 1500);
  }

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action);
  }

  ionViewDidLoadRandMatch(){ 
    setTimeout(() => {
        this.openSnackBar(this.messageRand,"Close")
    }, 1500);
  }

  public addRandMatchNow() {
    let resp=this.service.randomMatchDetails(this.match)
    resp.subscribe((data)=>this.messageRand=data);
    this.ionViewDidLoadRandMatch();
  }

}
