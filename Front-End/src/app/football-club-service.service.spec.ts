import { TestBed } from '@angular/core/testing';

import { FootballClubService } from './football-club-service.service';

describe('FootballClubServiceService', () => {
  let service: FootballClubService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FootballClubService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
