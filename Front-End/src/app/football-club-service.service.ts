import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs';
import { sportsClubDetails } from 'src/sportsClubDetails';
import { footballClubDetails } from 'src/footballClubDetails';

@Injectable({ providedIn : "root" })
export class FootballClubService {

  constructor( private http:HttpClient ) {

  }

}
