import { Component } from '@angular/core';
import { CalculatorService } from 'src/app/service/mainservice/calculator.service';

@Component({
  selector: 'app-tab3',
  templateUrl: 'tab3.page.html',
  styleUrls: ['tab3.page.scss']
})
export class Tab3Page {

  private output: number;
  private number: any;
  constructor(private calculate: CalculatorService) {
    this.output = null;
    this.initForm();
  }

  onClick() {
    if (!this.number.number1 || !this.number.number2) {
      alert("Please enter Number");
      return;
    }
    this.output = this.calculate.percentageDifference(this.number.number1, this.number.number2);
  }

  initForm() {
    this.number = {
      number1: null,
      number2: null
    }
  }

}
