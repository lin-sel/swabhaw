import { Component } from '@angular/core';
import { CalculatorService } from 'src/app/service/mainservice/calculator.service';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page {

  private output: number;
  private number: any;
  constructor(private calculate: CalculatorService) {
    this.output = null;
    this.initForm();
  }

  onClick() {
    if (this.number.number1 == null || this.number.number2 == null) {
      alert("Please Enter Number");
      return;
    }
    this.output = this.calculate.xPercentageOfy(this.number.number1, this.number.number2);
  }

  initForm() {
    this.number = {
      number1: null,
      number2: null
    }
  }


}
