import { TestBed } from '@angular/core/testing';

import { QBankServiceService } from './qbank-service.service';

describe('QBankServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: QBankServiceService = TestBed.get(QBankServiceService);
    expect(service).toBeTruthy();
  });
});
