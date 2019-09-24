import { TestBed } from '@angular/core/testing';

import { IposService } from './ipos.service';

describe('IposService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: IposService = TestBed.get(IposService);
    expect(service).toBeTruthy();
  });
});
