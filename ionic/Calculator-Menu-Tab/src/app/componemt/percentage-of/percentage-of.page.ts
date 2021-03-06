import { Component, OnInit } from '@angular/core';
import { CalculateService } from 'src/app/service/mainservice/calculate.service';

@Component({
  selector: 'app-percentage-of',
  templateUrl: './percentage-of.page.html',
  styleUrls: ['./percentage-of.page.scss'],
})
export class PercentageOfPage implements OnInit {

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
    this.output = this._ser.xPercentageOfy(this.number.number1, this.number.number2);
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
