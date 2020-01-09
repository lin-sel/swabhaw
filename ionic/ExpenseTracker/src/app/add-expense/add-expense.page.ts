import { Component, OnInit } from '@angular/core';
import { StorageService } from '../service/storage.service';
import { IExpense } from '../interface/IExpense';
import { Router } from '@angular/router';
import { Category } from '../interface/IExpense';
import { FormControl, FormGroup } from '@angular/forms';
import * as moment from 'moment';
import { LocalstorageService } from '../service/localstorage.service';

@Component({
  selector: 'app-add-expense',
  templateUrl: './add-expense.page.html',
  styleUrls: ['./add-expense.page.scss'],
})
export class AddExpensePage implements OnInit {
  private allExpense: IExpense[] = Array();
  private data: FormGroup;
  private category: string[];
  private currentdate: moment.Moment = moment();
  constructor(private _ser: LocalstorageService, private _router: Router) {
    this.initForm();
    // this.patchData();
    this.category = Category;
  }

  initForm() {
    this.data = new FormGroup({
      // id: new FormControl(),
      date: new FormControl(),
      amount: new FormControl(),
      category: new FormControl(),
      description: new FormControl()
    });
  }

  // patchData() {
  //   this.data.patchValue({
  //     id: 20,
  //   });
  // }

  ngOnInit() {
  }


  private addExpense() {
    this._ser.addExpense(this.data.value).subscribe((resp) => {
      alert("Added Expense");
    }, (err) => {
      alert(err.data);
    });
    this._router.navigate(['home']);
  }

  validateForm() {
    if (this.data.invalid) {
      alert("Please fill all data");
      return;
    }
    this.addExpense();
  }

}
