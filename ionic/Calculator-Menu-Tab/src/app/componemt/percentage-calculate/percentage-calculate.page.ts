import { Component, OnInit } from '@angular/core';
import { CalculateService } from 'src/app/service/mainservice/calculate.service';

@Component({
  selector: 'app-percentage-calculate',
  templateUrl: './percentage-calculate.page.html',
  styleUrls: ['./percentage-calculate.page.scss'],
})
export class PercentageCalculatePage implements OnInit {

  private output: any;
  private number: any;
  constructor(private _ser: CalculateService) {
    this.initForm();
  }

  ngOnInit() { }

  onClick() {
    if (this.number.number1 == null || this.number.number2 == null) {
      alert("Please Enter Number");
      return;
    }
    this.output = this._ser.calculatePercentage(this.number.number1, this.number.number2) + '%';
  }

  initForm() {
    this.number = {
      number1: null,
      number2: null
    }
    this.output = null;
  }

  onReset() {
    this.initForm();
  }

}
