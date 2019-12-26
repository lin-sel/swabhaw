import { Injectable } from '@angular/core';
import { LogService } from './log.service';

@Injectable({
  providedIn: 'root'
})
export class MathService {

  constructor(private _log: LogService) { }

  add(num1: number, num2: number) {
    this._log.log(num1 + num2);
  }

  multiply(num1: number, num2: number) {
    this._log.log(num1 * num2);
  }

  substract(num1: number, num2: number) {
    this._log.log(num1 - num2);
  }

  divide(num1: number, num2: number) {
    this._log.log(num1 / num2);
  }
}
