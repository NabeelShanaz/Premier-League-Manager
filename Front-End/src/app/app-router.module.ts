import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { from } from 'rxjs';
import { FootballClubFormComponent } from './football-club-form/football-club-form.component';
import { LeagueManagerTableComponent } from './league-manager-table/league-manager-table.component';
import {CommonModule} from '@angular/common';
import { AddMatchesFormComponent } from './add-matches-form/add-matches-form.component';
import { MatchesTableComponent } from './matches-table/matches-table.component';

const routes: Routes = [
  // {path:"",redirectTo:"register",pathMatch:"full"},
   {path:"register",component : FootballClubFormComponent},
  {path: "table", component: LeagueManagerTableComponent},
  {path: "AddClubForm", component: FootballClubFormComponent},
  {path: "addMatchForm", component: AddMatchesFormComponent},
  {path: "matchTable", component: MatchesTableComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes),CommonModule],
  exports: [RouterModule]
})
export class AppRoutingModule { 

}