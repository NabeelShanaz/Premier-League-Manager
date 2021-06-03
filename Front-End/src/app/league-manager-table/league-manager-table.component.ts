import { CdkTable } from '@angular/cdk/table';
import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatSort } from '@angular/material/sort';
import { MatTable, MatTableDataSource } from '@angular/material/table';
// import { table } from 'console';
import { footballClubDetails } from 'src/footballClubDetails';
import { sortingOption } from 'src/sortingOption';
import { sportsClubDetails } from 'src/sportsClubDetails';
import { LeagueManagerService } from '../league-manager.service';
// import { LeagueManagerTableDataSource, LeagueManagerTableItem } from './league-manager-table-datasource';

let ELEMENT_DATA : footballClubDetails[];
// let ELEMENT_DATA_SORT : sortingOption[];

@Component({
  selector: 'app-league-manager-table',
  templateUrl: './league-manager-table.component.html',
  styleUrls: [ './league-manager-table.component.css' , './league-manager-table.scss' ]
})

export class LeagueManagerTableComponent implements OnInit {
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  displayedColumns = [ 'clubName', 'noOfWins', 'noOfDraws', 'noOfDefeats', 'noOfGoals', 'totalScore', 'totalPoints', 'noOfMatches','clubLocation','getdetails'];
  dataSource = new MatTableDataSource <footballClubDetails> (ELEMENT_DATA);
  message: any;

  sportsClub : sportsClubDetails = new sportsClubDetails("",0,0,0,0,0,0,0,"");

  sorting : sortingOption = new sortingOption(0,0,0);

  constructor (private service: LeagueManagerService , private _snackBar: MatSnackBar) {
  }

  ngOnInit() {
    this.getAllDetails()
  }

  ionViewDidLoad(){ 
    setTimeout(() => {
        this.openSnackBar(this.message,"close")
    }, 1000);
  }

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action);
  }

  getRecord(name)
  {
    console.log(name);
    setTimeout(() => {
      let resp=this.service.deleteClub(name)
    resp.subscribe((data)=>this.message=data);
    }, 1500);
    // this.getAllDetails();
  }

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  public getAllDetails() {
    let resp=this.service.footballClubDetails();
    resp.subscribe(report=>this.dataSource.data=report as footballClubDetails[]);
  }

  public sortPointsNow() {
    let resp=this.service.pointSortInput();
    resp.subscribe(report=>this.dataSource.data=report as footballClubDetails[]);
    this.getAllDetails();
  }

  public sortGoalsNow() {
    let resp=this.service.goalsSortInput();
    resp.subscribe(report=>this.dataSource.data=report as footballClubDetails[]);
    this.getAllDetails();
  }

  public sortWinsNow() {
    let resp=this.service.winsSortInput();
    resp.subscribe(report=>this.dataSource.data=report as footballClubDetails[]);
    this.getAllDetails();
  }

  public relegateClubFunction() {
    let resp=this.service.relegateClubs()
    resp.subscribe((data)=>this.message=data);
    this.getAllDetails();
    // this.ionViewDidLoad();
  }

}
