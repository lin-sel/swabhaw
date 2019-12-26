import { Component, OnInit } from '@angular/core';
import { MathService } from '../service/math.service';

@Component({
  selector: 'app-service-example',
  templateUrl: './service-example.component.html',
  styleUrls: ['./service-example.component.css']
})
export class ServiceExampleComponent implements OnInit {
  public num1: number;
  public num2: number;
  public action: string;
  constructor(private _mathService: MathService) { }

  ngOnInit() {
  }

  onChange(event) {
    if (this.action == 'add') {
      this._mathService.add(this.num1, this.num2);
      return;
    }
    else if (this.action == 'mul') {
      this._mathService.multiply(this.num1, this.num2);
      return;
    }
    else if (this.action == 'sub') {
      this._mathService.substract(this.num1, this.num2);
      return;
    }
    this._mathService.divide(this.num1, this.num2);
  }

}
