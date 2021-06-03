import { ViewChild } from '@angular/core';
import { Component, OnInit, Inject } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { MatTable } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { from } from 'rxjs';
import { matchDetails } from 'src/matchDetails';
import { sportsClubDetails } from 'src/sportsClubDetails';
import { LeagueManagerService } from '../league-manager.service';
import {MatSnackBar} from '@angular/material/snack-bar';
import {MatDialog, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { matchDetailsInterface } from 'src/matchDetailsInterface';

@Component({
  selector: 'app-add-matches-form', 
  templateUrl: './add-matches-form.component.html', 
  styleUrls: ['./add-matches-form.component.css']
})

export class AddMatchesFormComponent implements OnInit {

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  match : matchDetails = new matchDetails("","",0,"",0);
  message:any;
  messageRand: any;
  LeagueManagerService: any;
  closeResult = '';
  matchDate:string = null;
  teamH:string = null;
  teamA:string = null;
  teamHScore:number = null;
  teamAScore:number = null;

  constructor(private service:LeagueManagerService, private _snackBar: MatSnackBar, public dialog: MatDialog){
    
  }


  ionViewDidLoad(){ 
    setTimeout(() => {
        this.openSnackBar(this.message,"Close")
    }, 1500);
  }

  ionViewDidLoadRandMatch(){ 
    setTimeout(() => {
        this.openSnackBar(this.messageRand,"Close")
    }, 1500);
  }


  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action);
  }

  openSnackBarRandMatch(message: string, action: string) {
    this._snackBar.open(message, action);
  }


  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }


  public addMatchNow(){
    
    this.matchDate = "";
    this.teamH = "";
    this.teamA = "";
    this.teamHScore = null;
    this.teamAScore = null;
    this.message = "";
    
    this.matchDate = this.match.dateString;
    console.log(this.matchDate)
    this.teamH = this.match.team1;
    console.log(this.teamH)
    this.teamA = this.match.team2;
    this.teamHScore = this.match.team1Score;
    console.log(this.teamHScore)
    this.teamAScore = this.match.team2Score;
      let resp=this.service.matchInput(this.match)
      resp.subscribe((data)=>this.message=data);
      this.ionViewDidLoad();
      console.log("vada");
      console.log(this.message)

    setTimeout(() => {
      this.match = new matchDetails("","",0,"",0);
    }, 4000);
  }

  public addRandMatchNow() {

    let resp=this.service.randomMatchDetails(this.match)
      resp.subscribe((data)=>this.messageRand=data);

    this.ionViewDidLoadRandMatch();

  }
}




