import { Component } from '@angular/core';
import { CalculatorService } from 'src/app/service/mainservice/calculator.service';

@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss']
})
export class Tab2Page {

  private output: any;
  private number: any;
  constructor(private calculate: CalculatorService) {
    this.output = null;
    this.initForm();
  }

  onClick() {
    if (this.number.number1 == null || this.number.number2 == null) {
      alert('Please Enter Number');
      return;
    }
    this.output = this.calculate.calculatePercentage(this.number.number1, this.number.number2) + '%';
  }

  onReset() {
    this.initForm();
  }

  initForm() {
    this.number = {
      number1: null,
      number2: null
    }
    this.output = null;
  }

}
