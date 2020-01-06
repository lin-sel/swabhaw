import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from "@angular/router";
import { IExpense, Category } from '../interface/IExpense';
import { StorageService } from '../service/storage.service';
import * as moment from 'moment';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.page.html',
  styleUrls: ['./edit.page.scss'],
})
export class EditPage implements OnInit {
  private expense: IExpense;
  private data: FormGroup;
  private category: string[];
  private currentdate: moment.Moment = moment();
  constructor(private _route: ActivatedRoute, private _ser: StorageService, private _router: Router) {
    this.initForm();
    this.getParameter();
    this.category = Category;
  }

  initForm() {
    this.data = new FormGroup({
      id: new FormControl(),
      date: new FormControl(),
      description: new FormControl(),
      category: new FormControl(),
      amount: new FormControl()
    });
  }

  getParameter() {
    this.getExpense(parseInt(this._route.snapshot.paramMap.get('id')));
  }

  // getExpense(id: number) {
  //   let resp = this._ser.getExpenseById(id);
  //   if (resp.status) {
  //     this.expense = resp.data;
  //     this.patchFormData();
  //     return;
  //   }
  //   alert(`${resp.data}`);
  // }

  getExpense(id: number) {
    this._ser.getExpenseById(id).subscribe((data: IExpense) => {
      console.log(data);
      this.expense = data;
      this.patchFormData();
    })
  }

  ngOnInit() {
  }

  patchFormData() {
    this.data.patchValue({
      id: this.expense.id,
      date: this.expense.date,
      description: this.expense.description,
      category: this.expense.category,
      amount: this.expense.amount
    });
  }

  // updateExpense() {
  //   alert(this._ser.updateExpense(this.data.value).data);
  //   this._router.navigate(['/home']);
  // }

  updateExpense() {
    // alert(this._ser.updateExpense(this.data.value).data);
    this._ser.updateExpense(this.data.value).subscribe((data) => {
      console.log(data);
      alert(data);
      this.redirect();
    }, (err) => {
      console.log(err);
      alert(err);
      this.redirect();
    });
    // alert(this._ser.updateExpense(this.data.value));
    // this._router.navigate(['/home']);
  }

  deleteExpense() {
    if (confirm("are you sure about this ?")) {
      this._ser.deleteExpense(this.expense.id).subscribe((data) => {
        console.log(data);
        alert(data);
        this.redirect();
      }, (err) => {
        alert(err);
        this.redirect();
      });
    }
  }

  redirect() {
    this._router.navigate(['/home']);
  }
}
