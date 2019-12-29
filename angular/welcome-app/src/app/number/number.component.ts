import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import * as moment from 'moment';

@Component({
  selector: 'app-number',
  templateUrl: './number.component.html',
  styleUrls: ['./number.component.css']
})
export class NumberComponent implements OnInit {
  public numberstatus = Array();
  public number: number;
  private url = 'http://numbersapi.com/';
  public filterCondition = false;
  public buttonst = false;
  public msg: string;


  constructor(private _httpService: HttpClient) { }

  ngOnInit() {
  }

  onClick() {
    this.buttonst = true;
    this.msg = null;
    if (this.checkNumber() == true) {
      this._httpService.get(this.url + this.number, { responseType: 'text' }).subscribe((data) => {
        this.numberstatus.push({ num: this.number, fact: data, time: moment() });
        this.buttonst = false;
      }, (error) => {
        console.log(error.message);
        this.buttonst = false;
      });
    } else {
      this.msg = "Already Have Number*";
      this.buttonst = false;
    }
  }

  private checkNumber(): boolean {
    for (let i = 0; i < this.numberstatus.length; i++) {
      if (this.numberstatus[i].num == this.number) {
        return false;
      }
    }
    return true;
  }
}
