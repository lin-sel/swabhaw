import { Component, OnInit } from '@angular/core';
import { StorageService } from '../service/storage.service';
import { IExpense } from '../interface/IExpense';
import { Router } from '@angular/router';
import * as moment from 'moment';
import { IResponse } from '../interface/IResponse';
import { LocalstorageService } from '../service/localstorage.service';


@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {
  private expenses: IExpense[] = Array();
  constructor(private _ser: StorageService, private _router: Router) {
    this.getExpense();
  }

  ngOnInit() {
    console.log("on init");
    this.getExpense();
  }

  getExpense() {
    this._ser.getAll().subscribe((resp: IResponse) => {
      if (resp.status) {
        this.expenses = resp.data;
        return;
      }
      alert('Something wrong 12');
    }, (err: IResponse) => {
      console.warn(err.data);
      alert(err.data + " 13");
    });
  }

  redirect(expense) {
    console.log(expense);
    this._router.navigate(['/edit/' + expense]);
  }

  private dateFormat(date) {
    return moment(date).format("MMM DD, YYYY");
  }

}
