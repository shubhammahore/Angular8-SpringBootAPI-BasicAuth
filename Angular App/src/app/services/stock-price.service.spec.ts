import { TestBed } from '@angular/core/testing';

import { StockPriceService } from './stock-price.service';

describe('StockPriceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: StockPriceService = TestBed.get(StockPriceService);
    expect(service).toBeTruthy();
  });
});
