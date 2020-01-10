import { TestBed } from '@angular/core/testing';

import { CalculatePercentageService } from './calculate-percentage.service';

describe('CalculatePercentageService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CalculatePercentageService = TestBed.get(CalculatePercentageService);
    expect(service).toBeTruthy();
  });
});
