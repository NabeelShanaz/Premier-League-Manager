import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { sportsClubDetails } from 'src/sportsClubDetails';
import { LeagueManagerService } from '../league-manager.service';
import {MatSnackBar} from '@angular/material/snack-bar';


@Component({
  selector: 'app-football-club-form',
  templateUrl: './football-club-form.component.html',
  styleUrls: ['./football-club-form.component.css']
})
export class FootballClubFormComponent implements OnInit {

  sportsClub : sportsClubDetails = new sportsClubDetails("",0,0,0,0,0,0,0,"");
  message:any;
  LeagueManagerService: any;
  closeResult = '';
  txtValue:string = null;
  clbLocation: string;
  clbName: string;


  constructor(private service:LeagueManagerService, private _snackBar: MatSnackBar){

  }

  ionViewDidLoad(){ 
    setTimeout(() => {
        this.openSnackBar(this.message,"close")
    }, 1000);
  }


  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action);
  }


  ngOnInit(){

  }

  public addClubNow(){
    
    this.clbName = "";
    this.clbLocation = "";
    this.clbName = this.sportsClub.clubName;
    this.clbLocation = this.sportsClub.clubLocation;
    if((this.clbName == null ) || (this.clbLocation == null)){
      this.message="COMPLETE ALL REQUIRED FIELDS";
    } else {
      let resp=this.service.clubInput(this.sportsClub)
      resp.subscribe((data)=>this.message=data);
      console.log("vada");
    }

    this.ionViewDidLoad();
    console.log(this.message);
    this.sportsClub = new sportsClubDetails("",0,0,0,0,0,0,0,"");
  }
}
