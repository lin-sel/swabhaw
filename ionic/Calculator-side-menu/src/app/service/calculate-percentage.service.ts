import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CalculatePercentageService {

  constructor() { }

  xPercentageOfy(x: number, y: number): number {
    return (x * y) / 100;
  }

  calculatePercentage(x: number, y: number) {
    return (x / y) * 100;
  }

  percentageDifference(from: number, to: number) {
    let percentage = (1 / from) * 100;
    return -1 * percentage * (from - to);
  }
}
