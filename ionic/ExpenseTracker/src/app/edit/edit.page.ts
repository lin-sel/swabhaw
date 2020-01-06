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
      _id: new FormControl(),
      date: new FormControl(),
      description: new FormControl(),
      category: new FormControl(),
      amount: new FormControl()
    });
  }

  getParameter() {
    this.getExpense(this._route.snapshot.paramMap.get('id'));
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

  getExpense(id: string) {
    this._ser.getExpenseById(id).subscribe((data: IExpense) => {
      console.log(data);
      this.expense = data[0];
      this.patchFormData();
    })
  }

  ngOnInit() {
  }

  patchFormData() {
    this.data.patchValue({
      _id: this.expense._id,
      date: this.expense.date,
      description: this.expense.description,
      category: this.expense.category,
      amount: this.expense.amount
    });
    console.log("inside log", this.data);
  }

  // updateExpense() {
  //   alert(this._ser.updateExpense(this.data.value).data);
  //   this._router.navigate(['/home']);
  // }

  updateExpense() {
    // alert(this._ser.updateExpense(this.data.value).data);
    this._ser.updateExpense(this.data.value).subscribe((data) => {
      console.log(typeof data);
      if (data == 1) {
        alert("update Successfully");
      }
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
      this._ser.deleteExpense(this.expense._id).subscribe((data) => {
        alert("Expense deleted");
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
