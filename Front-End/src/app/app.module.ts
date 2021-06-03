import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LeagueManagerTableComponent } from './league-manager-table/league-manager-table.component';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { FootballClubFormComponent } from './football-club-form/football-club-form.component';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { MatCardModule } from '@angular/material/card';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { AddMatchesFormComponent } from './add-matches-form/add-matches-form.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LeagueManagerService } from './league-manager.service';
import { AppRoutingModule } from './app-router.module';
import { MatchesTableComponent } from './matches-table/matches-table.component';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { MatDialog } from '@angular/material/dialog/dialog';
import { MatDialogModule } from '@angular/material/dialog';


@NgModule({
  declarations: [
    AppComponent,
    LeagueManagerTableComponent,
    FootballClubFormComponent,
    HomeComponent,
    FootballClubFormComponent,
    AddMatchesFormComponent,
    MatchesTableComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatInputModule,
    MatButtonModule,
    MatSelectModule,
    MatRadioModule,
    MatCardModule,
    ReactiveFormsModule,
    HttpClientModule,
    LayoutModule,
    MatToolbarModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    FormsModule,
    NgbModule,
    AppRoutingModule,
    MatSnackBarModule,
    MatDialogModule,
    AppRoutingModule
  ],
  providers: [LeagueManagerService],
  bootstrap: [AppComponent ]
})
export class AppModule { }
