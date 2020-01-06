import { Component } from '@angular/core';
import { StorageService } from '../service/storage.service';
import { IExpense } from '../interface/IExpense';
import { Router } from '@angular/router';
import * as moment from 'moment';


@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
  private expenses: IExpense[] = Array();
  constructor(private _ser: StorageService, private _router: Router) {
    this.getExpense();
  }

  getExpense() {
    this._ser.getAll().subscribe((data: IExpense[]) => {
      console.log(data);
      alert(data[0].id + "" + data[1].id);
      this.expenses = data;
    }, (err) => {
      console.log(err);
      alert(err);
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
