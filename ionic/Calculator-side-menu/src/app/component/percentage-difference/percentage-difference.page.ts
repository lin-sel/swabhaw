import { Component, OnInit } from '@angular/core';
import { CalculatePercentageService } from 'src/app/service/calculate-percentage.service';

@Component({
  selector: 'app-percentage-difference',
  templateUrl: './percentage-difference.page.html',
  styleUrls: ['./percentage-difference.page.scss'],
})
export class PercentageDifferencePage implements OnInit {

  private output: number;
  private number: any;
  constructor(private calculate: CalculatePercentageService) {
    this.output = null;
    this.initForm();
  }

  ngOnInit() { }

  onClick() {
    if (this.number.number1 == null || this.number.number2 == null) {
      alert("Please Enter Number");
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
