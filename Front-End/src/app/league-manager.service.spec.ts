import { TestBed } from '@angular/core/testing';

import { LeagueManagerService } from './league-manager.service';

describe('LeagueManagerService', () => {
  let service: LeagueManagerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LeagueManagerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
