import { Injectable } from '@angular/core';
import { Storage } from '@ionic/storage';
import { IExpense } from '../interface/IExpense';
import { Observable } from 'rxjs';
import { IResponse } from '../interface/IResponse';

@Injectable({
  providedIn: 'root'
})
export class LocalstorageService {

  private expenseList: IExpense[];
  private keyName: string;
  constructor(private _storage: Storage) {
    this.expenseList = [];
    this.keyName = 'expenses';
  }

  // Storage method operation
  private getData() {
    return this._storage.get('expenses');
  }

  private saveExpense(data) {
    return this._storage.set('expenses', data);
  }



  // Service Operation.
  addExpense(expense): Observable<IResponse> {
    return new Observable((observe) => {
      if (this.expenseList == null) {
        this.expenseList = [];
      }
      this.expenseList.push(this.getRawDataWithId(this.create_UUID(), expense));
      console.log(this.expenseList);
      this.saveExpense(this.expenseList).then((resp) => {
        observe.next({ status: true, data: resp });
      }).catch((err) => {
        observe.error({ status: false, data: "failed to Save Data" + err })
      });
    });
  }

  getAll(): Observable<IResponse> {
    return new Observable((observe) => {
      if (this.expenseList.length == 0) {
        this.getData().then((data) => {
          if (this.expenseList == null) {
            this.expenseList = [];
          }
          this.expenseList = data;
          observe.next({ status: true, data: this.expenseList });
        }).catch((err) => {
          observe.error({ status: false, data: "err" });
        });
        return;
      }
      observe.next({ status: true, data: this.expenseList });
    });
  }

  updateExpense(expense: IExpense): Observable<IResponse> {
    return new Observable((observe) => {
      let index = this.findIndex(expense._id);
      if (index == -1) {
        observe.error({ status: false, data: "Request are failed" });
        return;
      }
      this.expenseList[index] = expense;
      this.saveExpense(this.expenseList).then((resp) => {
        observe.next({ status: true, data: "Updated" });
      }).catch((err) => {
        observe.error({ status: true, data: "Note Updated" });
      });
    });
  }

  getExpenseById(id: string): Observable<IResponse> {
    return new Observable((observe) => {
      let index = this.findIndex(id);
      if (index == -1) {
        observe.error({ status: false, data: "Expense not available in database" });
        return;
      }
      observe.next({ status: true, data: this.expenseList[index] });
    });
  }

  deleteExpense(id: string): Observable<IResponse> {
    return new Observable((observe) => {
      this.expenseList.splice(this.findIndex(id), 1);
      this.saveExpense(this.expenseList).then((resp) => {
        observe.next({ status: true, data: "deleted" });
      }).catch((err) => {
        observe.error({ status: false, data: err });
      });
    });
  }


  // Helpful Function used by CRUD Operation.
  private create_UUID() {
    var dt = new Date().getTime();
    var uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
      var r = (dt + Math.random() * 16) % 16 | 0;
      dt = Math.floor(dt / 16);
      return (c == 'x' ? r : (r & 0x3 | 0x8)).toString(16);
    });
    return uuid;
  }

  private getRawDataWithId(id: string, data) {
    return {
      _id: id,
      date: data.date,
      amount: data.amount,
      category: data.category,
      description: data.description
    };
  }

  private getRawDataWithoutId(data) {
    return {
      date: data.date,
      amount: data.amount,
      category: data.category,
      description: data.description
    };
  }

  private findIndex(id: string): number {
    for (let index = 0; index < this.expenseList.length; index++) {
      if (id == this.expenseList[index]._id) {
        return index;
      }
    }
    return -1
  }

}
